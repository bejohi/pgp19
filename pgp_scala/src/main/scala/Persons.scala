/**
5.4 Iterable und Funktionen höherer Ordnung in Scala

In Scala implementiert die List das Iterable Trait, das viele Funktionen höherer Ordnung bereitstellt. Diese sollen Sie in den folgenden Aufgaben verwenden, um Problemstellungen über einer Liste von Personen zu lösen.


a) Nutzen Sie exakt eine Funktion höherer Ordnung, um eine Liste aller Nachnamen zu erhalten. Sie können davon ausgehen, dass kein Nachname mehrfach auftritt.


b) Ermitteln Sie jetzt aus der Personenliste alle Personen, die im Oktober Geburtstag haben mittels einer Funktion höherer Ordnung. Da Scala keine Schnittstellen für Datum und Zeit hat, werden hier die Schnittstellen aus Java verwendet (java.time.LocalDate).


c) Berechnen Sie nun mittels genau einer Funktion höherer Ordnung das Alter jeder Person, um eine Liste mit dem Alter jeder Person zu erhalten (List(23, 69, 45, 74, 55)). Um das Alter einer Person zu bestimmen können Sie die Java-Klasse java.time.Period verwenden.


d) Berechnen Sie nun das Durchschnittsalter aller Personen. Nutzen Sie hierfür ausschließlich Methoden, die in dem Iterable Trait definiert sind.

  */

import java.time.{LocalDate, Month, Period};

class Person(
  val surname: String,
  val lastname: String,
  val dayOfBirth: LocalDate
) {
  override def toString(): String = {
    surname + " " + lastname
  }
}


object Main {
  def main(args: Array[String]): Unit = {
    val persons = List(
      new Person("Kerstin", "Herz", LocalDate.of(1995, 5, 31)),
      new Person("Matthias", "Zimmermann", LocalDate.of(1950, 1, 23)),
      new Person("Jan", "Schultheiss", LocalDate.of(1973, 10, 10)),
      new Person("Jennifer", "Fischer", LocalDate.of(1944, 12, 4)),
      new Person("Andreas", "Kaufmann", LocalDate.of(1964, 4, 3))
    )

    // a)
    persons.foreach(person => println(person.lastname))

    // b)
    persons.filter(person => person.dayOfBirth.getMonth.equals(Month.OCTOBER))
      .foreach(person => println(person.lastname))

    // c)
    persons.map(person => Period.between(person.dayOfBirth,LocalDate.now()).getYears).foreach(year => println(year))

    // d)
    // Note: We are only using the years to evaluate the average.
    // foldLeft could be replaced with sum!
    println(persons.map(person => Period.between(person.dayOfBirth, LocalDate.now()).getYears).foldLeft(0)(_ + _) / persons.length)
  }
}

