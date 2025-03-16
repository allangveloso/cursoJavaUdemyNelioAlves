package app;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayerList = new ArrayList<>();
        double amountTaxes=0;

        System.out.print( "Enter the number of tax payers: " );
        int taxPayersQuantity = sc.nextInt();

        for (int i=1; i<=taxPayersQuantity; i++) {
            System.out.println("Tax payer #" + i + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char typeOfTaxPayer = sc.next().charAt(0);

            System.out.print("Name: ");
            String nameOfTaxPayer = sc.next();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();

            if (typeOfTaxPayer == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();

                Individual taxPayer = new Individual(nameOfTaxPayer, anualIncome, healthExpenditures);
                taxPayerList.add(taxPayer);

            } else if (typeOfTaxPayer == 'c') {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();

                Company taxPayer = new Company(nameOfTaxPayer, anualIncome, numberOfEmployees);
                taxPayerList.add(taxPayer);
            } else
                System.out.println("Type of Tax Payer don't recognized. Try 'i' or 'c'");

            System.out.println();
        }
        System.out.println();
        System.out.println("TAX PAID: ");
        for(TaxPayer tp : taxPayerList){
            System.out.println(tp.getNameOfTaxPayer() + ": $ " + String.format("%.2f",tp.anualTaxes()));
            amountTaxes += tp.anualTaxes();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f",amountTaxes));

    }
}
