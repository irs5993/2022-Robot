package frc.robot.helpers;

public class RMath {
    public static double map(double x, double in_min, double in_max, double out_min, double out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    public static double deadband(double value, double limit) {
        return Math.abs(value) > limit ? value : 0;
    }
}
