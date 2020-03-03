package dev.kodorebi.realmtypesafe

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import dev.kodorebi.realmtypesafe.models.TestModel
import dev.kodorebi.realmtypesafe.query.*
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import io.realm.kotlin.where
import org.junit.Assert.*
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class RealmQueryTests {

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
    fun kProperties() {
        val m11 =
            Benchmark.measure("Text 1 property") { "id" }
        val m21 =
            Benchmark.measure("Safe 1 property") {
                KProperties(TestModel::id).path
            }

        val m12 =
            Benchmark.measure("Text 2 properties") { "obj.pString" }
        val m22 =
            Benchmark.measure("Safe 2 properties") {
                TestModel::obj.dot(TestModel::pString).path
            }

        val m13 =
            Benchmark.measure("Text 3 properties") { "obj.pString.length" }
        val m23 =
            Benchmark.measure("Safe 3 properties") {
                (TestModel::obj dot TestModel::pString dot String::length).path
            }

        assertEquals(m11, m21)
        assertEquals(m12, m22)
        assertEquals(m13, m23)
    }

    @Test
    fun average() {
        val warmUp = realm.where<TestModel>().average("pDouble")
        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe average") {
                realm.where<TestModel>().average(TestModel::pDouble)
            }
        val m1 =
            Benchmark.measure("Text average") {
                realm.where<TestModel>().average("pDouble")
            }

        assertEquals("Different values", m1, m2, 0.0)
    }

    @Test
    fun beginsWith() {
        val term = "p"
        val warmUp = realm.where<TestModel>().beginsWith("pString", term).findAll()
        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe beginsWith") {
                realm.where<TestModel>().beginsWith(TestModel::pString, term).findAll()
            }
        val m1 =
            Benchmark.measure("Text beginsWith") {
                realm.where<TestModel>().beginsWith("pString", term).findAll()
            }


        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun beginsWithDot() {
        val term = "p"

        val warmUp = realm.where<TestModel>().beginsWith("obj.pString", term).findAll()
        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe dot beginsWith") {
                realm.where<TestModel>().beginsWith(TestModel::obj.dot(TestModel::pString), term).findAll()
            }
        val m1 =
            Benchmark.measure("Text dot beginsWith") {
                realm.where<TestModel>().beginsWith("obj.pString", term).findAll()
            }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun contains() {
        val term = "si"
        val warmUp = realm.where<TestModel>().contains("pString", term).findAll()
        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe contains") {
                realm.where<TestModel>().contains(TestModel::pString, term).findAll()
            }
        val m1 =
            Benchmark.measure("Text contains") {
                realm.where<TestModel>().contains("pString", term).findAll()
            }


        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun containsDot() {
        val term = "a"

        val warmUp = realm.where<TestModel>()
            .contains("obj.pString", term)
            .findAll()

        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe dot contains") {
                realm.where<TestModel>()
                    .contains(TestModel::obj.dot(TestModel::pString), term)
                    .findAll()
            }

        val m1 =
            Benchmark.measure("Text dot contains") {
                realm.where<TestModel>()
                    .contains("obj.pString", term)
                    .findAll()
            }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun distinct() {
        val warmUp = realm.where<TestModel>()
            .distinct("pString")
            .findAll()

        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe distinct") {
                realm.where<TestModel>()
                    .distinct(TestModel::pString)
                    .findAll()
            }

        val m1 =
            Benchmark.measure("Text distinct") {
                realm.where<TestModel>()
                    .distinct("pString")
                    .findAll()
            }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun endsWith() {
        val term = "on"
        val warmUp = realm.where<TestModel>().endsWith("pString", term).findAll()
        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe beginsWith") {
                realm.where<TestModel>().endsWith(TestModel::pString, term).findAll()
            }
        val m1 =
            Benchmark.measure("Text beginsWith") {
                realm.where<TestModel>().endsWith("pString", term).findAll()
            }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun endsWithDot() {
        val term = "rew"

        val warmUp = realm.where<TestModel>().endsWith("obj.pString", term).findAll()
        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe dot beginsWith") {
                realm.where<TestModel>().endsWith(TestModel::obj.dot(TestModel::pString), term).findAll()
            }
        val m1 =
            Benchmark.measure("Text dot beginsWith") {
                realm.where<TestModel>().endsWith("obj.pString", term).findAll()
            }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun equalToString() {
        val term = "Dacia"

        val warmUp = realm.where<TestModel>().equalTo("pString", term).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe String equalTo") {
            realm.where<TestModel>().equalTo(TestModel::pString, term).findAll()
        }

        val m1 = Benchmark.measure("Text String equalTo") {
            realm.where<TestModel>().equalTo("pString", term).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun equalToDotString() {
        val term = "Dacia"

        val warmUp = realm.where<TestModel>().equalTo("obj.pString", term).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe String equalTo") {
            realm.where<TestModel>().equalTo(TestModel::obj.dot(TestModel::pString), term).findAll()
        }

        val m1 = Benchmark.measure("Text String equalTo") {
            realm.where<TestModel>().equalTo("obj.pString", term).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun equalToDotListString() {
        val term = "omega 3"

        val warmUp = realm.where<TestModel>().equalTo("list.pString", term).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe List String equalTo") {
            realm.where<TestModel>().equalTo(TestModel::list edot TestModel::pString, term).findAll()
        }

        val m1 = Benchmark.measure("Text List String equalTo") {
            realm.where<TestModel>().equalTo("list.pString", term).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    //TODO: define tests for other equalTo overloads


    @Test
    fun greaterThan() {
        val warmUp = realm.where<TestModel>().greaterThan("pDouble", 2000.0).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe greaterThan") {
            realm.where<TestModel>().greaterThan(TestModel::pDouble, 2000.0).findAll()
        }

        val m1 = Benchmark.measure("Text greaterThan") {
            realm.where<TestModel>().greaterThan("pDouble", 2000.0).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun greaterThanDot() {
        val warmUp = realm.where<TestModel>().greaterThan("obj.pInt", 20).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe greaterThan") {
            realm.where<TestModel>().greaterThan(TestModel::obj.dot(TestModel::pInt), 20).findAll()
        }

        val m1 = Benchmark.measure("Text greaterThan") {
            realm.where<TestModel>().greaterThan("obj.pInt", 20).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun greaterThanDate() {
        val date = Date()

        val warmUp = realm.where<TestModel>().greaterThan("pDate", date).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe Date greaterThan") {
            realm.where<TestModel>().greaterThan(TestModel::pDate, date).findAll()
        }

        val m1 = Benchmark.measure("Text Date greaterThan") {
            realm.where<TestModel>().greaterThan("pDate", date).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun greaterThanDotDate() {
        val date = Date()

        val warmUp = realm.where<TestModel>().greaterThan("obj.pDate", date).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe dot Date greaterThan") {
            realm.where<TestModel>().greaterThan(TestModel::obj.dot(TestModel::pDate), date).findAll()
        }

        val m1 = Benchmark.measure("Text dot Date greaterThan") {
            realm.where<TestModel>().greaterThan("obj.pDate", date).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }


    @Test
    fun greaterThanOrEqualTo() {
        val warmUp = realm.where<TestModel>().greaterThanOrEqualTo("pDouble", 2000.0).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe greaterThanOrEqualTo") {
            realm.where<TestModel>().greaterThanOrEqualTo(TestModel::pDouble, 2000.0).findAll()
        }

        val m1 = Benchmark.measure("Text greaterThanOrEqualTo") {
            realm.where<TestModel>().greaterThanOrEqualTo("pDouble", 2000.0).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun greaterThanOrEqualToDot() {
        val warmUp = realm.where<TestModel>().greaterThanOrEqualTo("obj.pInt", 20).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe dot greaterThanOrEqualTo") {
            realm.where<TestModel>().greaterThanOrEqualTo(TestModel::obj.dot(TestModel::pInt), 20).findAll()
        }

        val m1 = Benchmark.measure("Text dot greaterThanOrEqualTo") {
            realm.where<TestModel>().greaterThanOrEqualTo("obj.pInt", 20).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun greaterThanOrEqualToDate() {
        val date = Date()

        val warmUp = realm.where<TestModel>().greaterThanOrEqualTo("pDate", date).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe Date greaterThanOrEqualTo") {
            realm.where<TestModel>().greaterThanOrEqualTo(TestModel::pDate, date).findAll()
        }

        val m1 = Benchmark.measure("Text Date greaterThanOrEqualTo") {
            realm.where<TestModel>().greaterThanOrEqualTo("pDate", date).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun greaterThanOrEqualToDotDate() {
        val date = Date()

        val warmUp = realm.where<TestModel>().greaterThanOrEqualTo("obj.pDate", date).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe dot Date greaterThanOrEqualTo") {
            realm.where<TestModel>().greaterThanOrEqualTo(TestModel::obj.dot(TestModel::pDate), date).findAll()
        }

        val m1 = Benchmark.measure("Text dot Date greaterThanOrEqualTo") {
            realm.where<TestModel>().greaterThanOrEqualTo("obj.pDate", date).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }




    private inline fun <T, reified I : Comparable<I>> assertSameResults(expected: RealmResults<T>, actual: RealmResults<T>, id: (T) -> I) {
        assertArrayEquals(
            expected.map(id).sorted().toTypedArray(),
            actual.map(id).sorted().toTypedArray()
        )
    }
}
