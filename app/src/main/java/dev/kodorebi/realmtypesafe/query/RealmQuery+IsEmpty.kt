package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmList
import io.realm.RealmQuery
import kotlin.reflect.KProperty1

fun <E> RealmQuery<E>.isEmpty(field: KProperty1<E, *>) : RealmQuery<E> {
    return this.isEmpty(field.name)
}

fun <E> RealmQuery<E>.isEmptyString(field: KProperty1<E, String>) : RealmQuery<E>{
    return this.isEmpty(field.name)
}

fun <E> RealmQuery<E>.isEmptyList(field: KProperty1<E, RealmList<*>>) : RealmQuery<E> {
    return this.isEmpty(field.name)
}

fun <E> RealmQuery<E>.isEmptyByteArray(field: KProperty1<E, ByteArray>) : RealmQuery<E> {
    return this.isEmpty(field.name)
}



fun <E> RealmQuery<E>.isEmpty(field: KProperties<E, *>) : RealmQuery<E> {
    return this.isEmpty(field.path)
}

fun <E> RealmQuery<E>.isEmptyString(field: KProperties<E, String>) : RealmQuery<E>{
    return this.isEmpty(field.path)
}

fun <E> RealmQuery<E>.isEmptyList(field: KProperties<E, RealmList<*>>) : RealmQuery<E> {
    return this.isEmpty(field.path)
}

fun <E> RealmQuery<E>.isEmptyByteArray(field: KProperties<E, ByteArray>) : RealmQuery<E> {
    return this.isEmpty(field.path)
}