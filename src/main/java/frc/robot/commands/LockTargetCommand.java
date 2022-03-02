// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class LockTargetCommand extends CommandBase {
  private final DrivetrainSubsystem drivetrainSubsystem;
  private final VisionSubsystem visionSubsystem;
  private boolean isCentered = false;

  private final double cameraWidth = 180;

  public LockTargetCommand(DrivetrainSubsystem drivetrainSubsystem, VisionSubsystem visionSubsystem) {
    this.drivetrainSubsystem = drivetrainSubsystem;
    this.visionSubsystem = visionSubsystem;

    addRequirements(drivetrainSubsystem, visionSubsystem);
  }

  @Override
  public void execute() {
    // Make sure that the LED is on
    visionSubsystem.enableLED();

    // Get the target position from the vision subsystem
    double targetPosition = visionSubsystem.getTargetPosition();

    // Determine if the target is in the center of the camera
    // If not, rotate the robot to face the target
    // When centered, change the variable "isCentered" to true
  }

  @Override
  public void end(boolean interrupted) {
    drivetrainSubsystem.stop();
    visionSubsystem.disableLED();
  }

  @Override
  public boolean isFinished() {
    return isCentered;
  }
}
