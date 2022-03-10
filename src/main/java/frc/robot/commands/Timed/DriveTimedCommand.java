// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Timed;

import frc.robot.commands.Base.TimedCommand;
import frc.robot.helpers.MecanumControlSupplier;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveTimedCommand extends TimedCommand {
  private final DrivetrainSubsystem drivetrainSubsystem;
  private final MecanumControlSupplier mecanumControlSupplier;

  public DriveTimedCommand(DrivetrainSubsystem drivetrainSubsystem, MecanumControlSupplier mecanumControlSupplier, double time) {
    super(time);
    
    this.drivetrainSubsystem = drivetrainSubsystem;
    this.mecanumControlSupplier = mecanumControlSupplier;

    addRequirements(drivetrainSubsystem);
  }

  @Override
  public void execute() {
    drivetrainSubsystem.drive(mecanumControlSupplier);
  }

  @Override
  public void end(boolean interrupted) {
    drivetrainSubsystem.stop();
  }
}
