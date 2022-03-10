// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
  public VisionSubsystem() {}

  public double getTargetPosition() {
    double position = 50;

    return position;
  }

  public double getLowerShooterPower() {
    double power = 0;
    return power;
  }

  public double getUpperShooterPower() {
    double power = 0;
    return power;
  }

  @Override
  public void periodic() {
  }
}
