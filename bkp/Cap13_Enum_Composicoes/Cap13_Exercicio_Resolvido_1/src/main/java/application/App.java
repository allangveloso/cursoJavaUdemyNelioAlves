package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class App 
{
    public static void main( String[] args ) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department name: ");
        Department department = new Department(sc.nextLine());
        System.out.println("Enter worker name: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Choose a Level: " + new ArrayList<WorkerLevel>(Arrays.asList(WorkerLevel.values()))+": ");

        WorkerLevel workerLevel = WorkerLevel.valueOf(sc.next());
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, workerLevel, baseSalary, department);


        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            System.out.println("Enter the contract #"+i+" date:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate=sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int duration=sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, duration);
            //associar o contract com o worker
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String date = sc.next();
        int month = Integer.parseInt(date.substring(0, 2));
        int year = Integer.parseInt(date.substring(3));

        System.out.println("Name: "+ worker.getName());
        System.out.println("Department: "+ worker.getDepartment().getName());
        System.out.print("Income for " + date + " : " + worker.income(year, month));
    }
}
