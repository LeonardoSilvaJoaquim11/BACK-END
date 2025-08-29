package org.example;

public class PortoGrande extends BasePorto {
    public PortoGrande(String nome) {
        super(nome);
    }

    @Override
    public void atracarBarco(Barco barco) {
        if (barco.getTamanho() > 10) {
            super.atracarBarco(barco);
        }
    }
}
