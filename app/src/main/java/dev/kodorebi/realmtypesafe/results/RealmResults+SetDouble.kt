package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E> RealmResults<E>.setDouble(field: KProperty1<E, Double?>, value: Double) {
    this.setDouble(field.name, value)
}

fun <E> RealmResults<E>.setDouble(field: KProperties<E, Double?>, value: Double) {
    this.setDouble(field.path, value)
}