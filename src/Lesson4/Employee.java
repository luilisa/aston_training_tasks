package Lesson4;

public class Employee {
    public String name;
    public String position;
    public String email;
    public String phoneNumber;
    public int salary;
    public int age;

    public Employee(String name, String position, String email,
                    String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String info() {
        return "Employee " +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", salary=" + salary +
                ", age=" + age;
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Tony Stark", "Backend Developer",
                "starkindustries@yandex.com", "89112223344", 300000, 42);
        employees[1] = new Employee("Thor Odinson", "DevOps Engineer",
                "godofthunder@mail.ru", "89223334455", 50000, 10000);
        employees[2] = new Employee("Steven Rogers", "Project Manager",
                "captainamericaofficial@gmail.com", "89334445566", 250000, 85);
        employees[3] = new Employee("Clinton Barton", "QA Engineer",
                "hawkeye@astondevs.com", "89445556677", 170000, 47);
        employees[4] = new Employee("Romanova Natalia", "Frontend Developer",
                "blackwidow@mail.ru", "89556667788", 230000, 28);

        for (Employee employee: employees) {
            if (employee.age > 40) {
                System.out.println(employee.info());
            }
        }

    }
}
