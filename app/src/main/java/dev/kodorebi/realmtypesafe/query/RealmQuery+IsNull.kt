package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmQuery
import kotlin.reflect.KProperty1

fun <E> RealmQuery<E>.isNull(field: KProperty1<E, *>) : RealmQuery<E> {
    return this.isNull(field.name)
}

fun <E> RealmQuery<E>.isNull(field: KProperties<E, *>) : RealmQuery<E> {
    return this.isNull(field.path)
}