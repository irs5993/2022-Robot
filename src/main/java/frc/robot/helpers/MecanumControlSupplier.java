package frc.robot.helpers;

public class MecanumControlSupplier {
    private double y;
    private double x;
    private double z;

    public MecanumControlSupplier(double y, double x, double z) {
        this.y = y;
        this.x = x;
        this.z = z;
    }

    public void multiply(double value) {
        y *= value;
        x *= value;
        z *= value;
    }

    public void set(double y, double x, double z) {
        this.y = y;
        this.x = x;
        this.z = z;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public double getZ() {
        return z;
    }
}
