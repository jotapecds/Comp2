import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContaCorrenteTest {

    private static final float ERRO_ACEITAVEL_NOS_FLOATS = 0.000001f;

    private Pessoa maria;
    private Pessoa joao;

    private Banco banco;

    private Agencia minhaAgencia;

    private ContaCorrente contaDaMaria;
    private ContaCorrente contaDoJoao;

    @Before
    public void setUp() {
        banco = new Banco();

        // cria algumas pessoas
        maria = new Pessoa("Maria", 12345678);
        joao = new Pessoa("Joao", 23222);

        // cria uma agencia
        minhaAgencia = new Agencia(banco, 1, "Agência Principal");

        ContaCorrente.numeroDeContasCriadas = 0;  // reseta o static da classe

        // cria algumas contas
        contaDaMaria = new ContaCorrente(maria, minhaAgencia);
        contaDoJoao = new ContaCorrente(joao, minhaAgencia);
    }

    @Test
    public void testarNumerosAutomaticosDeContas() {
        assertEquals(1, contaDaMaria.getNumeroDaConta());
        assertEquals(2, contaDoJoao.getNumeroDaConta());
//        ContaCorrente novaConta = new ContaCorrente(maria, minhaAgencia);
//        long numeroDaConta = novaConta.getNumeroDaConta();
//
//        assertEquals(numeroDaConta + 1,
//                (new ContaCorrente(joao, minhaAgencia).getNumeroDaConta()));
//        assertEquals(numeroDaConta + 2,
//                (new ContaCorrente(joao, minhaAgencia).getNumeroDaConta());
    }

    @Test
    public void testarDeposito() throws DepositoDeValorNaoPositivoException {
        checarSaldoInicial(contaDaMaria);

        contaDaMaria.depositar(1000);
        assertFloatEquals(1010f, contaDaMaria.getSaldoEmReais());
   }

    @Test
    public void testarDepositoComValorNegativo() {
        checarSaldoInicial(contaDaMaria);
        try {
            contaDaMaria.depositar(-100);
            fail("Uma DepositoDeValorNaoPositivoException deveria ter sido lançada");
        }
        catch (DepositoDeValorNaoPositivoException e) {
            // Nada mudou, porque o depósito não foi feito
            assertFloatEquals(ContaCorrente.SALDO_INICIAL_DE_NOVAS_CONTAS, contaDaMaria.getSaldoEmReais());
        }
    }

    @Test
    public void testarSaque() throws SaldoInsuficienteException, SaqueDeValorNaoPositivoException {
        checarSaldoInicial(contaDaMaria);
        contaDaMaria.sacar(7);
        assertEquals(3f, contaDaMaria.getSaldoEmReais(), ERRO_ACEITAVEL_NOS_FLOATS);
    }

    @Test
    public void testarSaqueComValorNegativo() {
        checarSaldoInicial(contaDaMaria);
        try {
            contaDaMaria.sacar(-100);
            fail("Uma SaqueDeValorNaoPositivoException deveria ter sido lançada");
        }
        catch (SaqueDeValorNaoPositivoException | SaldoInsuficienteException e) {
            // Nada mudou, porque o saque não foi feito
            assertFloatEquals(ContaCorrente.SALDO_INICIAL_DE_NOVAS_CONTAS, contaDaMaria.getSaldoEmReais());
        }
    }

    @Test
    public void testarSaqueSemFundos() {
        checarSaldoInicial(contaDaMaria);
        try {
            contaDaMaria.sacar(250);
            fail("Uma SaldoInsuficienteException deveria ter sido lançada");
        }
        catch (SaqueDeValorNaoPositivoException | SaldoInsuficienteException e) {
            // Nada mudou, porque o saque não foi feito
            assertFloatEquals(ContaCorrente.SALDO_INICIAL_DE_NOVAS_CONTAS, contaDaMaria.getSaldoEmReais());
        }
    }

    @Test
    public void testarTransferecia() throws TransferenciaDeValorNaoPositivo, SaldoInsuficienteException {
        // sanity check: as contas já começam com saldo 10 (regra de negócio)
        checarSaldoInicial(contaDaMaria);
        checarSaldoInicial(contaDoJoao);

        contaDaMaria.transferir(7, contaDoJoao);

        assertFloatEquals(3f, contaDaMaria.getSaldoEmReais());
        assertFloatEquals(17f, contaDoJoao.getSaldoEmReais());
    }

    @Test
    public void testarTransfereciaSemFundosNaContaDeOrigem() {
        // sanity check: as contas já começam com saldo 10 (regra de negócio)
        checarSaldoInicial(contaDaMaria);
        checarSaldoInicial(contaDoJoao);

        try {
            contaDaMaria.transferir(2000, contaDoJoao);
            fail("Uma SaldoInsuficienteException deveria ter sido lançada");
        }
        catch (TransferenciaDeValorNaoPositivo | SaldoInsuficienteException e) {
            // Nada mudou, porque a transferência não foi feita
            assertFloatEquals(ContaCorrente.SALDO_INICIAL_DE_NOVAS_CONTAS, contaDaMaria.getSaldoEmReais());
            assertFloatEquals(ContaCorrente.SALDO_INICIAL_DE_NOVAS_CONTAS, contaDoJoao.getSaldoEmReais());
        }
    }

    @Test
    public void testarTransfereciaComValorNaoPositivo() {
        // sanity check: as contas já começam com saldo 10 (regra de negócio)
        checarSaldoInicial(contaDaMaria);
        checarSaldoInicial(contaDoJoao);

        try {
            contaDaMaria.transferir(-100, contaDoJoao);
            fail("Uma TransferenciaDeValorNaoPositivo deveria ter sido lançada");
        }
        catch (TransferenciaDeValorNaoPositivo | SaldoInsuficienteException e) {
            // Nada mudou, porque a transferência não foi feita
            assertFloatEquals(ContaCorrente.SALDO_INICIAL_DE_NOVAS_CONTAS, contaDaMaria.getSaldoEmReais());
            assertFloatEquals(ContaCorrente.SALDO_INICIAL_DE_NOVAS_CONTAS, contaDoJoao.getSaldoEmReais());
        }
    }

    private void checarSaldoInicial(ContaCorrente conta) {
        // sanity check: as contas já começam com saldo 10 (regra de negócio)
        assertFloatEquals(
                ContaCorrente.SALDO_INICIAL_DE_NOVAS_CONTAS,
                conta.getSaldoEmReais()
        );
    }

    private static void assertFloatEquals(float expected, float actual) {
        assertEquals(expected, actual, ERRO_ACEITAVEL_NOS_FLOATS);
    }
}