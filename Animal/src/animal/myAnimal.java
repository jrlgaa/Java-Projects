package animal;

public class Animal {

    public static void main(String[] args) {
    	
        Pet dog = new Pet("Fluffy", 5, "spayed dog", 8, "Female", 12);
        dog.printValues();
        
        Animal elephant = new Animal ("Eidref", 50, "Elephant", 24000, "Male", 15);
        elephant.printValues();
    }
}
