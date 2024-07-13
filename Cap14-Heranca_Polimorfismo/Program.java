/*
CAP 15.161
Uma empresa possui funcionários próprios e terceirizados.
Para cada funcionário, deseja-se registrar nome, horas trabalhadas e valor por hora. Funcionários terceirizado
possuem ainda uma despesa adicional. O pagamento dos funcionários corresponde ao valor da hora
multiplicado pelas horas trabalhadas, sendo que os funcionários terceirizados ainda recebem um bônus
correspondente a 110% de sua despesa adicional.
Fazer um programa para ler os dados de N funcionários (N fornecido pelo usuário) e armazená-los em uma lista. Depois
de ler todos os dados, mostrar nome e pagamento de cada funcionário na mesma ordem em que foram digitados.
*/

package org.Application;

import org.Entities.Employee;
import org.Entities.FuncionarioListas;
import org.Entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n;
        String name;
        double valuePerHour;
        int hours;
        double additionalCharge;

        List<Employee> list=new ArrayList<>();

        System.out.print("Informe a quantidade de empregados: ");
        n = sc.nextInt();

        for(int i=1;i<=n;i++) {
            System.out.print("O funcionário é terceirizado? s/n: ");
            char op=sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Informe o nome do empregado #"+i+": ");
            name=sc.nextLine();
            System.out.print("Informe a quantidade de horas trabalhadas: ");
            hours=sc.nextInt();
            System.out.print("Informe o valor por hora: ");
            valuePerHour=sc.nextDouble();
            if(op == 's') {
                System.out.print("Informe o valor adicional: ");
                additionalCharge=sc.nextDouble();
                OutsourcedEmployee outsourcedEmployee=new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                list.add(outsourcedEmployee);
            } else {
                Employee employee=new Employee(name, hours, valuePerHour);
                list.add(employee);
            }
        }

        System.out.println();
        System.out.println("Pagamentos:");
        for (Employee e : list){
            System.out.println(e.getName()+", "+e.getHours()+", "+String.format("%.2f", e.payment()));
        }

        sc.close();
    }
}