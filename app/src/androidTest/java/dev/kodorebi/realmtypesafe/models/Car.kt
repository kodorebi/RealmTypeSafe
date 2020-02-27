package dev.kodorebi.realmtypesafe.models

import android.graphics.Color
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class Car() : RealmModel {
    @PrimaryKey
    var id: Long = 0

    var brand: String = ""
    var model: String = ""
    var color: Int = Color.BLACK

    var buyDate = Date()

    var year: Int = 2020
    var price: Double = 10000.0

    var owner : Person? = null

    constructor(
        id: Long,
        brand: String,
        model: String,
        color: Int,
        buyDate: Date,
        year: Int,
        price: Double
    ) : this()
    {
        this.id = id
        this.brand = brand
        this.model = model
        this.color = color
        this.buyDate = buyDate
        this.year = year
        this.price = price
    }

}