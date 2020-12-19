import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<ContaCorrente> contas = new ArrayList();
    static ArrayList<Pessoa> pessoas = new ArrayList();
    static Agencia agencia = new Agencia();

    static void realizarDeposito() {

    }

    static void realizarSaque() {

    }

    static void realizarTransferencia() {

    }

    static void consultarSaldo() {

    }

    static void cadastrarPessoa() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        long cpf = scanner.nextLong();

        for (int i=0; i<pessoas.size(); i++) {
            if(pessoas.get(i).getCpf() == cpf) {
                System.out.println("Já existe alguem com esse cpf");
            }
        }
        Pessoa p = new Pessoa(nome, cpf);
        p.imprimirPessoa();
        pessoas.add(p);
    }

    static void criarNovaConta() {

    }

    public static void main(String[] args) {
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
                    "   Opção desejada: ");

            opcao = scanner.next().charAt(0);
            System.out.println(opcao);

            switch(opcao) {
                case 'd' : realizarDeposito();
                case 's' : realizarSaque();
                case 't' : realizarTransferencia();
                case 'c' : consultarSaldo();
                case 'p' : cadastrarPessoa();
                case 'n' : criarNovaConta();
                case 'x' : break;
            }
        }

    }
}
