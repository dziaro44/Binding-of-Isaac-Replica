package Model.Characters.Enemy;

import com.google.inject.PrivateModule;
import com.google.inject.Singleton;

public class EnemiesFactoryModule extends PrivateModule {
    @Override
    protected void configure() {
        bind(EnemiesFactory.class).to(EnemiesFactoryImpl.class).in(Singleton.class);
        expose(EnemiesFactory.class);
    }
}
