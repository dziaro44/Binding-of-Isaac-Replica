package Model.Helpers;

public abstract class PhysicalObjectImpl implements PhysicalObject {
    protected Coordinates coordinates;
    protected Shape shape;

    public PhysicalObjectImpl(Coordinates coordinates, Shape shape) {
        this.coordinates = coordinates;
        this.shape = shape;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
