package View.Interface;

import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public abstract class InterfaceViewImpl implements InterfaceView {

    protected List<Observer> observerList = new ArrayList<>();

    @Override
    public void launch(Stage primaryStage) {
        setStage(primaryStage);
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public boolean isObserver() {
        return !observerList.isEmpty();
    }

    protected abstract void setStage(Stage primaryStage);
}
