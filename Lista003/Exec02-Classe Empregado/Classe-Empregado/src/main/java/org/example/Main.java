package org.example;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] nomes = {"0001", "0002", "0003", "0004", "0005", "0007"};
        String[] sobrenomes = {"Churros", "Batata", "Almondega", "Massa", "Rejunte", "Pá"};
        Double[] salarioMensais = {1500.00, 2003.77, 2209.55, 2555.00, 3010.00, 3098.66, 4504.49};

        Random random = new Random();

        Empregado[] empregados = new Empregado[2];

        for (int i = 0; i < empregados.length; i++) {
            Integer indiceNome = random.nextInt(nomes.length);
            Integer indiceSobrenome = random.nextInt(sobrenomes.length);
            Integer indiceMensal = random.nextInt(salarioMensais.length);
            String nome = nomes[indiceNome];
            String sobrenome = sobrenomes[indiceSobrenome];
            Double salarioMensal = salarioMensais[indiceMensal];
            empregados[i] = new Empregado(nome, sobrenome, salarioMensal);
        }

        System.out.println("=== Escalação Gerada ===");
        for (Empregado empregado : empregados) {
            empregado.exibeEmpregado();

        }


    }
}
