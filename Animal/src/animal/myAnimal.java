package animal;

public class myAnimal {

    public static void main(String[] args) {
    	
        Animal myPet = new Animal("Fluffy", 5, "spayed dog", 8, "Female", 12);
        myPet.printValues();
        
        Pet pet = new Pet ("Eidref", 50, "Elephant", 24000, "Male", 15);
        pet.printValues();
    }
}
