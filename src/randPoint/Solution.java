package randPoint;

import java.util.Random;

public class Solution {
    double radius, x_center, y_center;
    Random random;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        random = new Random();
    }

    public double[] randPoint() {
        double x, y;
        while (true) {
            x = random.nextDouble() * 2 * radius - radius;
            y = random.nextDouble() * 2 * radius - radius;
            if (x * x + y * y <= radius * radius) {
                return new double[] { x + x_center, y + y_center };
            }
        }
    }
}
