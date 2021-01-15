import java.util.Random;

public class Dado implements Sorteador {

    /**
     * Sortear um número de 1 a 6
     *
     * @return int
     */
    public int sortear() {
        return new Random().nextInt(6) + 1;
    };
}
