import Controller.TimelineFactoryModule;
import Model.Bullet.BulletFactoryModule;
import Model.Characters.Enemy.EnemiesFactoryModule;
import Model.Room.RoomFactoryModule;
import View.GameViewModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.stage.Stage;


public class GameApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Injector injector = Guice.createInjector(
                new EnemiesFactoryModule(),
                new BulletFactoryModule(),
                new RoomFactoryModule(),
                new GameViewModule(),
                new DriverModule(),
                new TimelineFactoryModule()
                );

        Driver driver = injector.getInstance(Driver.class);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        driver.launchApplication(primaryStage);
    }
}
