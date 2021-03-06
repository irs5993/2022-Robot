// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.helpers.RMath;

public class VisionSubsystem extends SubsystemBase {
  private NetworkTable table;
  private final double[] defaultValue = {};

  private double[] xRaw;
  private double[] yRaw;

  private double targetX;
  private double targetY;    

  public VisionSubsystem() {
    table = NetworkTableInstance.getDefault().getTable("GRIP/Vision");
  }

  public boolean isTargetFound() {
    return xRaw.length > 0 && yRaw.length > 0;
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

  private double[] calculateTargetCenter() {
    double tx, ty;

    if (xRaw.length % 2 == 0) {
      tx = (xRaw[xRaw.length / 2] + xRaw[xRaw.length / 2 - 1]) / 2;
      ty = (yRaw[yRaw.length / 2] + yRaw[yRaw.length / 2 - 1]) / 2;
    } else {
      tx = xRaw.length > 1 ? xRaw[(xRaw.length - 1) / 2] : xRaw[0];
      ty = yRaw.length > 1 ? yRaw[(yRaw.length - 1) / 2] : yRaw[0];
    }

    return new double[] {tx, ty};
  }


  @Override
  public void periodic() {
    xRaw = table.getEntry("centerX").getDoubleArray(defaultValue);
    yRaw = table.getEntry("centerY").getDoubleArray(defaultValue);

    if (isTargetFound()) {
      double[] target = calculateTargetCenter();
      targetX = target[0];
      targetY = target[1];

      SmartDashboard.putNumber("Target X", targetX);
      SmartDashboard.putNumber("Target Y", targetY);
    }
  }
}
