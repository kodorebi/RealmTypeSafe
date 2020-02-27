package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.Case
import io.realm.RealmQuery
import kotlin.reflect.KProperty1


fun <E> RealmQuery<E>.contains(field: KProperty1<E, String>, value: String, casing: Case = Case.SENSITIVE) : RealmQuery<E> {
    return this.contains(field.name, value, casing)
}

fun <E> RealmQuery<E>.contains(field: KProperties<E, String>, value: String, casing: Case = Case.SENSITIVE) : RealmQuery<E> {
    return this.contains(field.path, value, casing)
}