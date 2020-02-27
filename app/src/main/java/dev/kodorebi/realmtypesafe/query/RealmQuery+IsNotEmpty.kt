package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmList
import io.realm.RealmQuery
import kotlin.reflect.KProperty1

fun <E> RealmQuery<E>.isNotEmpty(field: KProperty1<E, *>) : RealmQuery<E> {
    return this.isNotEmpty(field.name)
}

fun <E> RealmQuery<E>.isNotEmptyString(field: KProperty1<E, String>) : RealmQuery<E> {
    return this.isNotEmpty(field.name)
}

fun <E> RealmQuery<E>.isNotEmptyList(field: KProperty1<E, RealmList<*>>) : RealmQuery<E> {
    return this.isNotEmpty(field.name)
}

fun <E> RealmQuery<E>.isNotEmptyByteArray(field: KProperty1<E, ByteArray>) : RealmQuery<E> {
    return this.isNotEmpty(field.name)
}


fun <E> RealmQuery<E>.isNotEmpty(field: KProperties<E, *>) : RealmQuery<E> {
    return this.isNotEmpty(field.path)
}

fun <E> RealmQuery<E>.isNotEmptyString(field: KProperties<E, String>) : RealmQuery<E> {
    return this.isNotEmpty(field.path)
}

fun <E> RealmQuery<E>.isNotEmptyList(field: KProperties<E, RealmList<*>>) : RealmQuery<E> {
    return this.isNotEmpty(field.path)
}

fun <E> RealmQuery<E>.isNotEmptyByteArray(field: KProperties<E, ByteArray>) : RealmQuery<E> {
    return this.isNotEmpty(field.path)
}