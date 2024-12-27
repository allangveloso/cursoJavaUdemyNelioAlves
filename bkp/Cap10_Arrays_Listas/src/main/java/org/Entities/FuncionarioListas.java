package org.Entities;

public class FuncionarioListas {

    private int id;
    private String nome;
    private Double salario;

    public FuncionarioListas() {
    }

    public FuncionarioListas(Integer id, String nome, Double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public void  aumentarSalario(Double percentual) {
                this.salario *= 1+percentual/100;
    }

    public String toString() {
        return
                "\n"
                        +"================================================="
                        +"\n"
                        +"Lista de funcionários "
                        +"\n"
                        +id
                        +", "
                        +nome
                        +", "
                        + String.format("%.2f", salario)
                        +"\n"
                        +"================================================="
                        +"\n";
    }
}