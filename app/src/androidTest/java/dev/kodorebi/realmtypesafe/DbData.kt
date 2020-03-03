package dev.kodorebi.realmtypesafe

import dev.kodorebi.realmtypesafe.extensions.addDays
import dev.kodorebi.realmtypesafe.models.TestModel
import io.realm.Realm
import io.realm.kotlin.where
import java.util.*

class DbData {
    companion object {
        fun prepare(realm : Realm) {
            val any = realm.where<TestModel>().count() > 0

            if (any) {
                return
            }


            insertTestModels(realm)

        }


        private fun insertTestModels(realm: Realm) {
            val greekLeters = listOf(
                "alpha",
                "beta",
                "gamma",
                "delta",
                "epsilon",
                "zeta",
                "eta",
                "teta",
                "iota",
                "kappa",
                "lambda",
                "miu",
                "niu",
                "csi",
                "omicron",
                "pi",
                "ro",
                "sigma",
                "tau",
                "ipsilon",
                "hi",
                "fi",
                "psi",
                "omega"
            )

            val models = mutableListOf<TestModel>()

            for(i in 0 until 100) {
                val model = TestModel()
                with(model){
                    id = i + 1L
                    pString = greekLeters[i % greekLeters.size] + " " + (i / 2 + 1)
                    oString = if (i % 2 == 0) pString else null
                    pBoolean = i % 2 == 1
                    oBoolean = if (i % 3 == 0) pBoolean xor true else null
                    pBlob = ByteArray(1) { i.toByte() }
                    oBlob = if (i % 2 == 0) null else ByteArray(1) { (i+1).toByte() }
                    pByte = (i * 4).toByte()
                    oByte = if (i % 2 == 0) (i * 2).toByte() else null
                    pDate = Date().addDays(i / 2 * (if (i % 2 == 0) -1 else 1))
                    oDate = if (i % 4 != 0) Date().addDays(i * (if (i % 2 == 0) -1 else 1)) else null
                    pDouble = i * Math.PI
                    oDouble = if (i % 3 == 0) null else pDouble / 2
                    pFloat = i * 3.1416f
                    oFloat = if (i % 5 == 0) null else pFloat / 4
                    pInt = i - 50
                    oInt = if (i % 2 == 0) -pInt else null
                    pLong = id + 10000
                    oLong = if (i % 3 != 0) pLong * pLong else null
                    pShort = (i + 8).toShort()
                    oShort = if (i % 4 == 0) (i / 2 + 4).toShort() else null
                }
                models.add(model)
            }

            realm.executeTransaction {
                realm.insertOrUpdate(models)

                var k = 0
                for (i in 10 until 100) {
                    val model = models[i]

                    for (j in 2 until 10) {
                        if ( i % j == 0) model.list.add(models[j])
                    }

                    if (i % 5 == 0) model.obj = models[++k % 10]

                    realm.insertOrUpdate(model)
                }
            }
        }
    }
}