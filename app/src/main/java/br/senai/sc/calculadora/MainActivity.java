package br.senai.sc.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.senai.sc.calculadora.operacoes.Operacao;

import static br.senai.sc.calculadora.operacoes.OperacoesEnum.getOperacaoBySimbolo;

public class MainActivity extends AppCompatActivity {

    public static final String TEXTO_TOAST_OPERACAO_SEM_NUMERO_INFORMADO = "É preciso informar um número antes";
    private TextView display;
    private List<String> numeros = new ArrayList<String>();
    private String numeroDigitado = "";
    private String operador = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById((R.id.tv_display));
        setTitle("Calculadora");
    }

    public void onClickNumberBtn(View v) {
        String numero = getViewText(v);
        atualizarDisplay(numero);
        atualizarNumeroDigitado(numero);
    }

    public void onClickOperacao(View v) {
        if (!numeroDigitado.isEmpty()) {
            gravaNumero();
            gravaOperacao(v);
            numeroDigitado = "";
        } else {
            Toast.makeText(MainActivity.this, TEXTO_TOAST_OPERACAO_SEM_NUMERO_INFORMADO, Toast.LENGTH_LONG).show();
        }
    }

    public void onClickIgual(View v) {
        if (!numeroDigitado.isEmpty()) {
            gravaNumero();
        }

        if (expressaoValidaParaCalculo()) {
            Integer resultado = realizarOperacao();
            if (resultado == null) {
                Toast.makeText(MainActivity.this, "Divisão por zero não é permitida", Toast.LENGTH_LONG).show();
            }
            display.setText(String.valueOf(resultado));
        } else {
            Toast.makeText(MainActivity.this, "Nenhuma operação foi solicitada", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickLimpar(View v) {
        numeros.clear();
        limparOperacao();
        numeroDigitado = "";
        atualizarDisplay("0");
    }

    private void gravaNumero() {
        numeros.add(numeroDigitado);
    }

    private Integer realizarOperacao() {
        Operacao operacao = getOperacaoBySimbolo(operador);
        operacao.setX(Integer.valueOf(numeros.get(0)));
        operacao.setY(Integer.valueOf(numeros.get(1)));
        return operacao.calcular();
    }

    private void gravaOperacao(View v) {
        operador = getViewText(v);
        atualizarDisplay(operador);
    }

    private void limparOperacao() {
        operador = "";
    }

    private boolean expressaoValidaParaCalculo() {
        return this.numeros.size() >= 2;
    }

    private void atualizarDisplay(String texto) {
        if (numeros.isEmpty() && numeroDigitado.isEmpty()) {
            display.setText("");
        }
        String textoDisplay = display.getText().toString();
        textoDisplay = textoDisplay + texto;
        display.setText(textoDisplay);
    }

    private void atualizarNumeroDigitado(String numero) {
        numeroDigitado += numero;
    }

    private String getViewText(View v) {
        return ((TextView) v).getText().toString();
    }
}