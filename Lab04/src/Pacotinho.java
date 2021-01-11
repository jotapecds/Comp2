import java.util.ArrayList;

public class Pacotinho extends ArrayList<Figurinha> {

    private Album album;

    // ToDo atributo que seja uma estrutura para guardar as figurinhas deste pacotinho

    public Pacotinho(Album album) {
        this.album = album;
        adicionarFigurinhasAleatorias();

    }

    // sobrecarga no costrutor, passando aqui as posições desejadas
    public Pacotinho(Album album, int[] posicoes) {
        this.album = album;

        // verificar se o tamanho do array está correto;
        // caso não esteja, throw new RuntimeException("Pacotinho no tamanho errado!");

    }

    private void adicionarFigurinhasAleatorias() {
        int maxPosicao = album.getTamanho();
        int quantFigurinhasPorPacotinho = album.getQuantFigurinhasPorPacotinho();

        for (int i = 1; i <= quantFigurinhasPorPacotinho; i++) {
            // ToDo sorteia uma posição entre 1 e o tamanho do álbum
            int posicao = 0;


            // ToDo cria um novo objeto Figurinha informando a posição sorteada

            // ToDo adiciona ao pacotinho

            Figurinha figurinha = new Figurinha(posicao);
            add(figurinha);
        }
    }

    public Album getAlbum() {
        return this.album;
    }
}
