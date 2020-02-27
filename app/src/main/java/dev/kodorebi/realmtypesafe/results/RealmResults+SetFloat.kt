package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E> RealmResults<E>.setFloat(field: KProperty1<E, Float?>, value: Float) {
    this.setFloat(field.name, value)
}

fun <E> RealmResults<E>.setFloat(field: KProperties<E, Float?>, value: Float) {
    this.setFloat(field.path, value)
}