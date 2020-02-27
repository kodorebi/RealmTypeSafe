package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E> RealmResults<E>.setBlob(field: KProperty1<E, ByteArray?>, value: ByteArray?) {
    this.setBlob(field.name, value)
}

fun <E> RealmResults<E>.setBlob(field: KProperties<E, ByteArray?>, value: ByteArray?) {
    this.setBlob(field.path, value)
}