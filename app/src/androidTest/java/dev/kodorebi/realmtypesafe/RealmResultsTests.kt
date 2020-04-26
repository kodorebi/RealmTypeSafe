package dev.kodorebi.realmtypesafe

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import dev.kodorebi.realmtypesafe.models.TestModel
import dev.kodorebi.realmtypesafe.results.max
import dev.kodorebi.realmtypesafe.results.maxDate
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.where
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RealmResultsTests {
    companion object {
        private lateinit var realm: Realm

        @BeforeClass
        @JvmStatic
        fun setup() {
            Log.d("INIT", "init")
            val appContext = InstrumentationRegistry.getInstrumentation().targetContext

            Realm.init(appContext)

            val realmConfig = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()

            Realm.setDefaultConfiguration(realmConfig)

            realm = Realm.getDefaultInstance()
            DbData.prepare(realm)
        }
    }

    @Test
    fun max() {
        val results = realm.where<TestModel>().findAll()

        val pd2 = results.max(TestModel::pDouble)
        val pd1 = results.max("pDouble")?.toDouble()

        val od2 = results.max(TestModel::oDouble)
        val od1 = results.max("oDouble")?.toDouble()

        val pf2 = results.max(TestModel::pFloat)
        val pf1 = results.max("pFloat")?.toFloat()

        val of2 = results.max(TestModel::oFloat)
        val of1 = results.max("oFloat")?.toFloat()

        assert(pd2 == pd1)
        assert(od2 == od1)
        assert(pf2 == pf1)
        assert(of2 == of1)
    }

    @Test
    fun maxDate() {
        val results = realm.where<TestModel>().findAll()

        val pd2 = results.maxDate(TestModel::pDate)
        val pd1 = results.maxDate("pDate")

        val od2 = results.maxDate(TestModel::oDate)
        val od1 = results.maxDate("oDate")

        assert(pd2 == pd1)
        assert(od2 == od1)
    }
}