package Controller;

import Model.Characters.HealthWrongValueException;
import Model.GameModel;
import View.GameView;
import com.google.inject.Inject;
import javafx.animation.Timeline;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class GameController {

    private final GameView gameView;
    private final GameModel gameModel;
    private final TimelineFactory timelineFactory;
    private final KeyboardController keyboardController;

    private Timeline timeline;

    public interface EndGameObserver {
        void notifyEndGame();
    }

    private List<EndGameObserver> endGameObserverList = new ArrayList<>();

    public void addObserver(EndGameObserver endGameObserver) {
        endGameObserverList.add(endGameObserver);
    }

    public boolean isObserver() {
        return !endGameObserverList.isEmpty();
    }

    @Inject
    public GameController(final GameView gameView,
                          final GameModel gameModel,
                          final TimelineFactory timelineFactory,
                          final KeyboardController keyboardController) {
        this.gameView = gameView;
        this.gameModel = gameModel;
        this.timelineFactory = timelineFactory;
        this.keyboardController = keyboardController;
    }

    public void playGame(Stage primaryStage) throws HealthWrongValueException {

        gameModel.prepareGame();

        StackPane stackPane = new StackPane(gameView.getGraphicsContext().getCanvas());
        Scene scene = new Scene(stackPane, Color.GOLDENROD);
        scene.setCursor(Cursor.NONE);

        keyboardController.enableMainKeysWithCheats(scene); //CHEATS ACTIVATED!!!

        timeline = timelineFactory.getTimeline(scene, gameModel, gameView, keyboardController);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setOnFinished(actionEvent -> launchGameOver()); // Sets action invoked on Finished

        primaryStage.setScene(scene);
        primaryStage.show();

        timeline.play();
    }

    private void launchGameOver() {
        timeline.stop();
        gameModel.resetGame();
        for (EndGameObserver endGameObserver: endGameObserverList) {
            endGameObserver.notifyEndGame();
        }
    }
}
