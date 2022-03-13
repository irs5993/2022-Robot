// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class ShootVisionCommand extends CommandBase {
  private final ShooterSubsystem shooterSubsystem;
  private final VisionSubsystem visionSubsystem;

  public ShootVisionCommand(ShooterSubsystem shooterSubsystem, VisionSubsystem visionSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    this.visionSubsystem = visionSubsystem;

    addRequirements(shooterSubsystem, visionSubsystem);
  }

  @Override
  public void execute() {
    double lowerPower = visionSubsystem.getLowerShooterPower();
    double upperPower = visionSubsystem.getUpperShooterPower();
    
    shooterSubsystem.shoot(lowerPower, upperPower);
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
