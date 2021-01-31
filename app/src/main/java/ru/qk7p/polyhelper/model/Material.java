package ru.qk7p.polyhelper.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Material {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(index = true, name = "Название материала")
    public String name;

    public Material(String name) {
        this.name = name;
    }

}
