// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DrivetrainSubsystem;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveTeleopCommand;
import frc.robot.commands.DriveTimedCommand;
import frc.robot.helpers.MecanumControlSupplier;


public class RobotContainer {
  // Defining the joystick
  public static final Joystick joystick = new Joystick(Constants.JOYSTICK);

  // Defining subsystems 
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();

  // Defining commands
  private final DriveTimedCommand autoTest1 = new DriveTimedCommand(drivetrainSubsystem, new MecanumControlSupplier(0.5, 0, 0), 5);
  private final DriveTimedCommand autoTest2 = new DriveTimedCommand(drivetrainSubsystem, new MecanumControlSupplier(-0.5, 0, 0), 5);
  private final DriveTimedCommand autoTest3 = new DriveTimedCommand(drivetrainSubsystem, new MecanumControlSupplier(0, 0, 0.6), 5);
  SendableChooser<Command> autoChooser = new SendableChooser<>();
  
  public RobotContainer() {
    configureButtonBindings();
    configureCommands();
    configureDashboard();   
  }

  private void configureButtonBindings() {}

  public void configureCommands() {
    // Setting up the auto chooser
    autoChooser.setDefaultOption("Drive Forward", autoTest1);
    autoChooser.addOption("Drive Backward", autoTest2);
    autoChooser.addOption("Turn Right", autoTest3);

    // Setting the default commands of the subsystems
    drivetrainSubsystem.setDefaultCommand(new DriveTeleopCommand(drivetrainSubsystem, joystick));
  }

  public void configureDashboard() {
    SmartDashboard.putData(autoChooser);
    SmartDashboard.putData("Drivetrain Subsystem", drivetrainSubsystem);
  }

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }
}
