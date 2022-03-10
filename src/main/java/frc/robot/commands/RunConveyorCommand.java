// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ConveyorSubsystem;

public class RunConveyorCommand extends CommandBase {
  private final ConveyorSubsystem conveyorSubsystem;
  private final double power;

  public RunConveyorCommand(ConveyorSubsystem conveyorSubsystem, double power) {
    this.conveyorSubsystem = conveyorSubsystem;
    this.power = power;
    
    addRequirements(conveyorSubsystem);
  }

  @Override
  public void execute() {
    conveyorSubsystem.run(power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    conveyorSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
