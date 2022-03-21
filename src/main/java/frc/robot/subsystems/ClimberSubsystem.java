// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {
  private final PWMVictorSPX left_motor;
  private final PWMVictorSPX right_motor;
  private final MotorControllerGroup climber;

  private final DigitalInput left_switch;
  private final DigitalInput right_switch;

  public ClimberSubsystem() {
    left_motor = new PWMVictorSPX(Constants.DriverPorts.Climber.LEFT);
    right_motor = new PWMVictorSPX(Constants.DriverPorts.Climber.RIGHT);

    left_switch = new DigitalInput(0);
    right_switch = new DigitalInput(1);

    climber = new MotorControllerGroup(left_motor, right_motor);
  }

  public void climb(double power) {
    if (isLocked()) {
      power = Math.max(power, 0);
    } 
    climber.set(power);
  }

  public void setLeftPower(double power) {
    left_motor.set(power);
  }

  public void setRightPower(double power) {
    right_motor.set(power);
  }



  public boolean isLocked() {
   // return getLeftSwitchStatus() || getRightSwitchStatus();
   return false;
  }

  public boolean getLeftSwitchStatus() { 
    return left_switch.get();
  }

  public boolean getRightSwitchStatus() { 
    return right_switch.get();
  }

  public void stop() {
    climber.stopMotor();
  }
}
