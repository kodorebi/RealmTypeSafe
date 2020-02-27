package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmList
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E, T> RealmResults<E>.setList(field: KProperty1<E, RealmList<T>>, value: RealmList<T>) {
    this.setList(field.name, value)
}

fun <E, T> RealmResults<E>.setList(field: KProperties<E, RealmList<T>>, value: RealmList<T>) {
    this.setList(field.path, value)
}