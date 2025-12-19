public class task9
{
    public static void main(String[] args)
    {
        Person person = new Person("Ivan", "Ivanov");
        System.out.println("Dossier.");
        System.out.println("Name: " + person.getFirstName());
        System.out.println("LastName: " + person.getLastName());
        System.out.println("Full name: " + person.getFullName());
    }
}

class Person {
    private String firstName;
    private String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

     String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    String getFullName() {
        return firstName + " " + lastName;
    }
}
