// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {
  private final PWMVictorSPX left_front;
  private final PWMVictorSPX right_front;
  private final PWMVictorSPX left_rear;
  private final PWMVictorSPX right_rear;

  private final MecanumDrive drive_base;

  public DrivetrainSubsystem() {
    left_front = new PWMVictorSPX(Constants.DriverPorts.Drivetrain.LEFT_FRONT);
    left_rear = new PWMVictorSPX(Constants.DriverPorts.Drivetrain.LEFT_REAR);
    right_front = new PWMVictorSPX(Constants.DriverPorts.Drivetrain.RIGHT_FRONT);
    right_rear = new PWMVictorSPX(Constants.DriverPorts.Drivetrain.RIGHT_REAR);

    drive_base = new MecanumDrive(left_front, left_rear, right_front, right_rear);
  }

  public void drive(double x, double y, double z) {
    drive_base.driveCartesian(x, y, z);
  }

  public void stop() {
    drive_base.stopMotor();
  }
}
