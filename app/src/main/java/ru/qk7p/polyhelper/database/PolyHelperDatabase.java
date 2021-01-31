package ru.qk7p.polyhelper.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.qk7p.polyhelper.model.Material;
import ru.qk7p.polyhelper.model.MaterialType;

@Database(entities = {Material.class, MaterialType.class}, version = 1)
public abstract class PolyHelperDatabase extends RoomDatabase {
    public abstract MaterialDao materialDao();
    public abstract MaterialTypeDao materialTypeDao();
}
