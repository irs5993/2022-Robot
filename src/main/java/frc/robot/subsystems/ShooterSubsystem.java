// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  private final PWMVictorSPX left_lower;
  private final PWMVictorSPX right_lower;
  private final PWMVictorSPX left_upper;
  private final PWMVictorSPX right_upper;


  public ShooterSubsystem() {
    left_lower = new PWMVictorSPX(Constants.DriverPorts.Shooter.LEFT_LOWER);
    right_lower = new PWMVictorSPX(Constants.DriverPorts.Shooter.RIGHT_LOWER);
    left_upper = new PWMVictorSPX(Constants.DriverPorts.Shooter.LEFT_UPPER);
    right_upper = new PWMVictorSPX(Constants.DriverPorts.Shooter.RIGHT_UPPER);
  }

  public void setLower(double power) {
    left_lower.set(power);
    right_lower.set(-power);
  }

  public void setUpper(double power) {
    left_upper.set(power);
    right_upper.set(-power);
  }

}
