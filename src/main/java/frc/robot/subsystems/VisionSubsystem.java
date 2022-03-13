// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.helpers.RMath;

public class VisionSubsystem extends SubsystemBase {
  private NetworkTable table;
  private final double[] defaultValue = {};

  private double[] xRaw;
  private double[] yRaw;

  private boolean targetFound = false;
  private double targetX;
  private double targetY;    

  public VisionSubsystem() {
    table = NetworkTableInstance.getDefault().getTable("GRIP/Vision");
  }

  public boolean isTargetFound() {
    return targetFound;
  }

  public double getTargetXPosition() {
    return targetX;
  }

  public double getTargetYPosition() {
    return targetY;
    
  }

  public double getLowerShooterPower() {
    double power = RMath.map(targetY, 40, 80, 0.3, 0.6);
    return power;
  }

  public double getUpperShooterPower() {
    double power = RMath.map(targetY, 40, 80, 0.4, 0.2);
    return power;
  }

  private boolean deduceVisibility() {
    if (xRaw.length > 0 && yRaw.length > 0) {
      targetX = xRaw[0];
      targetY = yRaw[0];
      return true;
    } 

    return false;   
  }


  @Override
  public void periodic() {
    xRaw = table.getEntry("centerX").getDoubleArray(defaultValue);
    yRaw = table.getEntry("centerY").getDoubleArray(defaultValue);
    targetFound = deduceVisibility();
  }
}
