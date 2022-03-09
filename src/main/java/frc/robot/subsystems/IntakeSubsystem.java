// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private final PWMVictorSPX motor;

  public IntakeSubsystem() {
    motor = new PWMVictorSPX(Constants.DriverPorts.Intake.MAIN);
  }

  public void pull(double power) {
    motor.set(power);
    
  }

  public void stop() {
    motor.stopMotor();
  }
  
}
