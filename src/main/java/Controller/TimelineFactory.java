package Controller;

import Model.Characters.HealthWrongValueException;
import Model.GameModel;
import Model.Helpers.Constants;
import Model.Helpers.InfoForViewWrapper;
import Model.Helpers.PlayerAction;
import Model.Helpers.NullDirectionException;
import View.GameView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.util.Duration;

public class TimelineFactory {


    private PlayerAction playerAction = new PlayerAction();

    private Timeline timeline;

    public Timeline getTimeline(final Scene scene,
                                final GameModel gameModel,
                                final GameView gameView,
                                final KeyboardController keyboardController) {

        timeline = new Timeline(new KeyFrame(Duration.millis(Constants.KEY_FRAME_DURATION), e -> {
            try {
                keyboardController.updatePlayerAction(playerAction);
                InfoForViewWrapper infoForViewWrapper = gameModel.makeStep(playerAction);
                gameView.drawAll(infoForViewWrapper);
                if(gameModel.isChoosingBonusActive()) {
                    if(gameModel.isCurrentRoomLast()) {
                        gameView.drawBigBonus();
                    }
                    else {
                        gameView.drawSmallBonus();
                    }
                }
                if(gameModel.isBonusChose()) {
                    gameModel.setBonusChose(false);
                    keyboardController.disableExtraKeysWithCheats(scene); //CHEATS ACTIVATED!!!
                }
            }
            catch (HealthWrongValueException | NullDirectionException ex) {
                ex.printStackTrace();
            }
            if (gameModel.isPlayerDead()) {
                setFinishAction();
            }
            if (gameModel.isCleared() && !gameModel.isChoosingBonusActive()) {
                if(gameModel.isCurrentRoomLast()) {
                    keyboardController.enable1234Keys(scene);
                }
                else {
                    keyboardController.enable12Keys(scene);
                }
                gameModel.setChoosingBonusActive(true);
            }
        }));
        return timeline;
    }

    private void setFinishAction() {
        timeline.getOnFinished().handle(new ActionEvent());
    }
}
