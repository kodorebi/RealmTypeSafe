package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmQuery
import java.util.*
import kotlin.reflect.KProperty1

fun <E> RealmQuery<E>.maxDate(field: KProperty1<E, Date?>) : Date? {
    return this.maximumDate(field.name)
}


fun <E> RealmQuery<E>.maxDate(field: KProperties<E, Date?>) : Date? {
    return this.maximumDate(field.path)
}