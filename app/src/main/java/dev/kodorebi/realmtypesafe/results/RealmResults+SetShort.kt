package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E> RealmResults<E>.setShort(field: KProperty1<E, Short?>, value: Short) {
    this.setShort(field.name, value)
}

fun <E> RealmResults<E>.setShort(field: KProperties<E, Short?>, value: Short) {
    this.setShort(field.path, value)
}