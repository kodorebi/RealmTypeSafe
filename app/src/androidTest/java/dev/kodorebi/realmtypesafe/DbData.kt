package dev.kodorebi.realmtypesafe

import android.graphics.Color
import dev.kodorebi.realmtypesafe.models.Car
import dev.kodorebi.realmtypesafe.models.Person
import io.realm.Realm
import io.realm.kotlin.where
import java.util.*

class DbData {
    companion object {
        fun prepare(realm : Realm) {
            val any = realm.where<Car>().count() > 0

            if (any) {
                return
            }


            insert(realm)


        }

        private fun insert(realm: Realm){
            val owner = Person()
            with(owner) {
                id = 1
                age = 30
                firstName = "Andrew"
                lastName = "Smith"
            }

            val cars = mutableListOf(
                Car(1, "Dacia", "1310", Color.WHITE, Date(), 1950, 1000.0),
                Car(2, "Dacia", "Logan MVC", Color.DKGRAY, Date(), 2007, 5000.0),
                Car(3, "Dacia", "Logan", Color.WHITE, Date(), 2015, 7000.0)
            )

            realm.executeTransaction {
                realm.insertOrUpdate(owner)

                for (car in cars) {
                    car.owner = owner
                }

                realm.insertOrUpdate(cars)
            }
        }
    }
}