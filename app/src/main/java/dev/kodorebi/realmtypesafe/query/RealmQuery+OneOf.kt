package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.Case
import io.realm.RealmModel
import io.realm.RealmQuery
import io.realm.kotlin.oneOf
import java.util.*
import kotlin.reflect.KProperty1

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperty1<E, Date>, values: Array<out Date?>) : RealmQuery<E> {
    return this.oneOf(field.name, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperty1<E, Boolean>, values: Array<out Boolean?>) : RealmQuery<E> {
    return this.oneOf(field.name, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperty1<E, Byte>, values: Array<out Byte?>) : RealmQuery<E> {
    return this.oneOf(field.name, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperty1<E, Double>, values: Array<out Double?>) : RealmQuery<E> {
    return this.oneOf(field.name, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperty1<E, Int>, values: Array<out Int?>) : RealmQuery<E> {
    return this.oneOf(field.name, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperty1<E, Float>, values: Array<out Float?>) : RealmQuery<E> {
    return this.oneOf(field.name, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperty1<E, Long>, values: Array<out Long?>) : RealmQuery<E> {
    return this.oneOf(field.name, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperty1<E, Short>, values: Array<out Short?>) : RealmQuery<E> {
    return this.oneOf(field.name, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperty1<E, String>, values: Array<out String?>, casing: Case = Case.SENSITIVE) : RealmQuery<E> {
    return this.oneOf(field.name, values, casing)
}



fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperties<E, Date>, values: Array<out Date?>) : RealmQuery<E> {
    return this.oneOf(field.path, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperties<E, Boolean>, values: Array<out Boolean?>) : RealmQuery<E> {
    return this.oneOf(field.path, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperties<E, Byte>, values: Array<out Byte?>) : RealmQuery<E> {
    return this.oneOf(field.path, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperties<E, Double>, values: Array<out Double?>) : RealmQuery<E> {
    return this.oneOf(field.path, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperties<E, Int>, values: Array<out Int?>) : RealmQuery<E> {
    return this.oneOf(field.path, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperties<E, Float>, values: Array<out Float?>) : RealmQuery<E> {
    return this.oneOf(field.path, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperties<E, Long>, values: Array<out Long?>) : RealmQuery<E> {
    return this.oneOf(field.path, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperties<E, Short>, values: Array<out Short?>) : RealmQuery<E> {
    return this.oneOf(field.path, values)
}

fun <E : RealmModel> RealmQuery<E>.oneOf(field: KProperties<E, String>, values: Array<out String?>, casing: Case = Case.SENSITIVE) : RealmQuery<E> {
    return this.oneOf(field.path, values, casing)
}