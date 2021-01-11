import java.util.ArrayList;

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
        // verifica se o álbum já está suficientemente cheio

        // ToDo IMPLEMENT ME!!
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
        // ToDo IMPLEMENT ME!!!
        return false;
    }

    public int getQuantFigurinhasFaltantes() {
        // ToDo IMPLEMENT ME!!!
        return 0;
    }

    private int existeFigurinhaRepetida(int posicao) {
        for(FigurinhaRepetida fig : this.figurinhasReptidas) {
            if(fig.getPosicao() == posicao){
                return this.figurinhasReptidas.indexOf(fig);
            }
        }
        return -1;
    }
}
