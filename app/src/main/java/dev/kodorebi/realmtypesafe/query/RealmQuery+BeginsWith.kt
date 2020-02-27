package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.Case
import io.realm.RealmQuery
import kotlin.reflect.KProperty1

fun <E> RealmQuery<E>.beginsWith(
    field: KProperty1<E, String>,
    value: String,
    casing: Case = Case.SENSITIVE) : RealmQuery<E>
{
    return this.beginsWith(field.name, value, casing)
}

fun <E> RealmQuery<E>.beginsWith(
    field: KProperties<E, String>,
    value: String,
    casing: Case = Case.SENSITIVE) : RealmQuery<E>
{
    return this.beginsWith(field.path, value, casing)
}