package View;

import Model.Helpers.Constants;
import Model.Helpers.Coordinates;
import Model.Helpers.PhysicalObject;
import Model.Helpers.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Drawer {

    private final GraphicsContext graphicsContext;


    public Drawer(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        graphicsContext.setFont(new Font(15));
    }


    public void drawPlayer(PhysicalObject physicalObject, Color color, int currentHealth, int baseHealth) {
        draw(physicalObject, color);
        Shape shape = physicalObject.getShape();
        Coordinates coordinates = physicalObject.getCoordinates();
        double per = (double) currentHealth / (double) baseHealth;
        graphicsContext.fillRect(coordinates.getX()-shape.getRadius()*per*2, coordinates.getY()-shape.getRadius()-8, shape.getRadius()*per*4, 4);
    }

    public void drawEnemy(PhysicalObject physicalObject, Color color, int currentHealth, int baseHealth) {
        draw(physicalObject, color);
        Shape shape = physicalObject.getShape();
        Coordinates coordinates = physicalObject.getCoordinates();
        double per = (double) currentHealth / (double) baseHealth;
        graphicsContext.fillRect(coordinates.getX()-shape.getRadius()/2*3, coordinates.getY()-shape.getRadius()-8, shape.getRadius()*3*per, 4);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(coordinates.getX()-shape.getRadius()/2*3+shape.getRadius()*3*per, coordinates.getY()-shape.getRadius()-8, shape.getRadius()*3*(1-per), 4);
        //graphicsContext.fillText(numberString, coordinates.getX()-shape.getRadius(), coordinates.getY()-shape.getRadius());
    }

    public void draw(PhysicalObject physicalObject, Color color) {
        graphicsContext.setFill(color);
        Shape shape = physicalObject.getShape();
        Coordinates coordinates = physicalObject.getCoordinates();
        graphicsContext.fillOval(
                coordinates.getX()-shape.getRadius(),
                coordinates.getY()-shape.getRadius(),
                2*shape.getRadius(),
                2*shape.getRadius());
    }

    public void drawPlane(String currentLevel, String currentRoom) {
        graphicsContext.setFill(Color.GOLDENROD);
        graphicsContext.fillRect(0, 0, Constants.ROOM_WIDTH, Constants.ROOM_HEIGHT);

        graphicsContext.setFill(Color.DARKVIOLET);
        graphicsContext.fillText("Level: " + currentLevel, 2, 20);
        graphicsContext.fillText("Room: " + currentRoom + "/" + Constants.MAP_SIZE, 2, 40);
    }
    public void drawStatistics(String damage, String speed, String attackDelay, String shotSpeed, String health) {
        graphicsContext.setFill(Color.DARKVIOLET);
        graphicsContext.fillText("Stats:", Constants.ROOM_WIDTH-180, 20);
        graphicsContext.fillText("DMG: " + damage, Constants.ROOM_WIDTH-180, 40);
        graphicsContext.fillText("Speed: " + speed, Constants.ROOM_WIDTH-180, 60);
        graphicsContext.fillText("Attack delay: " + attackDelay, Constants.ROOM_WIDTH-180, 80);
        graphicsContext.fillText("Shot speed: " + shotSpeed, Constants.ROOM_WIDTH-180, 100);
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillText("HP: " + health, Constants.ROOM_WIDTH-180, 120);
    }

    public void drawSmallBonus() {
        graphicsContext.setFill(Color.BLUEVIOLET);
        graphicsContext.fillText("Press 1 to get " + Constants.PLAYER_SMALL_HP_BONUS + " HP UP", Constants.ROOM_WIDTH/2-100, Constants.ROOM_HEIGHT-100);
        graphicsContext.fillText("Press 2 to get " + Constants.PLAYER_SMALL_DMG_BONUS + " DMG UP", Constants.ROOM_WIDTH/2-100, Constants.ROOM_HEIGHT-80);
    }

    public void drawBigBonus() {
        graphicsContext.setFill(Color.BLUEVIOLET);
        graphicsContext.fillText("Press 1 to get " + Constants.PLAYER_BIG_HP_BONUS + " HP UP", Constants.ROOM_WIDTH/2-100, Constants.ROOM_HEIGHT-100);
        graphicsContext.fillText("Press 2 to get " + Constants.PLAYER_BIG_DMG_BONUS + " DMG UP", Constants.ROOM_WIDTH/2-100, Constants.ROOM_HEIGHT-80);
        graphicsContext.fillText("Press 3 to get " + Constants.PLAYER_BIG_SPEED_BONUS + " SPEED UP", Constants.ROOM_WIDTH/2-100, Constants.ROOM_HEIGHT-60);
        graphicsContext.fillText("Press 4 to get " + Constants.PLAYER_BIG_ATTACK_DELAY_BONUS + " ATTACK DELAY DOWN (Can not be less then " + Constants.PLAYER_MIN_ATTACK_DELAY + ")", Constants.ROOM_WIDTH/2-100, Constants.ROOM_HEIGHT-40);
    }


}
