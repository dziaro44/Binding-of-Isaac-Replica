package View.Interface;

import javafx.stage.Stage;

public interface InterfaceView {
    void launch(Stage primaryStage);
    void addObserver(Observer observer);
    boolean isObserver();
}
