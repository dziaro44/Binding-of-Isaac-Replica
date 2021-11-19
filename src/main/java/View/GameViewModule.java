package View;

import Model.Helpers.Constants;
import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GameViewModule extends PrivateModule {

    @Override
    protected void configure() {
        expose(GameView.class);
    }

    @Provides
    public GameView getGameView() {
        Canvas canvas = new Canvas(Constants.ROOM_WIDTH, Constants.ROOM_HEIGHT);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        return new GameView(graphicsContext);
    }
}
