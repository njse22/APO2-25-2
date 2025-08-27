package model;

public class Person implements Comparable<Person> {

    private String name;
    private String lastName;
    private int age;
    private double altura;

    public Person(String name, String lastName, int age, double altura) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.altura = altura;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public int compareTo(Person otherPerson){
        int result = 0;
        result = this.age - otherPerson.getAge();
        if (result == 0){
            result = this.name.compareTo(otherPerson.getName());
        }
        return result;
    }
}
