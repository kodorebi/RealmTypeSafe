# RealmTypeSafe
A collection of Kotlin extensions on `RealmQuery` and `RealmResults` that enable type safe variants of the available operations.

### Warning: this project is not yet in a production-ready state.

## Examples

We'll use the traditional models that [Realm Docs](https://realm.io/docs/kotlin/latest/#queries) use:

```kotlin
open class Dog(
    var id: String = "",
    var name: String = "",
    var color: String = ""
): RealmObject()

open class Person(
    var id: String = "",
    var name: String = "",
    var dogs: RealmList<Dog> = RealmList()
): RealmObject()
```

## Example 1: Query by simple property

Find Persons with name "John" or "Joe":

```kotlin
val result = realm.where<Person>()
    .equalTo("name", "John")
    .or()
    .equalTo("name", "Joe")
    .findAll()
```

The same type safe query looks like this:
```kotlin
val result = realm.where<Person>()
    .equalTo(Person::name, "John")
    .or()
    .equalTo(Person::name, "Joe")
    .findAll()
```

## Example 2: Query by 'path'

Most of the operations on `RealmQuery` an `RealmResults` can also work with a nested property or a _path trough the relationships_.
The following query translates to: _Find all **persons** who have **brown dogs** that are **named "Fluffy"**_
```kotlin
val result = realm.where<Person>()
    .equalTo("dogs.name", "Fluffy")
    .equalTo("dogs.color", "Brown")
    .findAll()
```

The same type safe query:
```kotlin
val result = realm.where<Person>()
    .equalTo(Person::dogs.dot(Dog::name), "Fluffy")
    .equalTo(Person::dogs.dot(Dog::color), "Brown")
    .findAll()
```

As you can see the dot function is used to chain the properties.
If you preffer, you can use its infix notation:
```kotlin
val result = realm.where<Person>()
    .equalTo(Person::dogs dot Dog::name, "Fluffy")
    .equalTo(Person::dogs dot Dog::color, "Brown")
    .findAll()
```

## The pros
As you may have guessed, the number one advantage of using RealmTypeSafe is **type safety**.
Classic Realm queries allow you to accidentally write code that compiles OK but will crash.
With type safe queries this kind of problems won't get the chance to creep into your code.

Some other notable advantages are:
- Better refactoring ability

  In the early stages of development when database models change more often you won't have to worry about updating the queries when a property name change. Or, if you change the type of a property that is involved in some queries, you'll immediately know that the queries are no longer valid.
- Better navigability in IDE

  With type safe queries you can navigate to properties of a model

## The con
The type safe extensions are possible due to Kotlin reflection. The overhead is negligibly small.

However, this one disadvantage won't go unnoticed: **The type safe queries are more verbose**.

Unfortunately, we have to use the type name before each property in the chain.

We hope that this will be solved in a future version of Kotlin where something more succint as [Swift `KeyPath`s](https://developer.apple.com/documentation/swift/keypath) will be available.

## Tasks list:
- [x] implement type safe variants of operations on `RealmQuery`
- [x] implement type safe variants of operations on `RealmResults`
- [ ] Write tests for operations on `RealmQuery`
- [ ] Write tests for operations on `RealmResults`
- [ ] Add benchmarks to prove the overhead is negligible
- [ ] Add licence information
