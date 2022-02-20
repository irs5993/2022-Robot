package frc.robot.helpers;

public class MecanumControlSupplier {
    // initialize variables x, y, z as doublesuppliers for the x, y, and z values of the joystick
    private double x;
    private double y;
    private double z;

    public MecanumControlSupplier(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void multiply(double value) {
        x *= value;
        y *= value;
        z *= value;
    }

    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
