package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E, T> RealmResults<E>.setValue(field: KProperty1<E, T>, value: T) {
    this.setValue(field.name, value)
}

fun <E, T> RealmResults<E>.setValue(field: KProperties<E, T>, value: T) {
    this.setValue(field.path, value)
}