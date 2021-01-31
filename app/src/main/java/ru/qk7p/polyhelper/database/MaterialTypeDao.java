package ru.qk7p.polyhelper.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.qk7p.polyhelper.model.Material;
import ru.qk7p.polyhelper.model.MaterialType;

@Dao
public interface MaterialTypeDao {
    @Query("SELECT * FROM MaterialType")
    List<Material> getAll();

    @Query("SELECT * FROM MaterialType WHERE id = :id")
    MaterialType getById(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(MaterialType materialType);

    @Update
    void update(MaterialType materialType);

    @Delete
    void delete(MaterialType materialType);
}
