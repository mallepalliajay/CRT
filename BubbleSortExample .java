class Person {
    String name;
    String phoneNumber;
    String email;

    // Constructor to initialize the fields
    public Person(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Method to display person's information
    public void display() {
        System.out.println("Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email);
    }
}

public class BubbleSortExample {

    // Bubble sort method to sort array of Person objects by name
    public static void bubbleSort(Person[] people) {
        int n = people.length;
        Person temp;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparisons in each pass
            for (int j = 0; j < n - 1 - i; j++) {
                // Compare names lexicographically
                if (people[j].name.compareToIgnoreCase(people[j + 1].name) > 0) {
                    // Swap if current name is greater than next name
                    temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create an array of Person objects
        Person[] people = {
            new Person("Alice", "123-456-7890", "alice@example.com"),
            new Person("Charlie", "555-666-7777", "charlie@example.com"),
            new Person("Bob", "987-654-3210", "bob@example.com"),
            new Person("David", "111-222-3333", "david@example.com")
        };

        System.out.println("Before sorting:");
        for (Person p : people) {
            p.display();
        }

        // Sort the array by name
        bubbleSort(people);

        System.out.println("\nAfter sorting by name:");
        for (Person p : people) {
            p.display();
        }
    }
}
