/*

Case Classes und Pattern Matching

Sie haben bereits in 6.1 Case Classes kennen gelernt und wissen nun was mithilfe dieser alles umsetzbar ist.
Nun sollen sie Ihr erworbenes Wissen einmal nutzen um Raketen zu filtern.

Eine Liste von Raketen ist durch Pattern Matching zu filtern, wobei jede Rakete, die das Muster erfüllt, dann in die Konsole ausgegeben werden soll.
Über diese Raketen ist bekannt:

    Sie besitzen einen Namen
    Eine Anzahl von stages (Stufen)
    Einen verwendeten Treibstoff


Zum Beispiel:
Die Falcon 9 ist eine 2-stufige Rakete, welche ein RP-1/LOX Gemisch als Treibstoff nutzt.
Die Ariane 5 ist eine 2-stufige Rakete, welche ein LH2/LOX Gemisch als Treibstoff nutzt.
Die Soyuz  ist eine 2-stufige Rakete, welche ein RP-1/LOX Gemisch als Treibstoff nutzt.
Die Proton ist eine 3-stufige Rakete, welche ein N2H4/UDMH Gemisch als Treibstoff nutzt.
Die Delta IV ist eine 2-stufige Rakete, welche ein LH2/LOX Gemisch als Treibstoff nutzt.

All diese Information sollen dann durch eine Case Class Rocket gespeichert werden.

Preparation-Sequence 1) Alle Raketen die 2 Stages besitzen sollen mithilfe von printIf2Stages ausgeben werden.

Preparation-Sequence 2) Alle Raketen die LH2/LOX als Treibstoff nutzen sollen mithilfe von printIfLH2LOX ausgegeben werden.

Preparation-Sequence 3) Alle Raketen deren Treibstoff LOX enthält sollen mithilfe von printIfLOX ausgegeben werden.

 */


object Rockets {

	def printIf2Stages(rocket: Rocket) = {
		rocket.stages match {
			case 2 => println(rocket.name)
			case _ =>
		}
	}

	def printIfLH2LOX(rocket: Rocket) = {
		rocket.fuel match{
			case "LH2LOX" => println(rocket.name)
			case _ =>
		}
	}

	def printIfLOX(rocket: Rocket) = {
		rocket.fuel match {
			case str if str.contains("LOX") => println(rocket.name)
				case _ =>
		}
	}

	case class Rocket(name:String,stages:Int,fuel:String)

	def main(Args: Array[String]) = {
		val rockets = List(
			Rocket("Falcon9",2,"RP-1/LOX"),
			Rocket("Ariane",2,"LH2/LOX"),
			Rocket("Soyuz",2,"RP-1/LOX"),
			Rocket("Proton",3,"N2H4/UDMH"),
			Rocket("Delta IV",2,"LH2/LOX")
		)

		println("All rockets with 2 stages:")
		for (rocket <- rockets) {
			printIf2Stages(rocket)
		}

		println("All rockets with LH2/LOX:")
		for (rocket <- rockets) {  
			printIfLH2LOX(rocket)
		}

		println("All rockets that use LOX as oxidizer:")
		for (rocket <- rockets) {
				printIfLOX(rocket)
		}
	}
}
