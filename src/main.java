import jdk.nio.mapmode.ExtendedMapMode;

import java.util.Random;

public class main {

    private final static Random random = new Random();
    private final static String[] names = {"Иван", "Игорь", "Давид", "Сергей", "Данил", "Константин", "Николай", "Эдуард", "Петр"};
    private final static String[] surnames = {"Иванов", "Петров", "Измайлов", "Чернышов", "Рыбкин", "Соловьев", "Львов",
            "Кивин", "Перлов", "Ракетин", "Машинин", "Карасев",};

    private final static String[] middle_names = {"Иванович", "Петрович", "Игоревич", "Константинович", "Эдуардович",
            "Витальевич", "Сергеевич", "Николаевич", "Магомедович"};

    private final static Employee[] EMPLOYEES = new Employee[10];

    private static void randomEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = surnames[random.nextInt(0, surnames.length)] + " " +
                    names[random.nextInt(0, names.length)] + " " +
                    middle_names[random.nextInt(0, middle_names.length)] + " ";
            EMPLOYEES[i] = new Employee(fullName, random.nextInt(1, 6), random.nextInt(55_55,
                    595959));
        }
    }

    public static void main(String[] args) {
        randomEmployees();
        print();
        System.out.println("Сумма ЗП сотрудников: " + calculateSumOfSalaries());
        System.out.println("Сотрудник с мин ЗП: " + findEmployeeWitchMinSalary());
        System.out.println("Сотрудник с макс ЗП: " + findEmployeeWitchMaxSalary());
        System.out.println("Средняя ЗП: " + calculateAverageOfSalaries());
        printFullNames();
    }

    private static void print() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int calculateSumOfSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null)
                sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findEmployeeWitchMinSalary() {
        Employee employeeWitchMinSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWitchMinSalary == null || employee.getSalary() < employeeWitchMinSalary.getSalary()) {
                employeeWitchMinSalary = employee;
            }
        }
        return employeeWitchMinSalary;
    }

    private static Employee findEmployeeWitchMaxSalary() {
        Employee employeeWitchMaxSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWitchMaxSalary == null || employee.getSalary() > employeeWitchMaxSalary.getSalary()) {
                employeeWitchMaxSalary = employee;
            }
        }
        return employeeWitchMaxSalary;
    }

    private static double calculateAverageOfSalaries() {
        return (double) calculateSumOfSalaries() / EMPLOYEES.length;
    }

    private static void printFullNames() {
        for (Employee employee : main.EMPLOYEES) {
            if (employee != null) System.out.println(employee.getFullName());
        }
    }
}

