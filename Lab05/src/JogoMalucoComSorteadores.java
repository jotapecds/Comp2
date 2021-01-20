public class JogoMalucoComSorteadores extends JogoDeDoisJogadores {

    private Sorteador sorteadorJogador1;
    private Sorteador sorteadorJogador2;

    public JogoMalucoComSorteadores(String nomeJogo, String nomeJogador1, String nomeJogador2, int numeroDeRodadas, Sorteador sorteador1, Sorteador sorteador2) {
        super(nomeJogo, nomeJogador1, nomeJogador2, numeroDeRodadas);
        this.sorteadorJogador1 = sorteador1;
        this.sorteadorJogador2 = sorteador2;
    }

    /**
     * Esse método implementa uma rodada da partida do jogo.
     *
     * @return um inteiro indicando o resultado da rodada:
     *         1 -> vitória do jogador 1;
     *         2 -> vitória do jogador 2;
     *         3 -> empate
     */
    @Override
    protected int executarRodadaDoJogo() {
        int numeroJogador1 = sorteadorJogador1.sortear();
        int numeroJogador2 = sorteadorJogador2.sortear();

        if(numeroJogador1 > numeroJogador2)
            return 1;
        else if(numeroJogador1 < numeroJogador2)
            return 2;
        else
            return 0;
    }
}
