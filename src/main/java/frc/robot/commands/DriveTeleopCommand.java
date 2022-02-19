// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.helpers.MecanumControlSupplier;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveTeleopCommand extends CommandBase {
  private final DrivetrainSubsystem drivetrainSubsystem;
  private final MecanumControlSupplier mecanumControlSupplier;

  public DriveTeleopCommand(DrivetrainSubsystem drivetrainSubsystem, MecanumControlSupplier mecanumControlSupplier) {
    this.drivetrainSubsystem = drivetrainSubsystem;
    this.mecanumControlSupplier = mecanumControlSupplier;

    addRequirements(drivetrainSubsystem);
  }

  @Override
  public void execute() {
    drivetrainSubsystem.drive(mecanumControlSupplier.getX(), mecanumControlSupplier.getY(), mecanumControlSupplier.getZ());
  }

  @Override
  public void end(boolean interrupted) {
    drivetrainSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
