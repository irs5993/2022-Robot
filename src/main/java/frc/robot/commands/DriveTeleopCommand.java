// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.helpers.RMath;

import frc.robot.helpers.MecanumControlSupplier;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveTeleopCommand extends CommandBase {
  private final DrivetrainSubsystem drivetrainSubsystem;
  private final Joystick joystick;

  private final SlewRateLimiter filter;

  private final double
    min_mult = 0.3,
    max_mult = 1.0;
  private final double stick_deadzone = 0.1;

  public DriveTeleopCommand(DrivetrainSubsystem drivetrainSubsystem, Joystick joystick) {
    this.drivetrainSubsystem = drivetrainSubsystem;
    this.joystick = joystick;
    filter = new SlewRateLimiter(0.4);

    addRequirements(drivetrainSubsystem);
  }

  @Override
  public void execute() {
    MecanumControlSupplier supplier = new MecanumControlSupplier(joystick.getY(), -joystick.getX(), -joystick.getZ());
   
    // Map the joystick slider between [min_mult, max_mult]
    double multiplier = RMath.map(joystick.getRawAxis(3), 1, -1, min_mult, max_mult);
    supplier.multiply(multiplier);

    // Applying deadband to the joystick
    supplier.setZ(RMath.deadband(supplier.getZ(), stick_deadzone));

    // Applying the slew rate filter to the joystick
    supplier.setY(filter.calculate(supplier.getY()));
    supplier.setX(filter.calculate(supplier.getX()));
    supplier.setZ(filter.calculate(supplier.getZ()));

    drivetrainSubsystem.drive(supplier);
  }

  @Override
  public void end(boolean interrupted) {
    drivetrainSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
