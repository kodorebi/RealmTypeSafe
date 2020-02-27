package dev.kodorebi.realmtypesafe.query

import io.realm.RealmQuery
import kotlin.reflect.KProperty1



/**
 *  @see [RealmQuery.average]
 */
fun <E> RealmQuery<E>.average(field: KProperty1<E, Number>) : Double {
    return this.average(field.name)
}