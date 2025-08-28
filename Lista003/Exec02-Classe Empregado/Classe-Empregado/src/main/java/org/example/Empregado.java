package org.example;

public class Empregado {
    //Atributos
    private String nome;
    private String sobrenome;
    private Double salarioMensal;


    //construtor
    Empregado(String nome, String sobrenome,  Double salarioMensal) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.salarioMensal = salarioMensal;
    }

    public Double getSalarioMensal() {
        return salarioMensal;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public Double getSalarioAnual() {
        return salarioMensal*13;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setSalarioMensal(Double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    public void aplicarAumento(double percentual) {
        this.salarioMensal += this.salarioMensal*percentual/100.0;
    }

    //Método
    void exibeEmpregado(){
        System.out.println("Nome: " + nome +
                " Sobrenome: " + sobrenome +
                " Salário Mensal: " + salarioMensal +
                " Salário Anual:" + getSalarioAnual()
        );
    }
}