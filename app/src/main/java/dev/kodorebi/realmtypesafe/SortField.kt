package dev.kodorebi.realmtypesafe

import io.realm.Sort
import kotlin.reflect.KProperty1

class SortField<E> private constructor(val name: String, val sortOrder: Sort) {

    constructor(property: KProperty1<E, String>, sortOrder: Sort = Sort.ASCENDING)
            : this(property.name, sortOrder)

    constructor(properties: KProperties<E, String>, sortOrder: Sort = Sort.ASCENDING)
            :this(properties.path, sortOrder)
}