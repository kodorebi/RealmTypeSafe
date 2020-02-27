package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import java.util.*
import kotlin.reflect.KProperty1

fun <E> RealmResults<E>.minDate(field: KProperty1<E, Date?>) : Date? {
    return this.minDate(field.name)
}

fun <E> RealmResults<E>.minDate(field: KProperties<E, Date?>) : Date? {
    return this.minDate(field.path)
}