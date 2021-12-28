package lesson5;

public class employee {

    private String name;
    private String post;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public employee(String name, String post, String email, String phone, int salary, int age) {
        this.age = age;
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }

    int getAge() { return age;}
    String getFullInfo() { return this.age + " - age, " + this.name + " - name, " + this.post + " - post, " + this.email + " - email, " + this.phone + " - phone number, " + this.salary + "$ - salary."; }




}
