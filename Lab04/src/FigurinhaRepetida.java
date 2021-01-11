import java.util.ArrayList;

public class FigurinhaRepetida {

    private int posicao;
    private int quantidade;

    public FigurinhaRepetida(int posicao) {
        this.posicao = posicao;
        this.quantidade = 1;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void adicionarRepetida() {
        this.quantidade++;
    }
    public void removerRepetida() {
        if(this.quantidade <= 1)
            this.quantidade = 0; // Zero indica que não há figurinhas repetidas
        else
            this.quantidade--;
    }
}
