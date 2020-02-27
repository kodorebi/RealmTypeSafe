package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E, T> RealmResults<E>.setNull(field: KProperty1<E, T?>) {
    this.setNull(field.name)
}

fun <E, T> RealmResults<E>.setNull(field: KProperties<E, T?>) {
    this.setNull(field.path)
}