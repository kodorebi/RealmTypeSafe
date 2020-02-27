package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import java.util.*
import kotlin.reflect.KProperty1

fun <E> RealmResults<E>.setDate(field: KProperty1<E, Date?>, value: Date) {
    this.setDate(field.name, value)
}

fun <E> RealmResults<E>.setDate(field: KProperties<E, Date?>, value: Date) {
    this.setDate(field.path, value)
}