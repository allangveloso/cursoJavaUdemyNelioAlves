package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayerList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int numberOfPayers = sc.nextInt();

        for (int i = 1; i <= numberOfPayers; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char op = sc.next().toLowerCase().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Anual Income: ");
            double anualIncome = sc.nextDouble();

            if (op == 'i') {
                System.out.print("Value of annualy health expenditures: ");
                double he = sc.nextDouble();
                taxPayerList.add(new Individual(name, anualIncome, he));
            } else if (op == 'c') {
                System.out.print("Quantity of employees: ");
                int qteEmp = sc.nextInt();
                taxPayerList.add(new Company(name, anualIncome, qteEmp));
            } else {
                System.out.println("Invalid value!");
            }
        }

        double totalTaxes = 0;
        System.out.println();
        System.out.println("TAXES PAID:");
        for (TaxPayer tp : taxPayerList) {
            double tax = tp.tax();
            System.out.print(tp.getName() + ": $ " + String.format("%.2f", tax));
            totalTaxes += tax;
            System.out.println();
        }

        System.out.println();
        System.out.print("TOTAL TAXES: $ " + String.format("%.2f", totalTaxes));

        System.out.println();
    }
}
