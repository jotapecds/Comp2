import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<ContaCorrente> contas = new ArrayList();
    static ArrayList<Pessoa> pessoas = new ArrayList();
    static Agencia agencia = new Agencia();

    static void realizarDeposito() {

    }

    static void realizarSaque() throws InterruptedException {
        System.out.println("Digite o numero da conta: ");
        long numeroDaConta = scanner.nextLong();

        System.out.println("Digite o valor do saque");
        float valor = scanner.nextFloat();

        for(int i=0; i<contas.size(); i++) {
            if(contas.get(i).getNumeroDaConta() == numeroDaConta) {
                contas.get(i).sacar(valor);
                System.out.println("Saque de " + valor + " reais realizado com sucesso!\n\n\n");
                new Thread().sleep(2000);
                return;
            }
        }

    }

    // ToDo assim que arrumar o numero da conta voltar pra testar essa função
    static void realizarTransferencia() throws InterruptedException {
        System.out.println("Digite o numero da conta origem");
        long numeroContaOrigem = scanner.nextLong();

        System.out.println("Digite o numero da conta destino");
        long numeroContaDestino = scanner.nextLong();

        System.out.println("Digite o valor da transferencia");
        float valor = scanner.nextFloat();

        for(int i=0; i<contas.size(); i++) {
            if(contas.get(i).getNumeroDaConta() == numeroContaOrigem) {
                for(int j=0; j<contas.size(); j++) {
                    if(contas.get(j).getNumeroDaConta() == numeroContaDestino) {
                        contas.get(i).transferir(valor,contas.get(j));
                        System.out.println("Transferencia realizada com sucesso!\n\n\n");
                        new Thread().sleep(2000);
                        return;
                    }
                }
            }
        }

    }

    static void consultarSaldo() throws InterruptedException {
        System.out.print("Digite o numero da conta: ");
        long numeroDaConta = scanner.nextLong();
        limparBuffer(scanner);

        for(int i=0; i<contas.size(); i++) {
            if(contas.get(i).getNumeroDaConta() == numeroDaConta) {
                System.out.println("Saldo disponivel: " + contas.get(i).getSaldoEmReais());
                new Thread().sleep(3000);
                return;
            }
        }

        System.out.println("Nao foi possivel encontrar uma conta com esse numero");
        new Thread().sleep(3000);
    }

    static void cadastrarPessoa() throws InterruptedException {
        System.out.print("\n\n\nDigite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        long cpf = scanner.nextLong();
        limparBuffer(scanner);

        for (int i=0; i<pessoas.size(); i++) {
            if(pessoas.get(i).getCpf() == cpf) {
                System.out.println("Ja existe alguem com esse cpf\n\n\n");
                new Thread().sleep(2000);
            }
        }

        pessoas.add(new Pessoa(nome, cpf));
        System.out.println("Voce foi cadastrado com sucesso!\n\n\n");
        new Thread().sleep(2000);
    }

    static void criarNovaConta() throws InterruptedException {
        System.out.print("\n\n\nDigite seu CPF: ");
        long cpf = scanner.nextLong();
        limparBuffer(scanner);

        for (int i=0; i<pessoas.size(); i++) {
            if(pessoas.get(i).getCpf() == cpf) {
                contas.add(new ContaCorrente(pessoas.get(i), agencia));
                System.out.println("Sua conta foi criada com sucesso!\n\n\n");
                new Thread().sleep(2000);
                return;
            }
        }

        System.out.print("Nao foi possivel criar a sua conta. Seu CPF nao consta no sistema\n\n\n");
        new Thread().sleep(2000);
    }

    private static void limparBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
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
            }
        }

    }
}
