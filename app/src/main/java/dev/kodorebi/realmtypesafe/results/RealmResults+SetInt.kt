package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E> RealmResults<E>.setInt(field: KProperty1<E, Int?>, value: Int) {
    this.setInt(field.name, value)
}

fun <E> RealmResults<E>.setInt(field: KProperties<E, Int?>, value: Int) {
    this.setInt(field.path, value)
}