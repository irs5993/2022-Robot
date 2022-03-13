// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.helpers.MecanumControlSupplier;
import frc.robot.helpers.RMath;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class LockTargetCommand extends CommandBase {
  private final DrivetrainSubsystem drivetrainSubsystem;
  private final VisionSubsystem visionSubsystem;
  private boolean isCentered = false;

  private final double cameraWidth = 180;
  private final double errorAllowance = 6;

  private final double minMotorOutput = 0.3;
  private final double maxMotorOutput= 0.7;

  public LockTargetCommand(DrivetrainSubsystem drivetrainSubsystem, VisionSubsystem visionSubsystem) {
    this.drivetrainSubsystem = drivetrainSubsystem;
    this.visionSubsystem = visionSubsystem;

    addRequirements(drivetrainSubsystem, visionSubsystem);
  }

  @Override
  public void execute() {
    // Get the target position from the vision subsystem
    double targetPosition = visionSubsystem.getTargetXPosition();

    if(targetPosition >= cameraWidth/2 - errorAllowance/2 && targetPosition <= cameraWidth/2 + errorAllowance/2) {
      isCentered = true;
    } else {
      MecanumControlSupplier supplier = new MecanumControlSupplier(0, 0, 0);
      double rotation = RMath.map(targetPosition, 0, cameraWidth, maxMotorOutput, -maxMotorOutput);

      if (Math.abs(rotation) < minMotorOutput) {
        rotation = Math.signum(rotation) * minMotorOutput;
      }

      supplier.setZ(rotation);
      drivetrainSubsystem.drive(supplier);
    }
    
  }

  @Override
  public void end(boolean interrupted) {
    drivetrainSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return isCentered;
  }
}
