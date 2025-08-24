package org.example;

public class Fatura {
    private Double totalFatura;
    //Atributos
    private String numero;
    private String descricao;
    private Integer quantidade;
    private Double precoPorItem;


    //construtor
    Fatura(String numero, String descricao,  Integer quantidade, Double precoPorItem) {
        this.numero = numero;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoPorItem = precoPorItem;
    }

    public String getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPrecoPorItem() {
        return precoPorItem;
    }

    public double getTotalFatura() {

        if (quantidade*precoPorItem <= 0.00) {
            return 0.00;
        }else {
            return quantidade * precoPorItem;
        }
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoPorItem(Double precoPorItem) {
        this.precoPorItem = precoPorItem;
    }

    //Método
    void exibeFatura(){
        System.out.println("Número: " + numero +
                " Descrição: " + descricao +
                " Quantidade: " + quantidade +
                " Preço: R$ " + precoPorItem +
                " Total: R$ " + getTotalFatura()
        );
    }
}