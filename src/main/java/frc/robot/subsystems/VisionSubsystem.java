// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class VisionSubsystem extends SubsystemBase {
  private final PWMVictorSPX LED;

  public VisionSubsystem() {
    LED = new PWMVictorSPX(Constants.DriverPorts.VISION_LED);
  }

  public double getTargetPosition() {
    // Return the GRIP information from the camera
    double position = 50;

    return position;
  }

  public void enableLED() {
    LED.set(1);
  }

  public void disableLED() {
    LED.set(0);
  }
 
  public void setLEDVoltage(double voltage) {
    LED.set(voltage);
  }

  @Override
  public void periodic() {
  }
}
