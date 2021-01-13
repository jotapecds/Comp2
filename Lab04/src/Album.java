import java.util.ArrayList;
import java.util.Arrays;

public class Album {

    public static final int PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR = 90; // 90%

    private int tamanhoDoAlbum;
    private int quantFigurinhasPorPacotinho;
    private int quantPacotinhosComprados;
    private ArrayList<Figurinha> figurinhasColadas;
    private ArrayList<FigurinhaRepetida> figurinhasReptidas;

    public Album(int tamanhoDoAlbum, int quantFigurinhasPorPacotinho) {
        this.tamanhoDoAlbum = tamanhoDoAlbum;
        this.quantFigurinhasPorPacotinho = quantFigurinhasPorPacotinho;
        this.quantPacotinhosComprados = 0;
        this.figurinhasColadas = new ArrayList<>();
        this.figurinhasReptidas = new ArrayList<>();
    }

    public void receberNovoPacotinho(Pacotinho pacotinho) {
        this.quantPacotinhosComprados++;
        for (Figurinha fig : pacotinho) {
            int pos = fig.getPosicao();

            if(this.possuiFigurinhaColada(pos)){
                int indexRepetida = this.existeFigurinhaRepetida(pos);

                if(indexRepetida >= 0)
                    this.figurinhasReptidas.get(indexRepetida).adicionarRepetida(); // Incrementar repetida antiga
                else
                    this.figurinhasReptidas.add(new FigurinhaRepetida(pos)); // Adicionar nova repetida
            }
            else {
                this.figurinhasColadas.add(fig); // Colar nova figurinha
            }
        }
    }

    public void autoCompletar() {
        if(getQuantFigurinhasColadas() <= this.tamanhoDoAlbum * 0.9)
            return;

        for(int i = 1; i <= this.tamanhoDoAlbum; i++) {
            for(Figurinha fig : this.figurinhasColadas) {
                if (fig.getPosicao() == i) {
                    break;
                }
                else {
                    Figurinha figurinha = new Figurinha(i);
                    this.figurinhasColadas.add(figurinha);
                }
            }

        }
    }

    public int getTamanho() {
        return this.tamanhoDoAlbum;
    }

    public int getQuantFigurinhasPorPacotinho() {
        return this.quantFigurinhasPorPacotinho;
    }

    public int getQuantFigurinhasColadas() {
        return this.figurinhasColadas.size();
    }

    public int getQuantFigurinhasRepetidas() {
        return this.figurinhasReptidas.size();
    }

    public int getQuantPacotinhosComprados() {
        return this.quantPacotinhosComprados;
    }

    public boolean possuiFigurinhaColada(int posicao) {
        for(Figurinha fig : this.figurinhasColadas) {
            if(fig.getPosicao() == posicao) {
                return true;
            }
        }
        return false;
    }

    public boolean possuiFigurinhaRepetida(int posicao) {
        for(FigurinhaRepetida fig : this.figurinhasReptidas) {
            if(fig.getPosicao() == posicao) {
                return true;
            }
        }
        return false;
    }

    private int existeFigurinhaRepetida(int posicao) {
        for(FigurinhaRepetida fig : this.figurinhasReptidas) {
            if(fig.getPosicao() == posicao){
                return this.figurinhasReptidas.indexOf(fig);
            }
        }
        return -1;
    }

    public int getQuantFigurinhasFaltantes() {
        int result = this.tamanhoDoAlbum - this.figurinhasColadas.size();
        return result;
    }
}
