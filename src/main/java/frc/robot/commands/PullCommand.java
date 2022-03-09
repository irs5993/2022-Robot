// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class PullCommand extends CommandBase {
  private final IntakeSubsystem intakeSubsystem;
  private final double power;

  public PullCommand(IntakeSubsystem intakeSubsystem, double power) {
    this.intakeSubsystem = intakeSubsystem;
    this.power = power;
    
    addRequirements(intakeSubsystem);
  }

  @Override
  public void execute() {
    intakeSubsystem.pull(power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
