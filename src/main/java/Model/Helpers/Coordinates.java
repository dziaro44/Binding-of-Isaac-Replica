package Model.Helpers;

import static Model.Helpers.Direction.*;

public class Coordinates {
    private double x;
    private double y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceFrom(Coordinates cd) {
        return Math.sqrt((cd.x-x)*(cd.x-x)+(cd.y-y)*(cd.y-y));
    }

    private void mul(double t) {
        x *= t;
        y *= t;
    }

    private void add(Coordinates add_cd) {
        x += add_cd.x;
        y += add_cd.y;
    }

    public Coordinates getNewCoordinates(Direction direction, double distance) throws NullDirectionException {
        Coordinates resultCoordinates;
        double p2 = Math.sqrt(2) / 2;

        if (direction == UP) resultCoordinates = new Coordinates(0, 1);
        else if (direction == RIGHT_UP) resultCoordinates = new Coordinates(p2, p2);
        else if (direction == RIGHT) resultCoordinates = new Coordinates(1, 0);
        else if (direction == RIGHT_DOWN) resultCoordinates = new Coordinates(p2, -p2);
        else if (direction == DOWN) resultCoordinates = new Coordinates(0, -1);
        else if (direction == LEFT_DOWN) resultCoordinates = new Coordinates(-p2, -p2);
        else if (direction == LEFT) resultCoordinates = new Coordinates(-1, 0);
        else if (direction == LEFT_UP) resultCoordinates = new Coordinates(-p2, p2);
        else throw new NullDirectionException();

        resultCoordinates.mul(distance);
        resultCoordinates.add(this);

        return resultCoordinates;
    }
}
