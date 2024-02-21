package animal;

public class Pet extends Animal {
    public Pet(String name, int age, String type, int weight, String gender, int lifeExpectancy) {
        super(name, age, type, weight, gender, lifeExpectancy);
    }

    public void printValues(){
        System.out.println(getName() + " is a " + getGender() + " " + getType() + " that lives indoors and does not bite. It should live up to " + getLifeExpectancy() + " years old and its weight is " + getWeight() + " pounds.");
    }
}


 