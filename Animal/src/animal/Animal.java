package animal;

public class Pet extends Animal {
    public Pet(String name, int age, String type, int weight, String gender, int lifeExpectancy) {
        super(name, age, type, weight, gender, lifeExpectancy);
    }
    public void printValues(){
    	System.out.println("\nA " + getGender() + " " + getType() + " named " + getName() + " should live to be " + getAge() + " years old and weight " + getWeight() + " pounds.");
    }
}

 
