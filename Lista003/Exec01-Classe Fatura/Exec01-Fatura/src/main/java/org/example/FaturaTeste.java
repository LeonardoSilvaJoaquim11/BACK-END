package org.example;

public class FaturaTeste {
    public static void main(String[] args) {
        Fatura f1 = new Fatura("0001", "Mouse Gamer", 3, 79.90);
        Fatura f2 = new Fatura("0002", "Teclado Mecânico", -2, 199.90); // quantidade negativa → vira 0

        System.out.println("=== Faturas ===");
        f1.exibeFatura();
        f2.exibeFatura();
    }
}