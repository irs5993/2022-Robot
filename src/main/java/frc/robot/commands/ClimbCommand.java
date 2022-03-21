// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimbCommand extends CommandBase {
  private final ClimberSubsystem climberSubsystem;
  private final double power;

  public ClimbCommand(ClimberSubsystem climberSubsystem, double power) {
    this.climberSubsystem = climberSubsystem;
    this.power = power;

    addRequirements(climberSubsystem);
  }

  @Override
  public void execute() {
    climberSubsystem.climb(power);
    System.out.println(power);
  }

  @Override
  public void end(boolean interrupted) {
    climberSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
