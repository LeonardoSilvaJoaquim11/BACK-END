package org.example;

import java.util.Random;

public class Biocombustivel {
    protected float quilogramas;

    public Biocombustivel() {
        this(1000f);
    }

    public Biocombustivel(float quilogramas) {
        this.quilogramas = quilogramas;
    }

    public float processar() {
        Random rand = new Random();
        float n = 1f + rand.nextFloat() * 2f;
        return this.quilogramas * n;
    }

    public float getQuilogramas() {
        return quilogramas;
    }

    public void setQuilogramas(float quilogramas) {
        this.quilogramas = quilogramas;
    }
}
