package org.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Program {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Anna");

        //Mostra os itens da lista
        System.out.println(list);


        //Inclui um novo item à lista na posição 2:
        list.add(2, "Marco");
        System.out.println(list);

        //Exibe o tamanho da lista, em itens
        System.out.println(list.size());

        //Exibe a lista em ordem vertical
        for (String x : list) {
            System.out.println(x);
        }
        System.out.println("---------------------");

        //Remove os itens da lista tal que iniciam com a letra M
        list.removeIf(x -> x.charAt(0) == 'M');
        for (String x : list) {
            System.out.println(x);
        }
        System.out.println("---------------------");

        //Lista a posição cujo o valor por inteiro é Bob
        System.out.println("Index of Bob: " + list.indexOf("Bob"));
        //Caso não exista, retorna -1
        System.out.println("Index of Marco: " + list.indexOf("Marco"));
        System.out.println("---------------------");

        //Traz os itens da lista tal que iniciam com a letra A
        //Criação de uma nova lista 'result' do tipo String baseada na lista list
        //converte a lista para um 'stream'
        //filtra tal que um item começado com A
        //converte novamente para o tipo Lista (collect)
        //Imprime cada item da lista result em x
        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
        for (String x : result) {
            System.out.println(x);
        }
        System.out.println("---------------------");

        //Encontrar o primeiro elemento que começa com 'A'; caso não encontre, retorna nulo
        String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
        System.out.println(name);
        // Atribui à variável name itens começados com J; caso não encontre, retorna nulo
        name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
        System.out.println(name);
    }
}