package org.example;

public class Biogerador {
    private float potenciaAtual;
    private float cargaAtual;
    private final float cargaMaxima;

    public Biogerador() {
        this.potenciaAtual = 0f;
        this.cargaAtual = 0f;
        this.cargaMaxima = 5f;
    }

    public float getPotenciaAtual() {
        return potenciaAtual;
    }

    public void setPotenciaAtual(float potenciaAtual) {
        this.potenciaAtual = potenciaAtual;
    }

    public float getCargaAtual() {
        return cargaAtual;
    }

    public void setCargaAtual(float cargaAtual) {
        this.cargaAtual = cargaAtual;
    }

    public float getCargaMaxima() {
        return cargaMaxima;
    }

    public void carregar(Biocombustivel b) throws GeradorCheioException {
        if (this.cargaAtual >= this.cargaMaxima) {
            throw new GeradorCheioException("O biogerador está cheio (carga atual = " + this.cargaAtual + ").");
        }
        float resultadoProcessamento = b.processar();
        float potenciaGerada = resultadoProcessamento * 2.36f;
        this.potenciaAtual += potenciaGerada;
        this.cargaAtual += 1f;
    }

    public void esvaziar() {
        this.potenciaAtual = 0f;
        this.cargaAtual = 0f;
    }
}
