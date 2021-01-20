public class DadosTriplos implements Sorteador {

    /**
     * Esse método implementa o lançamento de três dados distintos simultaneamente.
     *
     * @return a soma dos valores obtidos pelos dados
     */
    @Override
    public int sortear() {
        Dado d1 = new Dado();
        int resultado = 0;

        for(int i = 0; i < 3; i++){
            resultado += d1.sortear();
        }

        return resultado;
    }
}
