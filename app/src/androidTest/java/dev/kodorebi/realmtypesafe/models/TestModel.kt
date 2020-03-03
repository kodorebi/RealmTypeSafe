package dev.kodorebi.realmtypesafe.models

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class TestModel : RealmModel {
    @PrimaryKey
    var id: Long = 0

    var pString : String = ""
    var oString : String? = null

    var pBoolean: Boolean = true
    var oBoolean: Boolean? = null

    var pBlob: ByteArray = ByteArray(0)
    var oBlob: ByteArray? = null

    var pByte: Byte = 0
    var oByte: Byte? = null


    var pDate : Date = Date()
    var oDate : Date? = null

    var pDouble : Double = 0.0
    var oDouble : Double? = null

    var pFloat : Float = 0.0f
    var oFloat : Float? = null

    var pInt : Int = 0
    var oInt : Int? = null

    var list : RealmList<TestModel> = RealmList()

    var pLong : Long = 0
    var oLong : Long? = null

    var obj : TestModel? = null

    var pShort : Short = 0
    var oShort : Short? = null


}