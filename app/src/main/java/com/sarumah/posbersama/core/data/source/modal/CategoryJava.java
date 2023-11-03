package com.sarumah.posbersama.core.data.source.modal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "categorys")
public class CategoryJava{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idTb")
    public int idTb;
    public int id;
    public String name;
    public String image;
    public String id_Product;

}
