package com.sarumah.posbersama.core.data.source.local

import com.sarumah.posbersama.core.data.source.modal.Categories

object Dummy {

    val listCategories= listOf (

        Categories(id = 1, name = "Food", qty = "2"),
        Categories(id = 2, name = "Drink", qty = "3"),
        Categories(id = 3, name = "Snakck", qty = "2"),
        Categories(id = 4, name = "Nothing", qty = "4")
    )
}