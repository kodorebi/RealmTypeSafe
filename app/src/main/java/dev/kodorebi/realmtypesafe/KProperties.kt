package dev.kodorebi.realmtypesafe

import kotlin.reflect.KProperty1


class KProperties<F, L> internal constructor (val path: String) {

    constructor(property: KProperty1<F, L?>) : this(property.name)

    companion object {
        fun <F, L, N> dot(properties: KProperties<F, L>, property: KProperty1<L, N?>) : KProperties<F, N> {
            return KProperties("${properties.path}.${property.name}")
        }
    }
}

infix fun <F, L, N> KProperties<F, L>.dot(property: KProperty1<L, N?>) : KProperties<F, N> {
    return KProperties.dot(this, property)
}

infix fun <F, L, N> KProperty1<F,L?>.dot(property: KProperty1<L,N?>) : KProperties<F, N> {
    return KProperties("${this.name}.${property.name}")
}