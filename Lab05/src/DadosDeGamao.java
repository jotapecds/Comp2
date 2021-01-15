import java.util.Random;

public class DadosDeGamao extends Dado implements Sorteador {

    /**
     * Joga dois dados e retorna a soma entre eles.
     * Caso os numeros sorteados sejam iguais, o resultado será o dobro da soma
     *
     * @return int
     */
    public int jogarDados() {
        int valorDado1 = sortear(),
            valorDado2 = sortear(),
            resultado = valorDado1 == valorDado2 ? 2 * (valorDado1 + valorDado2) : valorDado1 + valorDado2;

        return resultado;
    }
}
