package Summary_of_Interview_Problem.math;

public class RandPoint {

    private double x_center;
    private double y_center;
    private double radius;

    public RandPoint(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double d = radius * Math.sqrt(Math.random());
        double theta = Math.random() * 2 * Math.PI;
        return new double[]{d * Math.cos(theta) + x_center, d * Math.sin(theta) + y_center};
    }
}
