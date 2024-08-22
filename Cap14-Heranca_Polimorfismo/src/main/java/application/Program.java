package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee employee;

        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int empQtd = sc.nextInt();
        char op = 0;

        for (int i = 1; i <= empQtd; i++) {
            System.out.println("Employee #" +i+ " data: ");
            System.out.print("Outsourced (y/n)? ");
            op = sc.next().charAt(0);
            System.out.print("Name: ");
            String empName = sc.next();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            Double valueHours = sc.nextDouble();

            if (op == 'y') {
                System.out.print("Additional charge: ");
                double addCharge = sc.nextDouble();

                employee = new OutsourcedEmployee(empName, hours, valueHours, addCharge);
            } else {
                employee = new Employee(empName, hours, valueHours);
            }
            employees.add(employee);
        }

        System.out.println("PAYMENTS");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}