//Fazer um programa para ler os dados de um produto em estoque (nome, preço e quantidade no estoque).
// Em seguida:
//        • Mostrar os dados do produto (nome, preço, quantidade no estoque, valor total no estoque)
//        • Realizar uma entrada no estoque e mostrar novamente os dados do produto
//        • Realizar uma saída no estoque e mostrar novamente os dados do produto


import java.util.Locale;
import java.util.Scanner;

public class ControleEstoque {
    public static void main(String[] args) {
//        Locale.setDefault(new Locale("pt", "BR") );
//        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        Produto produto = new Produto();

        System.out.println("----------------------------------");
        System.out.println("        Cadastro de produto");
        System.out.println("----------------------------------");
        System.out.println("Informe o nome do produto");
        produto.nome=sc.next();
        System.out.println("Informe a quantidade do produto");
        produto.adicionarProdutos(sc.nextInt());
        System.out.println("Informe o preço do produto");
        produto.preco=sc.nextDouble();
        System.out.println("----------------------------------");
        System.out.printf("Produto:%s%n"+"Quantidade: %d%n"+"Valor unitário: %.2f%n"+"Valor total estoque: R$ %.2f%n",produto.nome, produto.quantidade,produto.preco, produto.valorTotalEstoque(produto.preco, produto.quantidade));
        System.out.println("----------------------------------");

        System.out.println("Deseja remover um produto? s/n");
        char op = sc.next().charAt(0);
        if (op == 's'){
            System.out.println("Informe a quantidade a ser removida:");
            produto.removerProdutos(sc.nextInt());

            System.out.printf("Produto:%s%n"+"Quantidade: %d%n"+"Valor unitário: %.2f%n"+"Valor total estoque: R$ %.2f",produto.nome, produto.quantidade,produto.preco, produto.valorTotalEstoque(produto.preco, produto.quantidade));
        }

        sc.close();
    }
}

