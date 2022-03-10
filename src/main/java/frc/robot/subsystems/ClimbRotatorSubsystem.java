// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbRotatorSubsystem extends SubsystemBase {
  private final PWMVictorSPX left_motor;
  private final PWMVictorSPX right_motor;
  private final MotorControllerGroup rotator;



  public ClimbRotatorSubsystem() {
    left_motor = new PWMVictorSPX(Constants.DriverPorts.ClimbRotator.LEFT);
    right_motor = new PWMVictorSPX(Constants.DriverPorts.ClimbRotator.RIGHT);

    right_motor.setInverted(true);

    rotator = new MotorControllerGroup(left_motor, right_motor);
  }

  public void rotate(double power) {
    rotator.set(power);
  }

  public void stop() {
    rotator.stopMotor();
  }
}
