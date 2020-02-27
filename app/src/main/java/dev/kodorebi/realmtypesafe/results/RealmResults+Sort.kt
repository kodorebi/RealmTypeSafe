package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import dev.kodorebi.realmtypesafe.SortField
import io.realm.RealmResults
import io.realm.Sort
import kotlin.reflect.KProperty1

fun <E> RealmResults<E>.sort(field: KProperty1<E, String>, sortOrder: Sort = Sort.ASCENDING) : RealmResults<E> {
    return this.sort(field.name, sortOrder)
}

fun <E> RealmResults<E>.sort(field1 : SortField<E>, field2 : SortField<E>) : RealmResults<E> {
    return this.sort(field1.name, field1.sortOrder, field2.name, field2.sortOrder)
}

fun <E> RealmResults<E>.sort(vararg fields: SortField<E>) : RealmResults<E> {
    val names = fields.map { it.name }.toTypedArray()
    val sortOrders = fields.map { it.sortOrder }.toTypedArray()

    return this.sort(names, sortOrders)
}


//TODO: test if this is actually possible
fun <E> RealmResults<E>.sort(field: KProperties<E, String>, sortOrder: Sort = Sort.ASCENDING) : RealmResults<E> {
    return this.sort(field.path, sortOrder)
}