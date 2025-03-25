package app;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;
import java.text.SimpleDateFormat;
import java.util.*;

public class App
{
    public static void main( String[] args ) throws InterruptedException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayerList = new ArrayList<>();
        double amountTaxes=0;
        int taxPayersQuantity = 0;
        char typeOfTaxPayer;

        while (true) {
            System.out.print("Enter the number of tax payers: ");
            if (sc.hasNextInt()) {
                taxPayersQuantity = sc.nextInt();
                if(taxPayersQuantity <= 0){
                    numbersGreaterThanZero();
                }
                else
                    break;
            } else {
                onlyNumbersAllowed();
                sc.next(); // clear the invalid input
            }
        }
        /* //using try/Catch
        try{
            taxPayersQuantity = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Only numbers are allowed!");
            sc.close();
            System.exit(0);
        } catch (RuntimeException e){
            System.out.println("Unexpected error!");
            sc.close();
            System.exit(0);
        }
        */

        for (int i=1; i<=taxPayersQuantity; i++) {
            System.out.println("+** Tax payer #" + i + " data ***");
            while (true) {
                System.out.print("Individual or company (i/c)? ");

                if (sc.hasNext("(?i)[ic]")) {   //(?i) ignore case   //[ic] 'i' or 'c'
                    //Alternative: if (sc.next().matches("(?i)[ic]")) {
                    typeOfTaxPayer = Character.toLowerCase(sc.next().charAt(0));
                    break;
                }
                else {
                    System.out.println();
                    System.out.println("Invalid input. Only 'i' or 'c' are allowed!");
                    System.out.println();
                    sc.next(); // clear the invalid input
                }
            }
            System.out.print("Name: ");
            String nameOfTaxPayer = sc.next();


            while (true) {
                System.out.print("Anual income (use . to separate decimal): ");
                if (sc.hasNextDouble()) {
                    double anualIncome = sc.nextDouble();

                    if (anualIncome > 0) {
                        if (typeOfTaxPayer == 'i') {
                            while (true) {
                                System.out.print("Health expenditures: ");
                                if (sc.hasNextDouble()) {
                                    double healthExpenditures = sc.nextDouble();
                                    if (healthExpenditures >= 0) {
                                        Individual taxPayer = new Individual(nameOfTaxPayer, anualIncome, healthExpenditures);
                                        taxPayerList.add(taxPayer);
                                        break;
                                    }else{
                                        numbersGreaterThanZero();
                                    }
                                }else {
                                    onlyNumbersAllowed();
                                    sc.next();
                                }
                            }
                        } else if (typeOfTaxPayer == 'c') {
                            while (true) {
                                System.out.print("Number of employees: ");
                                if (sc.hasNextInt()) {
                                    int numberOfEmployees = sc.nextInt();
                                    if(numberOfEmployees >= 0){
                                        Company taxPayer = new Company(nameOfTaxPayer, anualIncome, numberOfEmployees);
                                        taxPayerList.add(taxPayer);
                                        break;
                                    }
                                    else{
                                        numbersGreaterThanZero();
                                    }
                                }else {
                                    onlyNumbersAllowed();
                                    sc.next();
                                }
                            }
                        }
                        break;
                    }
                    else {
                        numbersGreaterThanZero();
                    }
                }else {
                    onlyNumbersAllowed();
                    sc.next();
                }
            }
            System.out.println();
        }

        for(int j=0; j<50; j++){
            System.out.print('-');
            Thread.sleep(50);
        }

        System.out.println();
        String now = sdf.format(new Date());

        System.out.println(now);
        System.out.println();
        System.out.println("TAX PAID");
        for(TaxPayer tp : taxPayerList){
            System.out.println(tp.getNameOfTaxPayer() + ": $ " + String.format("%.2f",tp.anualTaxes()));
            amountTaxes += tp.anualTaxes();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f",amountTaxes));

        System.out.println("--------------------------------------------------");

        sc.close();
    }

    public static void numbersGreaterThanZero(){
        System.out.println();
        System.out.println("!!!!! Invalid input. Only numbers greater than zero are allowed !!!!");
        System.out.println();
    }

    public static void onlyNumbersAllowed(){
        System.out.println();
        System.out.println("!!!!! Invalid input. Only numbers are allowed !!!!");
        System.out.println();
    }

}
