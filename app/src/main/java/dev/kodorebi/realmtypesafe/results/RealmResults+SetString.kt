package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E> RealmResults<E>.setString(field: KProperty1<E, String?>, value: String?) {
    this.setString(field.name, value)
}

fun <E> RealmResults<E>.setString(field: KProperties<E, String?>, value: String?) {
    this.setString(field.path, value)
}