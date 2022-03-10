// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {
  private final PWMVictorSPX left_motor;
  private final PWMVictorSPX right_motor;
  private final MotorControllerGroup climber;

  public ClimberSubsystem() {
    left_motor = new PWMVictorSPX(Constants.DriverPorts.Climber.LEFT);
    right_motor = new PWMVictorSPX(Constants.DriverPorts.Climber.RIGHT);

    climber = new MotorControllerGroup(left_motor, right_motor);
  }

  public void climb(double power) {
    climber.set(power);
  }

  public void stop() {
    climber.stopMotor();
  }
}
