package com.sarumah.posbersama.core.data.source.local

import com.sarumah.posbersama.core.data.source.modal.Categories
import com.sarumah.posbersama.core.data.source.modal.Products
import com.sarumah.posbersama.R
import com.sarumah.posbersama.core.data.source.modal.Menu
import com.sarumah.posbersama.core.data.source.modal.Texass
import com.sarumah.posbersama.core.data.source.modal.Topings
import com.sarumah.posbersama.core.data.source.modal.Variations

object Dummy {

    val listCategories= listOf (

        Categories(id = 1, name = "Food", qty = "2"),
        Categories(id = 2, name = "Drink", qty = "3"),
        Categories(id = 3, name = "Snakck", qty = "2"),
        Categories(id = 4, name = "Nothing", qty = "4")
    )

    val listProduct = listOf(
        Products(id = 1, name ="Aquades", category = "Drink", price = 10000, imageDummy = R.drawable.tempat_makan),
        Products(id = 2, name ="Martabak manis", category = "Food", price = 10000, imageDummy = R.drawable.tempat_makan),
        Products(id = 3, name ="Mineral water", category = "Drink", price = 10000, imageDummy = R.drawable.tempat_makan),
        Products(id = 4, name ="Fruit tea", category = "Drink", price = 10000, imageDummy = R.drawable.tempat_makan),
        Products(id = 5, name ="French fries", category = "Snacks", price = 10000, imageDummy = R.drawable.tempat_makan)
    )

    val listVariations = listOf(
        Variations(id = 1, name = "Small, Normal Sugar", price = 40000),
        Variations(id = 2, name = "Medium, Normal Sugar", price = 50000),
        Variations(id = 3, name = "Large, Normal Sugar", price = 60000),
        Variations(id = 4, name = "Small, Extra Sugar", price = 45000),
        Variations(id = 5, name = "Medium, Extra Sugar", price = 55000),
        Variations(id = 6, name = "Large, Extra Sugar", price = 65000),
    )

    val listTopings = listOf(
        Topings(id = 1, name = "Add Cheese", price = 10000),
        Topings(id = 2, name = "Add Chocolate", price = 50000),
        Topings(id = 3, name = "Add Peanuts", price = 60000),
    )

    val listTaxes = listOf(
        Texass(id = 1, name = "GST", persen = 10)
    )

    val listMenu = listOf(
        Menu(id = 1, name = "Product & inventory", image = R.drawable.asset_ic_table_management),
        Menu(id = 2, name ="Taxes & other changes", image = R.drawable.asset_ic_frame),
        Menu(id = 3, name ="Transaction", image = R.drawable.asset_ic_drag_drop),
        Menu(id = 4, name ="Reports", image = R.drawable.asset_ic_info),
        Menu(id = 5, name ="Recipes & ingredients", image = R.drawable.asset_ic_recipes_ingredients),
        Menu(id = 6, name ="Menus", image = R.drawable.asset_ic_open_book_menu),
        Menu(id = 7, name ="Customers", image = R.drawable.asset_ic_manage_customers),
        Menu(id = 8, name ="Settings", image = R.drawable.asset_ic_frame),
        Menu(id = 9, name ="Help & suport", image = R.drawable.asset_ic_add),

    )
}