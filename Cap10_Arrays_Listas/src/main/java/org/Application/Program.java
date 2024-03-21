/*
Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de N funcionários. Não deve haver repetição de id.
Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário. Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários, conforme exemplos.
Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de aumento por porcentagem dada.
(exemplo na próxima página)
 */

package org.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n, id;
        String nome;
        char op;
        double salario;

        System.out.println("Informe a quantidade de funcionários a atualizar");
        n = sc.nextInt();


        System.out.println("Informe o ID do funcionário");
        id = sc.nextInt();
        System.out.println("Informe o Nome do funcionário");
        nome = sc.next();
        System.out.println("Informe o Salário do funcionário");
        salario = sc.nextDouble();
        Funcionario fc = new Funcionario(id,nome,salario);
        System.out.print(fc);

        System.out.println("Deseja aumentar o salário de um funcionário? s/n");
        op=sc.next().charAt(0);
        if(op == 's'){
            System.out.println("Informe um percentual de aumento: ");
            fc.aumentar(sc.nextDouble());
            System.out.println(fc);
        }


        sc.close();
    }
}