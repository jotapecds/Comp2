import java.util.Random;

public class Dado implements Sorteador {

    /**
     * Esse método implementa o lançamento de um dado comum de seis lados
     *
     * @return um número de 1 a 6
     */
    @Override
    public int sortear() {
        return new Random().nextInt(6) + 1;
    };
}
