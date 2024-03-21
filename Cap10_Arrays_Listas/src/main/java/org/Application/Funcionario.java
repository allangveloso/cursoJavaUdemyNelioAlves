package org.Application;

public class Funcionario {
    int id;
    String nome;
    Double salario;

    public Funcionario(int id, String nome, Double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public void aumentar(Double percentual) {
        this.salario *= 1+percentual;
    }

    public String toString() {
        return
                "\n"
                        +"================================================="
                        +"\n"
                        +"Dados dos funcionários "
                        +"\n"
                        +"Id:          "
                        +id
                        +"\n"
                        +"Nome:        "
                        +nome
                        +"\n"
                        +"Salario:     "
                        + String.format("%.2f", salario)
                        +"\n"
                        +"================================================="
                        +"\n";
    }
}
