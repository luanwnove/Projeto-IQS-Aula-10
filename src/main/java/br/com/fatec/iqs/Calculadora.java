package br.com.fatec.iqs;

public class Calculadora {
    public int somar(int primeiroNumero, int segundoNumero) {
        return primeiroNumero + segundoNumero;
    }

    public int dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisão por zero não permitida");
        }
        return dividendo / divisor;
    }
}
