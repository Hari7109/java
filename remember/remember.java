class RememberValues {
    private String name;
    private int age;
    private String profession;

    public RememberValues(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Profession: " + profession);
    }
}


public class remember {
    public static void main(String[] args) {
       
        RememberValues person = new RememberValues("John Doe", 30, "Painter");
        person.display();
    }
}
