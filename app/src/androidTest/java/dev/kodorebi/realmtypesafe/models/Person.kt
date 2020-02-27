package dev.kodorebi.realmtypesafe.models

import io.realm.RealmModel
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class Person : RealmModel {
    @PrimaryKey
    var id: Long = 0

    var firstName = ""
    var lastName = ""

    var age: Int = 20

    var addedOn: Date = Date()

    @LinkingObjects("owner")
    val cars : RealmResults<Car>? = null
}