package ru.qk7p.polyhelper.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.qk7p.polyhelper.model.Material;

@Dao
public interface MaterialDao {


    @Query("SELECT * FROM material")
    List<Material> getAll();

    @Query("SELECT * FROM material")
    LiveData<List<Material>> getAllLiveData();

    @Query("SELECT * FROM material WHERE id = :id")
    Material getById(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Material material);

    @Update
    void update(Material material);

    @Delete
    void delete(Material material);

}
