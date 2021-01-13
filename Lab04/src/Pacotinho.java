import java.util.ArrayList;
import java.util.Random;

public class Pacotinho extends ArrayList<Figurinha> {

    private Album album;
        private int quantFigurinhas;

    // ToDo atributo que seja uma estrutura para guardar as figurinhas deste pacotinho

    public Pacotinho(Album album) {
        this.album = album;
        this.quantFigurinhas = this.album.getQuantFigurinhasPorPacotinho();
        adicionarFigurinhasAleatorias();
    }

    // sobrecarga no costrutor, passando aqui as posições desejadas
    public Pacotinho(Album album, int[] posicoes) {
        this.album = album;

        if(this.album.getQuantFigurinhasPorPacotinho() == posicoes.length)
            this.quantFigurinhas = posicoes.length;
        else
            throw new RuntimeException("Pacotinho no tamanho errado!");

        adicionarFigurinhasSelecionadas(posicoes);
    }

    private void adicionarFigurinhasAleatorias() {
        int maxPosicao = this.album.getTamanho();
        Random gerador = new Random();

        for (int i = 1; i <= this.quantFigurinhas; i++) {
            int posicao = gerador.nextInt(maxPosicao);

            Figurinha figurinha = new Figurinha(posicao);
            add(figurinha);
        }
    }

    public void adicionarFigurinhasSelecionadas(int[] posicoes) {
        for (int i = 0; i < posicoes.length; i++) {
            Figurinha figurinha = new Figurinha(posicoes[i]);
            add(figurinha);
        }
    }

    public Album getAlbum() {
        return this.album;
    }

    public int getQuantFigurinhas() {
            return quantFigurinhas;
    }
}
