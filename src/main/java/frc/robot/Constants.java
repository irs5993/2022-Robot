// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int JOYSTICK = 0;

    public static class ButtonMap {}

    public static class DriverPorts {
        public static class Drivetrain {
            public static final int 
            LEFT_FRONT = 2,
            LEFT_REAR = 0,
            RIGHT_FRONT = 1,
            RIGHT_REAR = 3;
        }

        public static class Intake {
            public static final int 
            MAIN = 4;
        }

        public static class Conveyor {
            public static final int 
            MAIN = 5;
        }

        public static class Shooter {
            public static final int 
            LEFT_LOWER = 6,
            RIGHT_LOWER = 7,
            LEFT_UPPER = 8,
            RIGHT_UPPER = 9;
        }

        public static class ClimbRotator {
            public static final int 
            MAIN = 10;
        }

        public static class Climber {
            public static final int 
            LEFT = 11,
            RIGHT = 12;
        }

        public static class ArmRelease {
            public static final int 
            MAIN = 13;
        }
    }
}
