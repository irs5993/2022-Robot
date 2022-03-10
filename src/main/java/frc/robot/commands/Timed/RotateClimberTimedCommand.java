// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Timed;

import frc.robot.commands.Base.TimedCommand;
import frc.robot.subsystems.ClimbRotatorSubsystem;

public class RotateClimberTimedCommand extends TimedCommand {
  private final ClimbRotatorSubsystem climbRotatorSubsystem;
  private final double power;

  public RotateClimberTimedCommand(ClimbRotatorSubsystem climbRotatorSubsystem, double power, double time) {
    super(time);

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
}
