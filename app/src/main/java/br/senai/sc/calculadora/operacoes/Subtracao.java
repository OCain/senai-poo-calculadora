package br.senai.sc.calculadora.operacoes;

public class Subtracao implements Operacao {

    private Integer x;
    private Integer y;

    @Override
    public void setX(Integer x) {
        this.x = x;
    }

    @Override
    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public Integer calcular() {
        return x - y;
    }
}
