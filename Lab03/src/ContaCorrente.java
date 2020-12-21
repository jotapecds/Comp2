import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente {

    // o banco já te dá algo como estímulo :-)
    public static final float SALDO_INICIAL_DE_NOVAS_CONTAS = 10.0f;

    private static long contador;

    private final long numeroDaConta;

    private final Agencia agencia;

    private float saldoEmReais;

    private Date dataDeCriacao;

    private Pessoa correntista;

    private Pessoa gerenteDaConta;

    private ArrayList<String> historicoDeOperacoes;

    public ContaCorrente(Pessoa correntista, Agencia agencia) {
        this.historicoDeOperacoes = new ArrayList<>();
        this.dataDeCriacao = new Date();  // data corrente
        this.saldoEmReais = SALDO_INICIAL_DE_NOVAS_CONTAS;
        this.contador++;
        this.numeroDaConta = this.contador;
        this.correntista = correntista;
        this.agencia = agencia;
    }

    public long getNumeroDaConta() {
        return numeroDaConta;
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

        historicoDeOperacoes.add("Deposito em dinheiro: R$" + valor +
                " na data " + new Date());
    }

    public void sacar(float valor) {
        // valida o parâmetro
        if (valor <= 0) {
            return;  // ToDo lançar uma exceção!!!!
        }

        // verifica se há fundos na conta
        if (valor > saldoEmReais) {
            return;  // ToDo lançar uma exceção!!!!
        }

        saldoEmReais -= valor;

        historicoDeOperacoes.add(String.format(
                "Saque em dinheiro: R$%.2f na data %s",
                valor, new Date()));
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
            return;  // ToDo lançar uma exceção!!!!
        }

        // verifica se há fundos na conta
        if (valor > saldoEmReais) {
            return;  // ToDo lançar uma exceção!!!!
        }

        saldoEmReais -= valor;
        contaDestino.saldoEmReais += valor;

        historicoDeOperacoes.add(String.format(
                "Transferência efetuada para a conta %d: R$%.2f na data %s",
                contaDestino.numeroDaConta, valor, new Date()));

        contaDestino.historicoDeOperacoes.add(String.format(
                "Transferência recebida da conta %d: R$%.2f na data %s",
                this.numeroDaConta, valor, new Date()));
    }

    public void imprimirContaCorrente() {
        System.out.println(
                "   Numero da conta: " + this.numeroDaConta +
                "   Saldo em reais: " + this.saldoEmReais +
                "   Contador: " + this.contador
        );
    }

    public String getUltimaOperacao() {
        return this.historicoDeOperacoes.get(this.historicoDeOperacoes.size() -1);
    }
}
