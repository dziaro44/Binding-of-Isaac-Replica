package View;

import Model.Characters.CharacterInfo;
import Model.Helpers.InfoForViewWrapper;
import Model.Helpers.PhysicalObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class GameView {
    private GraphicsContext graphicsContext;
    private Drawer drawer;

    public GameView(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        this.drawer = new Drawer(graphicsContext);
        graphicsContext.setFont(new Font(20));
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void drawAll(InfoForViewWrapper infoForViewWrapper) {
        drawer.drawPlane(infoForViewWrapper.getCurrentLevel(), infoForViewWrapper.getCurrentRoom());
        drawer.drawStatistics(Integer.toString(infoForViewWrapper.getCharacterStatistics().getDamage()),
                Double.toString(infoForViewWrapper.getCharacterStatistics().getSpeed()),
                Integer.toString(infoForViewWrapper.getCharacterStatistics().getAttackDelay()),
                Double.toString(infoForViewWrapper.getCharacterStatistics().getShotSpeed()),
                Integer.toString(infoForViewWrapper.getCharacterStatistics().getHealthPoints()));
        drawPlayer(infoForViewWrapper.getPlayer());
        drawEnemies(infoForViewWrapper.getEnemies());
        drawEnemyBullets(infoForViewWrapper.getEnemiesBullets());
        drawPlayerBullets(infoForViewWrapper.getPlayerBullets());
    }

    private void drawPlayer(CharacterInfo characterInfo) {
        drawer.drawPlayer(characterInfo.getPhysicalObject(), Color.GREEN, characterInfo.getCurrentHealth(), characterInfo.getBaseHealth());
    }

    private void drawEnemies(List<CharacterInfo> enemyList) {
        for (CharacterInfo characterInfo: enemyList) {
            drawer.drawEnemy(characterInfo.getPhysicalObject(), Color.RED, characterInfo.getCurrentHealth(), characterInfo.getBaseHealth());
        }
    }

    private void drawPlayerBullets(List<PhysicalObject> playerBulletList) {
        for (PhysicalObject physicalObject: playerBulletList) {
            drawer.draw(physicalObject, Color.LIGHTGREEN);
        }
    }

    private void drawEnemyBullets(List<PhysicalObject> enemyBulletList) {
        for (PhysicalObject physicalObject: enemyBulletList) {
            drawer.draw(physicalObject, Color.DARKRED);
        }
    }
    public void drawSmallBonus() {
        drawer.drawSmallBonus();
    }

    public void drawBigBonus() {
        drawer.drawBigBonus();
    }
}

