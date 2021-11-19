package Model.Helpers;

import Model.Helpers.Coordinates;
import Model.Helpers.Shape;

public interface PhysicalObject {
    Coordinates getCoordinates();
    void setCoordinates(Coordinates coordinates);
    Shape getShape();
}
