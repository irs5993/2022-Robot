// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.MecanumDriveMotorVoltages;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.subsystems.DrivetrainSubsystem;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveTeleopCommand;
import frc.robot.helpers.DriveValues;


public class RobotContainer {
  // Defining the joystick
  private final Joystick joystick = new Joystick(Constants.JOYSTICK);

  // Defining Subsystems 
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();

  // Defining Commands


  public RobotContainer() {
    configureButtonBindings();

    // Set the default command for subsystems
    drivetrainSubsystem.setDefaultCommand(new DriveTeleopCommand(drivetrainSubsystem, new DriveValues(joystick.getX(), joystick.getY(), joystick.getZ())));
  }

  private void configureButtonBindings() {}

  public Command getAutonomousCommand() {
    return new WaitCommand(2);
  }
}
