package org.example;

public class DataTeste {
    public static void main(String[] args) {
        Data d1 = new Data(15, 3, 2024);
        Data d2 = new Data(29, 2, 2024);
        Data d3 = new Data(31, 12, 2025);

        System.out.println("=== Datas Válidas ===");
        d1.displayData();
        d2.displayData();
        d3.displayData();

        System.out.println("=== Testando Datas Inválidas ===");
        try {
            Data d4 = new Data(31, 2, 2023);
            d4.displayData();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Data d5 = new Data(10, 13, 2025);
            d5.displayData();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
