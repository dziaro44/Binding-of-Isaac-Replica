package Model.Room;

import com.google.inject.PrivateModule;
import com.google.inject.Singleton;

public class RoomFactoryModule extends PrivateModule {

    @Override
    protected void configure() {
        bind(RoomFactory.class).to(RoomFactoryImpl.class).in(Singleton.class);
        expose(RoomFactory.class);
    }
}
