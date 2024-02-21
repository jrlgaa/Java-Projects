package animal;

public class Animal {
    private String name;
    private int age;
    private String type;
    private int weight;
    private String gender;
    private int lifeExpectancy;

    public Animal(String name, int age, String type, int weight, String gender, int lifeExpectancy) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.weight = weight;
        this.gender = gender;
        this.lifeExpectancy = lifeExpectancy;
    }

    public void printValues() {
    	System.out.println("\nA " + gender + " " + type + " named " + name + " should live to be " + age + " years old and weight " + weight + " pounds.\n");
    }
    
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }
    public String getGender () {
    	return gender;
    }
    public int getLifeExpectancy () {
    	return lifeExpectancy;
    }
}
