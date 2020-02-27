package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmModel
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E, T : RealmModel> RealmResults<E>.setObject(field: KProperty1<E, T?>, value: T) {
    this.setObject(field.name, value)
}

fun <E, T : RealmModel> RealmResults<E>.setObject(field: KProperties<E, T?>, value: T) {
    this.setObject(field.path, value)
}