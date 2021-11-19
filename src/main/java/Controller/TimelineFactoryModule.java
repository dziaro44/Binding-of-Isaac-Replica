package Controller;

import com.google.inject.PrivateModule;
import com.google.inject.Singleton;

public class TimelineFactoryModule extends PrivateModule {
    @Override
    protected void configure() {
        bind(TimelineFactory.class).in(Singleton.class);
    }
}
