package dev.kodorebi.realmtypesafe

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.where
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

    }
}