package org.example;

public class EmpregadoTeste {
    public static void main(String[] args) {
        // Instancia dois empregados
        Empregado emp1 = new Empregado("João", "Silva", 2000.00);
        Empregado emp2 = new Empregado("Maria", "Souza", 3500.00);

        // Mostra salário anual inicial
        System.out.println("=== Salário Anual Inicial ===");
        emp1.exibeEmpregado();
        emp2.exibeEmpregado();

        // Aplica aumento de 10%
        emp1.aplicarAumento(10);
        emp2.aplicarAumento(10);

        // Mostra salário anual após aumento
        System.out.println("\n=== Salário Anual Após Aumento de 10% ===");
        emp1.exibeEmpregado();
        emp2.exibeEmpregado();
    }
}