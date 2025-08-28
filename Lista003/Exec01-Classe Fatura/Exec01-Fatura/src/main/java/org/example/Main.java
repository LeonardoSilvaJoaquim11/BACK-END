package org.example;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] numeros = {"0001", "0002", "0003", "0004", "0005", "0007"};
        String[] descricoes = {"Churros", "Batata", "Almondega", "Massa", "Rejunte", "Pá"};
        Integer[] quantidades = {10,15,20,25,30,35,40};
        Double[] precoPorItens = {2.45, 3.77, 9.55, 5.00, 10.00, 8.66, 4.49};

        Random random = new Random();

        Fatura[] faturas = new Fatura[2];

        for (int i = 0; i < faturas.length; i++) {
            Integer indiceNumero = random.nextInt(numeros.length);
            Integer indiceDescricao = random.nextInt(descricoes.length);
            Integer indiceQuantidade = random.nextInt(quantidades.length);
            Integer indicePrecoPorItem = random.nextInt(precoPorItens.length);
            String numero = numeros[indiceNumero];
            String descricao = descricoes[indiceDescricao];
            Integer quantidade = quantidades[indiceQuantidade];
            Double precoPorItem = precoPorItens[indicePrecoPorItem];
            faturas[i] = new Fatura(numero, descricao, quantidade, precoPorItem);
        }

        System.out.println("=== Escalação Gerada ===");
        for (Fatura fatura : faturas) {
            fatura.exibeFatura();

        }


    }
}
