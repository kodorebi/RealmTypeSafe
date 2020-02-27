package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E> RealmResults<E>.setBoolean(field: KProperty1<E, Boolean?>, value: Boolean) {
    this.setBoolean(field.name, value)
}

fun <E> RealmResults<E>.setBoolean(field: KProperties<E, Boolean?>, value: Boolean) {
    this.setBoolean(field.path, value)
}
