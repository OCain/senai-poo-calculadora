package br.senai.sc.calculadora.operacoes;

public enum OperacoesEnum {

    DIVISAO("/", new Divisao()),
    MULTIPLICACAO("*", new Multiplicacao()),
    SOMA("+", new Soma()),
    SUBTRACAO("-", new Subtracao());

    private String simbolo;
    private Operacao operacao;


    private OperacoesEnum(String simbolo, Operacao operacao) {
        this.simbolo = simbolo;
        this.operacao = operacao;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public Operacao getOperacao() {
        return this.operacao;
    }

    public static Operacao getOperacaoBySimbolo(String simbolo) {
        for (OperacoesEnum operacaoEnum : OperacoesEnum.values()) {
            if (operacaoEnum.getSimbolo().equals(simbolo)) {
                return operacaoEnum.getOperacao();
            }
        }
        return null;
    }

    public static boolean existeOperacaoParaSimbolo(String simbolo) {
        for (OperacoesEnum operacoesEnum : OperacoesEnum.values()) {
            if (operacoesEnum.getSimbolo() == simbolo) {
                return true;
            }
        }
        return false;
    }
}
