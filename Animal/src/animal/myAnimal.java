package animal;

public class myAnimal {

    public static void main(String[] args) {
    	
        Animal myPet = new Animal("Eidref", 50, "Elephant", 24000, "Male", 15);
        myPet.printValues();
        
        Pet pet = new Pet ("Fluffy", 5, "spayed dog", 8, "Female", 12);
        pet.printValues();
    }
}
