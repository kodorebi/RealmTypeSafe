package dev.kodorebi.realmtypesafe

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import dev.kodorebi.realmtypesafe.models.Car
import dev.kodorebi.realmtypesafe.models.Person
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
                KProperties(Car::id).path
            }

        val m12 =
            Benchmark.measure("Text 2 properties") { "owner.firstName" }
        val m22 =
            Benchmark.measure("Safe 2 properties") {
                Car::owner.dot(Person::firstName).path
            }

        val m13 =
            Benchmark.measure("Text 3 properties") { "owner.firstName.length" }
        val m23 =
            Benchmark.measure("Safe 3 properties") {
                (Car::owner dot Person::firstName dot String::length).path
            }

        assertEquals(m11, m21)
        assertEquals(m12, m22)
        assertEquals(m13, m23)
    }

    @Test
    fun average() {
        val warmUp = realm.where<Car>().average("price")
        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe average") {
                realm.where<Car>().average(Car::price)
            }
        val m1 =
            Benchmark.measure("Text average") {
                realm.where<Car>().average("price")
            }

        assertEquals("Different values", m1, m2, 0.0)
    }

    @Test
    fun beginsWith() {
        val term = "D"
        val warmUp = realm.where<Car>().beginsWith("brand", term).findAll()
        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe beginsWith") {
                realm.where<Car>().beginsWith(Car::brand, term).findAll()
            }
        val m1 =
            Benchmark.measure("Text beginsWith") {
                realm.where<Car>().beginsWith("brand", term).findAll()
            }


        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun beginsWithDot() {
        val term = "And"

        val warmUp = realm.where<Car>().beginsWith("owner.firstName", term).findAll()
        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe dot beginsWith") {
                realm.where<Car>().beginsWith(Car::owner.dot(Person::firstName), term).findAll()
            }
        val m1 =
            Benchmark.measure("Text dot beginsWith") {
                realm.where<Car>().beginsWith("owner.firstName", term).findAll()
            }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun contains() {
        val term = "ac"
        val warmUp = realm.where<Car>().contains("brand", term).findAll()
        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe contains") {
                realm.where<Car>().contains(Car::brand, term).findAll()
            }
        val m1 =
            Benchmark.measure("Text contains") {
                realm.where<Car>().contains("brand", term).findAll()
            }


        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun containsDot() {
        val term = "dr"

        val warmUp = realm.where<Car>()
            .contains("owner.firstName", term)
            .findAll()

        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe dot contains") {
                realm.where<Car>()
                    .contains(Car::owner.dot(Person::firstName), term)
                    .findAll()
            }

        val m1 =
            Benchmark.measure("Text dot contains") {
                realm.where<Car>()
                    .contains("owner.firstName", term)
                    .findAll()
            }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun distinct() {
        val warmUp = realm.where<Car>()
            .distinct("brand")
            .findAll()

        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe distinct") {
                realm.where<Car>()
                    .distinct(Car::brand)
                    .findAll()
            }

        val m1 =
            Benchmark.measure("Text distinct") {
                realm.where<Car>()
                    .distinct("brand")
                    .findAll()
            }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun endsWith() {
        val term = "ia"
        val warmUp = realm.where<Car>().endsWith("brand", term).findAll()
        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe beginsWith") {
                realm.where<Car>().endsWith(Car::brand, term).findAll()
            }
        val m1 =
            Benchmark.measure("Text beginsWith") {
                realm.where<Car>().endsWith("brand", term).findAll()
            }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun endsWithDot() {
        val term = "rew"

        val warmUp = realm.where<Car>().endsWith("owner.firstName", term).findAll()
        assertNotNull(warmUp)

        val m2 =
            Benchmark.measure("Safe dot beginsWith") {
                realm.where<Car>().endsWith(Car::owner.dot(Person::firstName), term).findAll()
            }
        val m1 =
            Benchmark.measure("Text dot beginsWith") {
                realm.where<Car>().endsWith("owner.firstName", term).findAll()
            }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun equalToString() {
        val term = "Dacia"

        val warmUp = realm.where<Car>().equalTo("brand", term).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe String equalTo") {
            realm.where<Car>().equalTo(Car::brand, term).findAll()
        }

        val m1 = Benchmark.measure("Text String equalTo") {
            realm.where<Car>().equalTo("brand", term).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun equalToDotString() {
        val term = "Dacia"

        val warmUp = realm.where<Car>().equalTo("owner.firstName", term).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe String equalTo") {
            realm.where<Car>().equalTo(Car::owner.dot(Person::firstName), term).findAll()
        }

        val m1 = Benchmark.measure("Text String equalTo") {
            realm.where<Car>().equalTo("owner.firstName", term).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun equalToDotListString() {
        val term = "Dacia"

        val warmUp = realm.where<Person>().equalTo("cars.brand", term).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe List String equalTo") {
            realm.where<Person>().equalTo(Person::cars edot Car::brand, term).findAll()
        }

        val m1 = Benchmark.measure("Text List String equalTo") {
            realm.where<Person>().equalTo("cars.brand", term).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    //TODO: define tests for other equalTo overloads


    @Test
    fun greaterThan() {
        val warmUp = realm.where<Car>().greaterThan("price", 2000.0).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe greaterThan") {
            realm.where<Car>().greaterThan(Car::price, 2000.0).findAll()
        }

        val m1 = Benchmark.measure("Text greaterThan") {
            realm.where<Car>().greaterThan("price", 2000.0).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun greaterThanDot() {
        val warmUp = realm.where<Car>().greaterThan("owner.age", 20).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe greaterThan") {
            realm.where<Car>().greaterThan(Car::owner.dot(Person::age), 20).findAll()
        }

        val m1 = Benchmark.measure("Text greaterThan") {
            realm.where<Car>().greaterThan("owner.age", 20).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun greaterThanDate() {
        val date = Date()

        val warmUp = realm.where<Car>().greaterThan("buyDate", date).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe Date greaterThan") {
            realm.where<Car>().greaterThan(Car::buyDate, date).findAll()
        }

        val m1 = Benchmark.measure("Text Date greaterThan") {
            realm.where<Car>().greaterThan("buyDate", date).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun greaterThanDotDate() {
        val date = Date()

        val warmUp = realm.where<Car>().greaterThan("owner.addedOn", date).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe dot Date greaterThan") {
            realm.where<Car>().greaterThan(Car::owner.dot(Person::addedOn), date).findAll()
        }

        val m1 = Benchmark.measure("Text dot Date greaterThan") {
            realm.where<Car>().greaterThan("owner.addedOn", date).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }


    @Test
    fun greaterThanOrEqualTo() {
        val warmUp = realm.where<Car>().greaterThanOrEqualTo("price", 2000.0).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe greaterThanOrEqualTo") {
            realm.where<Car>().greaterThanOrEqualTo(Car::price, 2000.0).findAll()
        }

        val m1 = Benchmark.measure("Text greaterThanOrEqualTo") {
            realm.where<Car>().greaterThanOrEqualTo("price", 2000.0).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun greaterThanOrEqualToDot() {
        val warmUp = realm.where<Car>().greaterThanOrEqualTo("owner.age", 20).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe dot greaterThanOrEqualTo") {
            realm.where<Car>().greaterThanOrEqualTo(Car::owner.dot(Person::age), 20).findAll()
        }

        val m1 = Benchmark.measure("Text dot greaterThanOrEqualTo") {
            realm.where<Car>().greaterThanOrEqualTo("owner.age", 20).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun greaterThanOrEqualToDate() {
        val date = Date()

        val warmUp = realm.where<Car>().greaterThanOrEqualTo("buyDate", date).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe Date greaterThanOrEqualTo") {
            realm.where<Car>().greaterThanOrEqualTo(Car::buyDate, date).findAll()
        }

        val m1 = Benchmark.measure("Text Date greaterThanOrEqualTo") {
            realm.where<Car>().greaterThanOrEqualTo("buyDate", date).findAll()
        }

        assertSameResults(m1, m2) { it.id }
    }

    @Test
    fun greaterThanOrEqualToDotDate() {
        val date = Date()

        val warmUp = realm.where<Car>().greaterThanOrEqualTo("owner.addedOn", date).findAll()
        assertNotNull(warmUp)

        val m2 = Benchmark.measure("Safe dot Date greaterThanOrEqualTo") {
            realm.where<Car>().greaterThanOrEqualTo(Car::owner.dot(Person::addedOn), date).findAll()
        }

        val m1 = Benchmark.measure("Text dot Date greaterThanOrEqualTo") {
            realm.where<Car>().greaterThanOrEqualTo("owner.addedOn", date).findAll()
        }

        assertSameResults(m1, m2) { it.id }

        Person::cars edot Car::brand
    }




    private inline fun <T, reified I : Comparable<I>> assertSameResults(expected: RealmResults<T>, actual: RealmResults<T>, id: (T) -> I) {
        assertArrayEquals(
            expected.map(id).sorted().toTypedArray(),
            actual.map(id).sorted().toTypedArray()
        )
    }
}
