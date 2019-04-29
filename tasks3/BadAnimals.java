
/*
* 3.4 instanceof Ersetzung
* Die Verwendung von instanceof ist allgemein als schlechter Stil angesehen und kann leicht vermieden werden.
* Das im Anhang befindliche Programm BadAnimals setzt stark auf die Nutzung von instanceof. 
* Ändern Sie das indem Sie Verwendungen von instanceof durch dynamische Methodenlookups und Polymorphie ersetzen.
*
*/
class BadAnimals {

	public static void printAnimalMoving(Animal a)
	{
		a.move();
	}
	public static void main(String[] Args)
	{
		Animal a = new Animal();
		Dog d = new Dog();
		Cat c = new Cat();
		Bird b = new Bird();
		Cheetah ch = new Cheetah();
		Sloth s = new Sloth();
		
		printAnimalMoving(a);
		printAnimalMoving(b);
		printAnimalMoving(d);
		printAnimalMoving(c);
		printAnimalMoving(ch);
		printAnimalMoving(s);
	}
}
		

class Animal {
	public void move(){
		System.out.println("I'm an Animal, I just move.");
	}
}

class Dog extends Animal {
	@Override
	public void move(){
		run();
	}
	public void run()
	{
		System.out.println("Dogs run.");
	}
}

class Cat extends Animal {
	@Override
	public void move(){
		tiptoe();
	}
	public void tiptoe()
	{
		System.out.println("Cats tiptoe.");
	}
}

class Bird extends Animal {
	@Override
	public void move(){
		fly();
	}
	public void fly()
	{
		System.out.println("Birds fly.");
	}
}

class Cheetah extends Animal {
	@Override
	public void move(){
		sprint();
	}
	public void sprint()
	{
		System.out.println("Cheetah sprint.");
	}
}

class Sloth extends Animal {
	@Override
	public void move(){
		hang();
	}
	public void hang()
	{
		System.out.println("Sloths don't move!");
	}
}