package com.sarumah.posbersama.core.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sarumah.posbersama.core.source.model.ProductJava


@Dao
interface ProductDao {

    @Insert
    fun insert(product: ProductJava)

    @Update
    fun update(product: ProductJava)

    @Delete
    fun delete(product: ProductJava)

    @Query("SELECT * FROM products")
    fun getAllProduct(): List<ProductJava>

}