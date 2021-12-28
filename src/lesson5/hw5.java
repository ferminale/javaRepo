package lesson5;

public class hw5 {

    public static void main(String[] args) {
        employee[] persArray = new employee[5];
        persArray[0] = new employee("Albert Albertovich Albertov", "engineer", "123@mail.mail", "89991111111", 100000, 37);
        persArray[1] = new employee("Boris Borisovich Borisov", "main engineer", "312@mail.mail", "89992222222", 200000, 38);
        persArray[2] = new employee("Vladimir Vladimirovich Vladimirov", "cleaner", "132@mail.mail", "89993333333", 5800, 39);
        persArray[3] = new employee("Gadina Gadinovna Gadinova", "main cleaner", "231@mail.mail", "89994444444", 6800, 40);
        persArray[4] = new employee("Danil Danilovich Danilov", "security", "312@mail.mail", "89995555555", 7231, 41);

        getAllEmployee(persArray);
        System.out.println("__________________________");
        getOverFourty(persArray);

    }


private static void getAllEmployee(employee[] persArray) {
        System.out.println("5 employee: ");
    for (int i = 0; i < persArray.length; i++) {
        System.out.println((i + 1) + " " + persArray[i].getFullInfo());
    }
}

private static void getOverFourty(employee[] persArray) {
    for (int i = 0; i < persArray.length; i++) {
        if (persArray[i].getAge() > 40) {
            System.out.println(persArray[i].getFullInfo());
            }
        }
    }
}



