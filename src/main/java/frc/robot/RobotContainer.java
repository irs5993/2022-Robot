// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ArmReleaseSubsystem;
import frc.robot.subsystems.ClimbRotatorSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.Constants.DriverPorts.ArmRelease;
import frc.robot.commands.AdjustableShooterCommand;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.DriveTeleopCommand;
import frc.robot.commands.LockTargetCommand;
import frc.robot.commands.PullCommand;
import frc.robot.commands.ReleaseArmCommand;
import frc.robot.commands.RotateClimberCommand;
import frc.robot.commands.RunConveyorCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.ShootVisionCommand;
import frc.robot.commands.Timed.PullTimedCommand;
import frc.robot.commands.Timed.RunConveyorTimedCommand;
import frc.robot.commands.Timed.ShootTimedCommand;
import frc.robot.commands.Timed.ShootVisionTimedCommand;
import frc.robot.commands.Timed.DriveTimedCommand;

import frc.robot.helpers.MecanumControlSupplier;


public class RobotContainer {
  // Defining the joystick
  public static final Joystick joystick = new Joystick(Constants.JOYSTICK);

  // Defining subsystems 
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ConveyorSubsystem conveyorSubsystem = new ConveyorSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  private final ClimbRotatorSubsystem climbRotatorSubsystem = new ClimbRotatorSubsystem();
  private final ArmReleaseSubsystem armReleaseSubsystem = new ArmReleaseSubsystem();
  private final VisionSubsystem visionSubsystem = new VisionSubsystem();

  // Defining commands
  private final SequentialCommandGroup defaultAuto = new SequentialCommandGroup(
    new ParallelCommandGroup(
      new RunConveyorTimedCommand(conveyorSubsystem, -0.7, 0.7)
    ),
    new WaitCommand(1.5),
    new ParallelCommandGroup(   
      new DriveTimedCommand(drivetrainSubsystem, new MecanumControlSupplier(0.33, 0, 0), 2.5),
      new PullTimedCommand(intakeSubsystem, 0.7, 2.5),
      new RunConveyorTimedCommand(conveyorSubsystem, 0.5, 2.5)
    ),
    new WaitCommand(0.5),
    new ParallelCommandGroup(
      new ShootTimedCommand(shooterSubsystem, -0.7, Constants.FEEDER_POWER, 10),
      new SequentialCommandGroup(
        new WaitCommand(2.5), 
        new SequentialCommandGroup(
          new ParallelCommandGroup(
            new PullTimedCommand(intakeSubsystem, 0.8, 1.5), 
            new RunConveyorTimedCommand(conveyorSubsystem, 0.4, 1.5)
          ),
          new WaitCommand(3.2),
          new ParallelCommandGroup(
            new PullTimedCommand(intakeSubsystem, 0.8, 1.5), 
            new RunConveyorTimedCommand(conveyorSubsystem, 0.4, 1.5)
          )
        )
      )
    )
  );

  

  SendableChooser<Command> autoChooser = new SendableChooser<>();

  public RobotContainer() {
    configureButtonBindings();
    configureCommands();
    configureDashboard();   
  }

  private void configureButtonBindings() {
    new JoystickButton(joystick, 1).whileHeld(new ShootCommand(shooterSubsystem, -0.8, Constants.FEEDER_POWER));
        
    new JoystickButton(joystick, 9).toggleWhenActive(new LockTargetCommand(drivetrainSubsystem, visionSubsystem));
  
    new JoystickButton(joystick, 3).whileHeld(
      new ParallelCommandGroup(
        new PullCommand(intakeSubsystem, 0.75),  
        new RunConveyorCommand(conveyorSubsystem, 0.75)
      )
    );

    new JoystickButton(joystick, 5).whileHeld(
      new ParallelCommandGroup(
        new PullCommand(intakeSubsystem, -0.75),  
        new RunConveyorCommand(conveyorSubsystem, -0.75)
      )
    );

    new JoystickButton(joystick, 4).whileHeld(new RunConveyorCommand(conveyorSubsystem, 1));
    new JoystickButton(joystick, 6).whileHeld(new RunConveyorCommand(conveyorSubsystem, -1));
    
    // new JoystickButton(joystick, 1).whileHeld(new ShootCommand(shooterSubsystem, -0.43, -0.14));
    
    // new JoystickButton(joystick, 9).whileHeld(new AdjustableShooterCommand(shooterSubsystem, joystick));

    // new JoystickButton(joystick, 10).whileHeld(new ShootCommand(shooterSubsystem, -0.28, -0.36));
    // new JoystickButton(joystick, 8).whileHeld(new ShootVisionCommand(shooterSubsystem, visionSubsystem));

    //new JoystickButton(joystick, 11).whileHeld(new RotateClimberCommand(climbRotatorSubsystem, 0.35));
    //new JoystickButton(joystick, 12).whileHeld(new RotateClimberCommand(climbRotatorSubsystem, -0.35));

    // new JoystickButton(joystick, 7).whileHeld(new ReleaseArmCommand(armReleaseSubsystem, 0.8));
    // new JoystickButton(joystick, 8).whileHeld(new ReleaseArmCommand(armReleaseSubsystem, -0.8));

    //new JoystickButton(joystick, 2).whileHeld(new ReleaseArmCommand(armReleaseSubsystem, -0.8));

    // Set to be uninterruptable so that the other commands does not interfere. 
    // new JoystickButton(joystick, 4).toggleWhenPressed(new SequentialCommandGroup(
    //   new LockTargetCommand(drivetrainSubsystem, visionSubsystem),
    //   new ParallelCommandGroup(
    //     new ShootVisionTimedCommand(shooterSubsystem, visionSubsystem, 5),
    //     new SequentialCommandGroup(new WaitCommand(3),  new RunConveyorTimedCommand(conveyorSubsystem, 0.75, 2))
    //   )
    // ), false);
  }

  public void configureCommands() {
    // Setting up the auto chooser
    autoChooser.setDefaultOption("Default Command", defaultAuto);

    // Setting the default commands of the subsystems
    drivetrainSubsystem.setDefaultCommand(new DriveTeleopCommand(drivetrainSubsystem, joystick));
  }

  public void configureDashboard() {
    CameraServer.startAutomaticCapture();

    SmartDashboard.putData(autoChooser);
    SmartDashboard.putData("Drivetrain Subsystem", drivetrainSubsystem);
  }

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }
}
