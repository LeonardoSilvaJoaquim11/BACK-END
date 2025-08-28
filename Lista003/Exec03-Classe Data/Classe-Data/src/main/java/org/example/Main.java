package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] meses = {1,2,3,4,5,6,7,8,9,10,11,12};
        Integer[] dias = {1,2,3,4,5,6,7,8,9,10,11,
                12,13,14,15,16,17,18,19,20,
                21,22,23,24,25,26,27,28,29,30,31};
        Integer[] anos = {2025,2024,2023,2022,2021,2020,
                2019,2018,2017,2016,2015};

        Random random = new Random();

        Data[] datas = new Data[3];

        for (int i = 0; i < datas.length; i++) {
            Integer mes = meses[random.nextInt(meses.length)];
            Integer dia = dias[random.nextInt(dias.length)];
            Integer ano = anos[random.nextInt(anos.length)];

            try {
                datas[i] = new Data(dia, mes, ano);
            } catch (IllegalArgumentException e) {
                System.out.println("Data inválida gerada: " + e.getMessage());
                i--;
            }
        }

        System.out.println("=== Datas sorteadas ===");
        for (Data data : datas) {
            data.displayData();
        }
    }
}
