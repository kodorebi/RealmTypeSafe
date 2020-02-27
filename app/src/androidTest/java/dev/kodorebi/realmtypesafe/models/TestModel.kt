package dev.kodorebi.realmtypesafe.models

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
class TestModel : RealmModel {
    @PrimaryKey
    var id: Long = 0

    var string : String = ""
    var oString : String? = null

    var boolean: Boolean = true
    var oBoolean: Boolean? = null

    var blob: ByteArray = ByteArray(0)
    var oBlob: ByteArray? = null

    var byte: Byte = 0
    var oByte: Byte? = null


    var date : Date = Date()
    var oDate : Date? = null

    var double : Double = 0.0
    var oDouble : Double? = null

    var float : Float = 0.0f
    var oFloat : Float? = null

    var int : Int = 0
    var oInt : Int? = null

    val list : RealmList<TestModel> = RealmList()

    var long : Long = 0
    var oLong : Long? = null

    var obj : TestModel? = null

    var short : Short = 0
    var oShort : Short? = null


}