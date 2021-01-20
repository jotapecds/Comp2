public class Principal {
    public static void main(String[] args) {

        DadosDeGamao dadosDeGamao = new DadosDeGamao();
        DadosTriplos dadosTriplos = new DadosTriplos();

        for(int i = 1; i <= 100; i++) {
            JogoMalucoComSorteadores jogo = new JogoMalucoComSorteadores(
                    "Quem é o melhor?",
                    "João",
                    "Pedro",
                    i,  // Quantidade de rodadas
                    dadosDeGamao,
                    dadosTriplos);

            String resultado = jogo.jogar();
            System.out.println(resultado);
        }

    }
}

/*
 1) Qual o melhor sorteador? Você saberia dizer isso antes de rodar o programa?
 R: Os dados triplos possuem o melhor sorteador. Não parei pra pensar muito antes, mas acho que sim.

 2) É verdade que jogos com um número maior de rodadas tornam mais difícil a vitória ir para o jogador mais fraco?
 R: Aparentemente sim.
*/