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

        int n, id, indiceID;
        String nome;
        double salarioHoje, novoSalario, percentualSalario;

        System.out.println("Informe a quantidade de funcionários a atualizar");
        n = sc.nextInt();

        List<Integer> listaId= new ArrayList<>();
        List<String> listaNome= new ArrayList<>();
        List<Double> listaSalario= new ArrayList<>();

        for(int i=0;i<n;i++){
            System.out.println("Informe o ID do funcionário "+i);
            listaId.add(sc.nextInt());
            System.out.println("Informe o Nome do funcionário "+i);
            listaNome.add(sc.next());
            System.out.println("Informe o Salário do funcionário "+i);
            listaSalario.add(sc.nextDouble());
        }

        System.out.println("---------------------------");
        System.out.println(listaSalario);

        Funcionario fc = new Funcionario();

        for (int i = 0; i < n; i++) {
            System.out.println("Deseja aumentar o salário de algum funcionário? s/n");
            char op = sc.next().charAt(0);
            if(op == 's') {
                System.out.println("Entre com o id do funcionário em que deseja aumentar o salário:");
                id = sc.nextInt();
                System.out.println("Informe um percentual de aumento: ");
                percentualSalario = sc.nextDouble();

                indiceID = listaId.indexOf(id); //Indice da lista do id

                salarioHoje = listaSalario.get(indiceID); //valor do salario do indice

                novoSalario = salarioHoje * (1 + (percentualSalario / 100));
                listaSalario.set(indiceID,novoSalario);

            }
            else{
                i=n;
            }

        }

        System.out.println(listaId);
        System.out.println(listaNome);
        System.out.println(listaSalario);

        sc.close();
    }
}