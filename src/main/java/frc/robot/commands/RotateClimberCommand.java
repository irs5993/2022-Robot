// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbRotatorSubsystem;

public class RotateClimberCommand extends CommandBase {
  private final ClimbRotatorSubsystem climbRotatorSubsystem;
  private final double power;

  public RotateClimberCommand(ClimbRotatorSubsystem climbRotatorSubsystem, double power) {
    this.climbRotatorSubsystem = climbRotatorSubsystem;
    this.power = power;

    addRequirements(climbRotatorSubsystem);
  }

  @Override
  public void execute() {
    climbRotatorSubsystem.rotate(power);
  }

  @Override
  public void end(boolean interrupted) {
    climbRotatorSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
