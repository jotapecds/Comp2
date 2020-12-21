import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<ContaCorrente> contas = new ArrayList();
    static ArrayList<Pessoa> pessoas = new ArrayList();
    static Agencia agencia = new Agencia();

    static void realizarDeposito() throws InterruptedException {
        limparTela();
        System.out.print("\tDigite o numero da conta: ");
        long numeroDaConta = scanner.nextLong();

        System.out.print("\tDigite o valor do deposito: ");
        float valor = scanner.nextFloat();

        for(int i=0; i<contas.size(); i++) {
            if(contas.get(i).getNumeroDaConta() == numeroDaConta) {
                contas.get(i).depositar(valor);
                contas.get(i).printUltimaOperacao(5);
                new Thread().sleep(3000);
                limparTela();
                return;
            }
        }
        System.out.println("\t\t> Nao foi possivel encontrar uma conta com esse numero");
        new Thread().sleep(3000);
        limparTela();
    }

    static void realizarSaque() throws InterruptedException {
        limparTela();
        System.out.print("\tDigite o numero da conta: ");
        long numeroDaConta = scanner.nextLong();

        System.out.print("\tDigite o valor do saque: ");
        float valor = scanner.nextFloat();

        for(int i=0; i<contas.size(); i++) {
            if(contas.get(i).getNumeroDaConta() == numeroDaConta) {
                contas.get(i).sacar(valor);
                contas.get(i).printUltimaOperacao(5);
                new Thread().sleep(3000);
                limparTela();
                return;
            }
        }
        System.out.println("\t> Nao foi possivel encontrar uma conta com esse numero");
        new Thread().sleep(3000);
        limparTela();
    }

    static void realizarTransferencia() throws InterruptedException {
        limparTela();
        System.out.print("\tDigite o numero da conta origem: ");
        long numeroContaOrigem = scanner.nextLong();

        System.out.print("\tDigite o numero da conta destino: ");
        long numeroContaDestino = scanner.nextLong();

        System.out.print("\tDigite o valor da transferencia: ");
        float valor = scanner.nextFloat();

        for(int i=0; i<contas.size(); i++) {
            if(contas.get(i).getNumeroDaConta() == numeroContaOrigem) {
                for(int j=0; j<contas.size(); j++) {
                    if(contas.get(j).getNumeroDaConta() == numeroContaDestino) {
                        contas.get(i).transferir(valor,contas.get(j));
                        contas.get(i).printUltimaOperacao(5);
                        new Thread().sleep(3000);
                        limparTela();
                        return;
                    }
                }
            }
        }
        System.out.println("\t> Nao foi possivel encontrar uma conta com esse numero");
        new Thread().sleep(3000);
        limparTela();
    }

    static void consultarSaldo() throws InterruptedException {
        limparTela();
        System.out.print("\tDigite o numero da conta: ");
        long numeroDaConta = scanner.nextLong();

        for(int i=0; i<contas.size(); i++) {
            if(contas.get(i).getNumeroDaConta() == numeroDaConta) {
                System.out.println(String.format("\t\t> Saldo disponivel: R$%.2f", contas.get(i).getSaldoEmReais()));
                new Thread().sleep(3000);
                limparTela();
                return;
            }
        }
        System.out.println("\t\t> Nao foi possivel encontrar uma conta com esse numero");
        new Thread().sleep(3000);
        limparTela();
    }

    static void cadastrarPessoa() throws InterruptedException {
        limparTela();
        System.out.print("\tDigite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("\tDigite seu CPF: ");
        long cpf = scanner.nextLong();

        for (int i=0; i<pessoas.size(); i++) {
            if(pessoas.get(i).getCpf() == cpf) {
                System.out.println("\t\t> Ja existe alguem com esse cpf");
                new Thread().sleep(3000);
                limparTela();
                return;
            }
        }

        pessoas.add(new Pessoa(nome, cpf));
        System.out.println("\t\t> Voce foi cadastrado com sucesso!");
        new Thread().sleep(2000);
        limparTela();
    }

    static void criarNovaConta() throws InterruptedException {
        limparTela();
        System.out.print("\tDigite seu CPF: ");
        long cpf = scanner.nextLong();

        for (int i=0; i<pessoas.size(); i++) {
            if(pessoas.get(i).getCpf() == cpf) {
                contas.add(new ContaCorrente(pessoas.get(i), agencia));
                System.out.println("\t\t> Sua conta foi criada com sucesso!");
                System.out.println("\t\t> Numero da conta: " + contas.get(i).getNumeroDaConta());
                new Thread().sleep(3000);
                limparTela();
                return;
            }
        }
        System.out.print("\t\t> Nao foi possivel criar a sua conta. Seu CPF nao consta no sistema");
        new Thread().sleep(3000);
        limparTela();
    }

    private static void limparBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    private static void limparTela() {
        for (int i = 0; i < 100; ++i)
            System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        char opcao = 'a';

        while(opcao != 'x'){
            System.out.print(
                    "   (D)epositar\n" +
                    "   (S)acar\n" +
                    "   (T)ransferir\n" +
                    "   (C)onsultar saldo\n" +
                    "   Cadastrar (P)essoa como correntista\n" +
                    "   Criar (N)ova conta\n" +
                    "   (X) para sair\n\n" +
                    "   Opcao desejada: "
            );

            opcao = scanner.next().charAt(0);
            limparBuffer(scanner);

            switch(opcao) {
                case 'd' : realizarDeposito(); break;
                case 's' : realizarSaque(); break;
                case 't' : realizarTransferencia(); break;
                case 'c' : consultarSaldo(); break;
                case 'p' : cadastrarPessoa(); break;
                case 'n' : criarNovaConta(); break;
                case 'x' : break;
                default  :
                    System.out.println("\t> Opcao invalida");
                    new Thread().sleep(1000);
                    limparTela();
            }
        }

    }
}
