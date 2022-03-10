// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Timed;

import frc.robot.commands.Base.TimedCommand;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootTimedCommand extends TimedCommand {
  private final ShooterSubsystem shooterSubsystem;
  private final double lowerPower, upperPower;

  public ShootTimedCommand(ShooterSubsystem shooterSubsystem, double lowerPower, double upperPower, double time) {
    super(time);

    this.shooterSubsystem = shooterSubsystem;
    this.lowerPower = lowerPower;
    this.upperPower = upperPower;

    addRequirements(shooterSubsystem);
  }

  @Override
  public void execute() {
    shooterSubsystem.shoot(lowerPower, upperPower);
  }

  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.stop();
  }
}
