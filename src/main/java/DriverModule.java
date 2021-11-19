import Controller.GameController;
import View.Interface.GameOverView;
import View.Interface.MenuView;
import View.Interface.SettingsView;
import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class DriverModule extends PrivateModule {

    @Override
    protected void configure() {
        expose(Driver.class);
    }

    @Provides
    @Singleton
    public Driver getDriver(final GameController gameController) {
        return new Driver(
                new MenuView(),
                new SettingsView(),
                new GameOverView(),
                gameController
        );
    }
}
