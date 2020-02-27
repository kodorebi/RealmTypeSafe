package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import dev.kodorebi.realmtypesafe.SortField
import io.realm.RealmQuery
import io.realm.Sort
import kotlin.reflect.KProperty1


fun <E> RealmQuery<E>.sort(field: KProperty1<E, String>, sortOrder: Sort = Sort.ASCENDING) : RealmQuery<E> {
    return this.sort(field.name, sortOrder)
}

fun <E> RealmQuery<E>.sort(field1 : SortField<E>, field2 : SortField<E>) : RealmQuery<E> {
    return this.sort(field1.name, field1.sortOrder, field2.name, field2.sortOrder)
}

fun <E> RealmQuery<E>.sort(vararg fields: SortField<E>) : RealmQuery<E> {
    val names = fields.map { it.name }.toTypedArray()
    val sortOrders = fields.map { it.sortOrder }.toTypedArray()

    return this.sort(names, sortOrders)
}

//TODO: check if this is actually possible
fun <E> RealmQuery<E>.sort(field: KProperties<E, String>, sortOrder: Sort = Sort.ASCENDING) : RealmQuery<E> {
    return this.sort(field.path, sortOrder)
}