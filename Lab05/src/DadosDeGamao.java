public class DadosDeGamao implements Sorteador {

    /**
     * Esse método implementa o lançamento de dois dados distintos simultaneamente.
     *
     * @return a soma dos valores obtidos pelos dados (ou caso os valores sejam iguais, o dobro de sua soma)
     */
    @Override
    public int sortear() {
        Dado d1 = new Dado();
        int valorDado1 = d1.sortear(),
            valorDado2 = d1.sortear(),
            resultado = valorDado1 == valorDado2 ? 2 * (valorDado1 + valorDado2) : valorDado1 + valorDado2;

        return resultado;
    }
}
