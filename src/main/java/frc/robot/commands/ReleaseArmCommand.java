// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmReleaseSubsystem;

public class ReleaseArmCommand extends CommandBase {
  private final ArmReleaseSubsystem armReleaseSubsystem;
  private final double power;

  public ReleaseArmCommand(ArmReleaseSubsystem armReleaseSubsystem, double power) {
    this.armReleaseSubsystem = armReleaseSubsystem;
    this.power = power;

    addRequirements(armReleaseSubsystem);
  }

  @Override
  public void execute() {
    armReleaseSubsystem.rotate(power);
  }

  @Override
  public void end(boolean interrupted) {
    armReleaseSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
