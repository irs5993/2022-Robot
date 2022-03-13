// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Timed;

import frc.robot.commands.Base.TimedCommand;
import frc.robot.subsystems.ConveyorSubsystem;

public class RunConveyorTimedCommand extends TimedCommand {
  private final ConveyorSubsystem conveyorSubsystem;
  private final double power;

  public RunConveyorTimedCommand(ConveyorSubsystem conveyorSubsystem, double power, double time) {
    super(time);

    this.conveyorSubsystem = conveyorSubsystem;
    this.power = power;
    
    addRequirements(conveyorSubsystem);
  }

  @Override
  public void execute() {
    conveyorSubsystem.run(power);
  }

  @Override
  public void end(boolean interrupted) {
    conveyorSubsystem.stop();
  }
}
