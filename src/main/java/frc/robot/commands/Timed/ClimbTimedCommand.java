// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Timed;

import frc.robot.commands.Base.TimedCommand;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimbTimedCommand extends TimedCommand {
  private final ClimberSubsystem climberSubsystem;
  private final double power;

  public ClimbTimedCommand(ClimberSubsystem climberSubsystem, double power, double time) {
    super(time);

    this.climberSubsystem = climberSubsystem;
    this.power = power;

    addRequirements(climberSubsystem);
  }

  @Override
  public void execute() {
    climberSubsystem.climb(power);
  }

  @Override
  public void end(boolean interrupted) {
    climberSubsystem.stop();
  }
}
