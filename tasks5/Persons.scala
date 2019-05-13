import java.time.LocalDate;
import java.time.Period;

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
    );

    // TODO
  }
}

