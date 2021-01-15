import java.util.ArrayList;

public abstract class JogoDeDoisJogadores {
    protected String nomeJogo;
    protected String nomeJogador1;
    protected String nomeJogador2;
    protected int numeroDeRodadas;
    protected ArrayList<Integer> historicoResultados;

    public JogoDeDoisJogadores(String nomeJogo, String nomeJogador1, String nomeJogador2, int numeroDeRodadas) {
        this.nomeJogo = nomeJogo;
        this.nomeJogador1 = nomeJogador1;
        this.nomeJogador2 = nomeJogador2;
        this.numeroDeRodadas = numeroDeRodadas;
    }

    public String getNomeJogo() { return this.nomeJogo; }

    public String getNomeJogador1() { return this.nomeJogador1; }

    public String getNomeJogador2() { return this.nomeJogador2; }

    public int getNumeroDeRodadas() { return this.numeroDeRodadas; }

    protected String jogar() {
        int vitoriasJogador1 = 0,
            vitoriasJogador2 = 0,
            empates = 0;

        for(int i = 0; i < this.numeroDeRodadas; i++) {
            int resultado = executarRodadaDoJogo();

            switch (resultado) {
                case 1 :
                    vitoriasJogador1++;
                    break;
                case 2 :
                    vitoriasJogador2++;
                    break;
                case 0 :
                    empates++;
                    break;
                default : throw new RuntimeException("Resultado da rodada invalido");
            }
        }

        if(vitoriasJogador1 > vitoriasJogador2)
            return "O jogador " + this.nomeJogador1 + " venceu o jogo por " + vitoriasJogador1 + " a " + vitoriasJogador2;
        else if(vitoriasJogador1 < vitoriasJogador2)
            return "O jogador " + this.nomeJogador2 + " venceu o jogo por " + vitoriasJogador2 + " a " + vitoriasJogador1;
        else
            return "O jogo terminou em empate após " + this.numeroDeRodadas + " rodadas";

    }

    protected abstract int executarRodadaDoJogo();
}
