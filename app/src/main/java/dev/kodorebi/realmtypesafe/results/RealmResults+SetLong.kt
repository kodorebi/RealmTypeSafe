package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E> RealmResults<E>.setLong(field: KProperty1<E, Long?>, value: Long) {
    this.setLong(field.name, value)
}

fun <E> RealmResults<E>.setLong(field: KProperties<E, Long?>, value: Long) {
    this.setLong(field.path, value)
}