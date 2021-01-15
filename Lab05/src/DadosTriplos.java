public class DadosTriplos extends Dado implements Sorteador {

    public int jogarDados() {
        int resultado = 0;

        for(int i = 0; i < 3; i++){
            resultado += sortear();
        }

        return resultado;
    }
}
