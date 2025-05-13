package org.example;
import org.example.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("Enter the name of the department: ");
        String departmentName = scanner.nextLine();

        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String workerName = scanner.nextLine();

        System.out.println("Level: ");
        String workerLevel = scanner.nextLine();

        System.out.println("Base Salary: ");
        double baseSalary = scanner.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary,new Department(departmentName));

        System.out.println("How many contracts to this worker? ");
        int n = scanner.nextInt();

        for(int i = 1; i <=n; i++){
            System.out.println("Enter contract #" + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contracteDate = sdf.parse(scanner.next());
            System.out.println("Value per hour: ");
            double valuePerHour = scanner.nextDouble();
            System.out.print("Duration (hours):");
            int duration = scanner.nextInt();
            HourContract contract = new HourContract(contracteDate,valuePerHour,duration);
            worker.addContract(contract);
        }

        System.out.println("Enter month and year to calculate income(MM/yyyy) : ");
        String monthYear = scanner.next();
        int month = Integer.parseInt(monthYear.substring(0,2));
        int year = Integer.parseInt(monthYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthYear + ": " + String.format("%.2f",worker.income(year,month)));
    }
}