package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.Case
import io.realm.RealmQuery
import java.util.*
import kotlin.reflect.KProperty1

fun <E> RealmQuery<E>.notEqualTo(field: KProperty1<E, String?>, value: String?) : RealmQuery<E> {
    return this.notEqualTo(field.name, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperty1<E, String?>, value: String?, casing: Case) : RealmQuery<E> {
    return this.notEqualTo(field.name, value, casing)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperty1<E, Byte?>, value: Byte?) : RealmQuery<E> {
    return this.notEqualTo(field.name, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperty1<E, ByteArray?>, value: ByteArray?) : RealmQuery<E> {
    return this.notEqualTo(field.name, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperty1<E, Short?>, value: Short?) : RealmQuery<E> {
    return this.notEqualTo(field.name, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperty1<E, Int?>, value: Int?) : RealmQuery<E> {
    return this.notEqualTo(field.name, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperty1<E, Long?>, value: Long?) : RealmQuery<E> {
    return this.notEqualTo(field.name, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperty1<E, Double?>, value: Double?) : RealmQuery<E> {
    return this.notEqualTo(field.name, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperty1<E, Float?>, value: Float?) : RealmQuery<E> {
    return this.notEqualTo(field.name, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperty1<E, Boolean?>, value: Boolean?) : RealmQuery<E> {
    return this.notEqualTo(field.name, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperty1<E, Date?>, value: Date?) : RealmQuery<E> {
    return this.notEqualTo(field.name, value)
}


//KProperties

fun <E> RealmQuery<E>.notEqualTo(field: KProperties<E, String?>, value: String?) : RealmQuery<E> {
    return this.notEqualTo(field.path, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperties<E, String?>, value: String?, casing: Case) : RealmQuery<E> {
    return this.notEqualTo(field.path, value, casing)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperties<E, Byte?>, value: Byte?) : RealmQuery<E> {
    return this.notEqualTo(field.path, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperties<E, ByteArray?>, value: ByteArray?) : RealmQuery<E> {
    return this.notEqualTo(field.path, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperties<E, Short?>, value: Short?) : RealmQuery<E> {
    return this.notEqualTo(field.path, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperties<E, Int?>, value: Int?) : RealmQuery<E> {
    return this.notEqualTo(field.path, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperties<E, Long?>, value: Long?) : RealmQuery<E> {
    return this.notEqualTo(field.path, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperties<E, Double?>, value: Double?) : RealmQuery<E> {
    return this.notEqualTo(field.path, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperties<E, Float?>, value: Float?) : RealmQuery<E> {
    return this.notEqualTo(field.path, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperties<E, Boolean?>, value: Boolean?) : RealmQuery<E> {
    return this.notEqualTo(field.path, value)
}

fun <E> RealmQuery<E>.notEqualTo(field: KProperties<E, Date?>, value: Date?) : RealmQuery<E> {
    return this.notEqualTo(field.path, value)
}