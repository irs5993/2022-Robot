// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.helpers.RMath;
import frc.robot.subsystems.ShooterSubsystem;

public class AdjustableShooterCommand extends CommandBase {
  private final ShooterSubsystem shooterSubsystem;
  private final Joystick joystick;

  public AdjustableShooterCommand(ShooterSubsystem shooterSubsystem, Joystick joystick) {
    this.shooterSubsystem = shooterSubsystem;
    this.joystick = joystick;

    addRequirements(shooterSubsystem);
  }

  @Override
  public void execute() {
    double power = -RMath.map(joystick.getRawAxis(3), 1, -1, 0.2, 1);
    shooterSubsystem.shoot(power, Constants.FEEDER_POWER);
    SmartDashboard.putNumber("Shooting Power", power);


  }

  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
