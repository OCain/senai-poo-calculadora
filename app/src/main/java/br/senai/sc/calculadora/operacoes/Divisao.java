package br.senai.sc.calculadora.operacoes;

public class Divisao implements Operacao {

    private Integer x;
    private Integer y;

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public Integer calcular() {
        if (y == 0) {
            return null;
        }
        return x / y;
    }
}
