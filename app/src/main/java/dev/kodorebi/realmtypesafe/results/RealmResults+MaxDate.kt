package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import java.util.*
import kotlin.reflect.KProperty1

fun <E> RealmResults<E>.maxDate(field: KProperty1<E, Date?>) : Date? {
    return this.maxDate(field.name)
}

fun <E> RealmResults<E>.maxDate(field: KProperties<E, Date?>) : Date? {
    return this.maxDate(field.path)
}