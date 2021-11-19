package View.Interface;

import Model.Helpers.Constants;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOverView extends InterfaceViewImpl{
    @Override
    protected void setStage(Stage primaryStage) {
        Label label = new Label("Game Over");
        label.setTextFill(Color.LIGHTBLUE);
        label.setFont(new Font(100));
        label.setTranslateX(Constants.ROOM_WIDTH/2-250);
        label.setTranslateY(Constants.ROOM_HEIGHT/2 - 200);

        HBox hbox = new HBox();
        hbox.setTranslateX(Constants.ROOM_WIDTH/2-150);
        hbox.setTranslateY(Constants.ROOM_HEIGHT/2);

        //BACK TO MENU BUTTON
        Button buttonBackToMenu = new Button("Back to menu");
        buttonBackToMenu.setFont(new Font(40));
        buttonBackToMenu.setMaxSize(300, 150);
        buttonBackToMenu.setPrefSize(300, 150);
        buttonBackToMenu.setOnAction(value -> {
            for (Observer observer : observerList) {
                observer.notifyClick(MenuOption.BACK_TO_MENU);
            }
        });
        hbox.getChildren().add(buttonBackToMenu);

        Group root = new Group();
        root.getChildren().add(label);
        root.getChildren().add(hbox);

        Scene scene = new Scene(root, Constants.ROOM_WIDTH, Constants.ROOM_HEIGHT, Color.ROSYBROWN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
