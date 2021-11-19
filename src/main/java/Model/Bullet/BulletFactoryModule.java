package Model.Bullet;

import com.google.inject.PrivateModule;
import com.google.inject.Singleton;

public class BulletFactoryModule extends PrivateModule {
    @Override
    protected void configure() {
        bind(BulletFactory.class).to(BulletFactoryImpl.class).in(Singleton.class);
        expose(BulletFactory.class);
    }
}
