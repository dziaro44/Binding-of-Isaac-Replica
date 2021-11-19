import Controller.GameController;
import View.Interface.InterfaceView;
import View.Interface.MenuOption;
import View.Interface.Observer;
import com.google.inject.Inject;
import javafx.stage.Stage;

public class Driver {

    private final InterfaceView menuView;
    private final InterfaceView settingsView;
    private final InterfaceView gameOverView;
    private final GameController gameController;

    private Stage primaryStage;
    private Observer clickObserver = this::clicked;
    private GameController.EndGameObserver endGameObserver = this::endGame;

    @Inject
    public Driver(InterfaceView menuView,
                  InterfaceView settingsView,
                  InterfaceView gameOverView,
                  GameController gameController) {
        this.menuView = menuView;
        this.settingsView = settingsView;
        this.gameOverView = gameOverView;
        this.gameController = gameController;
    }

    public void launchApplication(Stage stage) {
        this.primaryStage = stage;
        launchMenu();
    }

    private void launchMenu() {
        if (!menuView.isObserver()) menuView.addObserver(clickObserver);
        menuView.launch(primaryStage);
    }

    private void launchSettings() {
        if (!settingsView.isObserver()) settingsView.addObserver(clickObserver);
        settingsView.launch(primaryStage);
    }

    private void launchGameOver() {
        if (!gameOverView.isObserver()) gameOverView.addObserver(clickObserver);
        gameOverView.launch(primaryStage);
    }

    private void quitApplication() {
        primaryStage.close();
    }

    private void launchGame() {
        if (!gameController.isObserver()) gameController.addObserver(endGameObserver);
        try {
            gameController.playGame(primaryStage);
        }
        catch (Exception ignore) {}
    }

    private void clicked(MenuOption menuOption) {
        switch (menuOption) {
            case PLAY_GAME:
                launchGame();
                break;
            case SETTINGS:
                launchSettings();
                break;
            case QUIT_GAME:
                quitApplication();
                break;
            case BACK_TO_MENU:
                launchMenu();
                break;
        }
    }

    private void endGame() {
        launchGameOver();
    }
}
