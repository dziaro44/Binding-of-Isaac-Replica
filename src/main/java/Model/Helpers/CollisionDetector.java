package Model.Helpers;

public class CollisionDetector {
    public static boolean isCollision(PhysicalObject firstObject, PhysicalObject secondObject) {

        Coordinates firstCoordinates = firstObject.getCoordinates();
        Coordinates secondCoordinates = secondObject.getCoordinates();

        double distance = firstCoordinates.distanceFrom(secondCoordinates);
        double radiusSum = firstObject.getShape().getRadius() + secondObject.getShape().getRadius();

        return distance < radiusSum;
    }
}
