package ru.qk7p.polyhelper.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import ru.qk7p.polyhelper.model.Material;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Material.class, parentColumns = "id", childColumns = "material_id", onDelete = CASCADE))
public class MaterialType {
    @PrimaryKey(autoGenerate = true)
    public long id;
    @ColumnInfo(index = true)
    public String materialTypeName;

    @ColumnInfo(name = "material_id")
    public long materialId;
}
