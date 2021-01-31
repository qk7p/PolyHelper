package ru.qk7p.polyhelper;

import android.app.Application;

import androidx.room.Room;

import ru.qk7p.polyhelper.database.MaterialDao;
import ru.qk7p.polyhelper.database.PolyHelperDatabase;

public class App extends Application {

    public static App instance;
    private PolyHelperDatabase database;
    private MaterialDao materialDao;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, PolyHelperDatabase.class, "PolyHelperDatabase").build();

        materialDao = database.materialDao();

    }

    public static App getInstance() {
        return instance;
    }

    public PolyHelperDatabase getDatabase() {
        return database;
    }

    public MaterialDao getMaterialDao() { return materialDao; }
}
