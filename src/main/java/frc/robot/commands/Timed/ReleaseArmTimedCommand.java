// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Timed;

import frc.robot.commands.Base.TimedCommand;
import frc.robot.subsystems.ArmReleaseSubsystem;

public class ReleaseArmTimedCommand extends TimedCommand {
  private final ArmReleaseSubsystem armReleaseSubsystem;
  private final double power;

  public ReleaseArmTimedCommand(ArmReleaseSubsystem armReleaseSubsystem, double power, double time) {
    super(time);

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
}
