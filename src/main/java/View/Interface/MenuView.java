package View.Interface;

import Model.Helpers.Constants;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuView extends InterfaceViewImpl {

    @Override
    protected void setStage(Stage primaryStage) {
        Label label = new Label("Binding of Isaac Replica");
        label.setTextFill(Color.LIGHTBLUE);
        label.setFont(new Font(60));
        label.setTranslateX(Constants.ROOM_WIDTH/2-330);
        label.setTranslateY(100);

        HBox hbox = new HBox();
        hbox.setTranslateX(Constants.ROOM_WIDTH/2-450);
        hbox.setTranslateY(Constants.ROOM_HEIGHT/2);

        //PLAY GAME BUTTON
        Button buttonPlayGame = new Button("Play Game");
        buttonPlayGame.setFont(new Font(40));
        buttonPlayGame.setMaxSize(300, 150);
        buttonPlayGame.setPrefSize(300, 150);
        buttonPlayGame.setOnAction(value -> {
            for (Observer observer : observerList) {
                observer.notifyClick(MenuOption.PLAY_GAME);
            }
        });
        hbox.getChildren().add(buttonPlayGame);


        //SETTINGS BUTTON
        Button buttonSettings = new Button("Settings");
        buttonSettings.setFont(new Font(40));
        buttonSettings.setMaxSize(300, 150);
        buttonSettings.setPrefSize(300, 150);
        buttonSettings.setOnAction(value -> {
            for (Observer observer : observerList) {
                observer.notifyClick(MenuOption.SETTINGS);
            }
        });
        hbox.getChildren().add(buttonSettings);

        //QUIT GAME BUTTON
        Button buttonQuitGame = new Button("Quit");
        buttonQuitGame.setFont(new Font(40));
        buttonQuitGame.setMaxSize(300, 150);
        buttonQuitGame.setPrefSize(300, 150);
        buttonQuitGame.setOnAction(value -> {
            for (Observer observer : observerList) {
                observer.notifyClick(MenuOption.QUIT_GAME);
            }
        });
        hbox.getChildren().add(buttonQuitGame);

        Group root = new Group();
        root.getChildren().add(label);
        root.getChildren().add(hbox);


        Scene scene = new Scene(root, Constants.ROOM_WIDTH, Constants.ROOM_HEIGHT, Color.ROSYBROWN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
