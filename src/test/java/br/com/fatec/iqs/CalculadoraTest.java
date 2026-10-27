package br.com.fatec.iqs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculadoraTest {
    private final Calculadora calculadora = new Calculadora();

    @Test
    void deveSomarDoisNumeros() {
        assertEquals(12, calculadora.somar(5, 7));
    }

    @Test
    void deveDividirDoisNumeros() {
        assertEquals(5, calculadora.dividir(10, 2));
    }

    @Test
    void deveRejeitarDivisaoPorZero() {
        IllegalArgumentException erro = assertThrows(
            IllegalArgumentException.class, () -> calculadora.dividir(10, 0));
        assertEquals("Divisão por zero não permitida", erro.getMessage());
    }
}
