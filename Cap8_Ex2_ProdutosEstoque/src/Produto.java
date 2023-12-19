public class Produto {
    String nome;
    double preco;
    int quantidade;

    public double valorTotalEstoque(double p, int q){
        return p*q;
    }

    public void adicionarProdutos(int quantidade){
        this.quantidade += quantidade;
    }

    public void removerProdutos(int quantidade){
        this.quantidade -= quantidade;
    }
}
