package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmQuery
import java.util.*
import kotlin.reflect.KProperty1

fun <E> RealmQuery<E>.minDate(field: KProperty1<E, Date?>) : Date? {
    return this.minimumDate(field.name)
}


fun <E> RealmQuery<E>.minDate(field: KProperties<E, Date?>) : Date? {
    return this.minimumDate(field.path)
}