// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.commands.Base.TimedCommand;
import frc.robot.subsystems.IntakeSubsystem;

public class PullTimedCommand extends TimedCommand {
  private final IntakeSubsystem intakeSubsystem;
  private final double power;

  public PullTimedCommand(IntakeSubsystem intakeSubsystem, double power, double time) {
    super(time);

    this.intakeSubsystem = intakeSubsystem;
    this.power = power;
    
    addRequirements(intakeSubsystem);
  }

  @Override
  public void execute() {
    intakeSubsystem.pull(power);
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.stop();
  }
}
