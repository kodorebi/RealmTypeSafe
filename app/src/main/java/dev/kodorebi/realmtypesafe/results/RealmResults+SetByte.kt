package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E> RealmResults<E>.setByte(field: KProperty1<E, Byte?>, value: Byte) {
    this.setByte(field.name, value)
}

fun <E> RealmResults<E>.setByte(field: KProperties<E, Byte?>, value: Byte) {
    this.setByte(field.path, value)
}