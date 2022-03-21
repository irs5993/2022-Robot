// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  private final PWMVictorSPX left_lower;
  private final PWMVictorSPX right_lower;
  private final PWMVictorSPX left_upper;
  private final PWMVictorSPX right_upper;

  private final MotorControllerGroup lower_shooter;
  private final MotorControllerGroup upper_shooter;

  public ShooterSubsystem() {
    left_lower = new PWMVictorSPX(Constants.DriverPorts.Shooter.LEFT_LOWER);
    right_lower = new PWMVictorSPX(Constants.DriverPorts.Shooter.RIGHT_LOWER);
    left_upper = new PWMVictorSPX(Constants.DriverPorts.Shooter.LEFT_UPPER);
    right_upper = new PWMVictorSPX(Constants.DriverPorts.Shooter.RIGHT_UPPER);

    left_lower.setInverted(true);
    right_lower.setInverted(true);

    left_upper.setInverted(true);

    lower_shooter = new MotorControllerGroup(left_lower, right_lower);
    upper_shooter = new MotorControllerGroup(left_upper, right_upper);
  }


  public void shoot(double lowerPower, double upperPower) {
    setLower(lowerPower);
    setUpper(upperPower);
  }

  public void setLower(double power) {
    lower_shooter.set(power);
  }

  public void setUpper(double power) {
    upper_shooter.set(power);
  }

  public void stopLower() {
    lower_shooter.stopMotor();
  }

  public void stopUpper() {
    upper_shooter.stopMotor();
  }

  public void stop() {
    stopLower();
    stopUpper();
  }

}
