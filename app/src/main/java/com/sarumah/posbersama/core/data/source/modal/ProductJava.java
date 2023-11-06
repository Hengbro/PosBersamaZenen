package com.sarumah.posbersama.core.data.source.modal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class ProductJava{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idTb")
    public int idTb;
    public int id;
    public String name;
    public String image;
    public String idCategory;
    public int price;
}
