public class Figurinha {

    private int posicao;
    private String URL;

    public Figurinha(int posicao) {
        this.posicao = posicao;
    }

    /**
     * @return A posição que esta figurinha deve ocupar no álbum
     */
    public int getPosicao() {
        return this.posicao;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
