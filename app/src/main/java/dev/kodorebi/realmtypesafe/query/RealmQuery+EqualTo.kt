package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.Case
import io.realm.RealmQuery
import java.util.*
import kotlin.reflect.KProperty1


fun <E> RealmQuery<E>.equalTo(field: KProperty1<E, String?>, value: String?, casing: Case = Case.SENSITIVE) : RealmQuery<E> {
    return this.equalTo(field.name, value, casing)
}

fun <E> RealmQuery<E>.equalTo(field: KProperty1<E, Byte?>, value: Byte?) : RealmQuery<E> {
    return this.equalTo(field.name, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperty1<E, ByteArray?>, value: ByteArray?) : RealmQuery<E> {
    return this.equalTo(field.name, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperty1<E, Short?>, value: Short?) : RealmQuery<E> {
    return this.equalTo(field.name, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperty1<E, Int?>, value: Int?) : RealmQuery<E> {
    return this.equalTo(field.name, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperty1<E, Long?>, value: Long?) : RealmQuery<E> {
    return this.equalTo(field.name, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperty1<E, Double?>, value: Double?) : RealmQuery<E> {
    return this.equalTo(field.name, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperty1<E, Float?>, value: Float?) : RealmQuery<E> {
    return this.equalTo(field.name, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperty1<E, Boolean?>, value: Boolean?) : RealmQuery<E> {
    return this.equalTo(field.name, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperty1<E, Date?>, value: Date?) : RealmQuery<E> {
    return this.equalTo(field.name, value)
}

//KProperties

fun <E> RealmQuery<E>.equalTo(field: KProperties<E, String>, value: String?, casing: Case = Case.SENSITIVE) : RealmQuery<E> {
    return this.equalTo(field.path, value, casing)
}

fun <E> RealmQuery<E>.equalTo(field: KProperties<E, Byte>, value: Byte?) : RealmQuery<E> {
    return this.equalTo(field.path, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperties<E, ByteArray>, value: ByteArray?) : RealmQuery<E> {
    return this.equalTo(field.path, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperties<E, Short>, value: Short?) : RealmQuery<E> {
    return this.equalTo(field.path, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperties<E, Int>, value: Int?) : RealmQuery<E> {
    return this.equalTo(field.path, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperties<E, Long>, value: Long?) : RealmQuery<E> {
    return this.equalTo(field.path, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperties<E, Double>, value: Double?) : RealmQuery<E> {
    return this.equalTo(field.path, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperties<E, Float>, value: Float?) : RealmQuery<E> {
    return this.equalTo(field.path, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperties<E, Boolean>, value: Boolean?) : RealmQuery<E> {
    return this.equalTo(field.path, value)
}

fun <E> RealmQuery<E>.equalTo(field: KProperties<E, Date>, value: Date?) : RealmQuery<E> {
    return this.equalTo(field.path, value)
}