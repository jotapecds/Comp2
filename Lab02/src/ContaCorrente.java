import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente {

    private final long numeroDaConta;

    private final Agencia agencia;

    private float saldoEmReais;

    private Date dataDeCriacao;

    private Pessoa correntista;

    private Pessoa gerenteDaConta;

    private ArrayList<String> historicoDeOperacoes;

    public ContaCorrente(long numeroDaConta, Pessoa correntista, Agencia agencia) {
        this.historicoDeOperacoes = new ArrayList<>();
        this.dataDeCriacao = new Date();  // data corrente
        this.saldoEmReais = 10;  // o banco dá 10 reais de estímulo para a abertura de conta
        this.numeroDaConta = numeroDaConta;
        this.correntista = correntista;
        this.agencia = agencia;
    }

    public float getSaldoEmReais() {  // getter (métodos de acesso para leitura)
        return saldoEmReais;
    }

    public void depositar(float valor) {
        // valida o parâmetro
        if (valor <= 0) {
            return;  // ToDo lançar uma exceção!!!!
        }

        // altera o saldo
        saldoEmReais += valor;

        historicoDeOperacoes.add("Deposito em dinheiro: " + valor +
                "na data " + new Date());
    }

    /**
     * Transfere um valor desta conta para a conta destino informada, se houver saldo suficiente
     * nesta conta.
     *
     * @param valor o valor desejado
     * @param contaDestino a conta de destino
     */
    public void transferir(float valor, ContaCorrente contaDestino) {
        // valida o parâmetro
        if (valor <= 0) {
            return;
        }
        // verifica se o saldo atual permite a operação
        if(this.saldoEmReais < valor) {
            return;
        }

        // altera o saldo das duas contas e registra a operação
        this.saldoEmReais -= valor;
        contaDestino.depositar(valor);
        this.historicoDeOperacoes.add("Transferência no valor de R$" + valor +
                " para a conta de número " + contaDestino.numeroDaConta +
                " na data " + new Date());

        return;
    }

    public void sacar(float valor) {
        // valida o parâmetro
        if (valor <= 0) {
            return;
        }
        // verifica se o saldo atual permite a operação
        if(this.saldoEmReais < valor) {
            return;
        }

        // altera o saldo e registra a operação
        this.saldoEmReais -= valor;
        this.historicoDeOperacoes.add("Saque no valor de: " + valor +
                "na data " + new Date());

        return;
    }
}
