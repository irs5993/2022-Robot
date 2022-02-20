// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.helpers.RMath;

import frc.robot.helpers.MecanumControlSupplier;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveTeleopCommand extends CommandBase {
  private final DrivetrainSubsystem drivetrainSubsystem;
  private final MecanumControlSupplier mecanumControlSupplier;
  private final double slider;

  private final double
    min_mult = 0.3,
    max_mult = 1.0;

  public DriveTeleopCommand(DrivetrainSubsystem drivetrainSubsystem, MecanumControlSupplier mecanumControlSupplier, double slider) {
    this.drivetrainSubsystem = drivetrainSubsystem;
    this.mecanumControlSupplier = mecanumControlSupplier;
    this.slider = slider;

    addRequirements(drivetrainSubsystem);
  }

  @Override
  public void execute() {
    double multiplier = RMath.map(slider, 0, 1, min_mult, max_mult);
    mecanumControlSupplier.multiply(multiplier);

    drivetrainSubsystem.drive(mecanumControlSupplier);
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
