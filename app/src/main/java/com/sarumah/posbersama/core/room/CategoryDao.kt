package com.sarumah.posbersama.core.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sarumah.posbersama.core.source.model.CategoryJava


@Dao
interface CategoryDao {

    @Insert
    fun insert(category: CategoryJava)

    @Update
    fun update(category: CategoryJava)

    @Delete
    fun delete(category: CategoryJava)

    @Query("SELECT * FROM categorys")
    fun getAllCategories(): List<CategoryJava>

}