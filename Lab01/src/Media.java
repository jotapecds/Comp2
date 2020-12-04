/*
LAB1.
Objetivo: escrever um primeiro programa em Java, apenas para se familiarizar com o ambiente, usando apenas uma classe Principal com métodos public static.
Intruções: Seu programa deve pedir para o usuário digitar várias linhas, cada uma contendo um long e um float. O long é o DRE do aluno; o float é sua média numa determinada disciplina. Quando o usuário digitar uma média negativa qualquer, ele estará sinalizando que chegou ao fim da inserção das notas. Neste momento, seu programa deverá imprimir no console: (1) a quantidade de notas processadas; (2) a média da turma; (3) o DRE do aluno de maior média (se houver empate, pode ser qualquer um dos alunos de maior média).
Exemplo:
Entrada:
1234 8.5
2222 3.5
3333 4
4567 9.2
0 -1
Saída:
4 notas digitadas
Média da turma: 6.3
DRE com maior média: 4567
*/

import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o DRE e a nota de cada aluno");
        System.out.println("Ao final da inserção digite -1");

        long dre = 0, melhor_aluno = 0;
        float nota = 0.0f, maior_nota = 0.0f,  soma = 0.0f;
        int qtd_notas = 0;

        while(nota >= 0) {
            System.out.printf("\nDRE aluno " + (qtd_notas + 1) + ": ");
            dre = scanner.nextLong();
            System.out.printf("Nota aluno " + (qtd_notas + 1) + ": ");
            nota = scanner.nextFloat();

            if(nota < 0 || dre < 0)
                break;

            if(nota > maior_nota) {
                maior_nota = nota;
                melhor_aluno = dre;
            }

            soma = soma + nota;
            qtd_notas++;
        }
        ;

        System.out.println("\n" + qtd_notas + " notas digitadas");
        System.out.println("Média da turma: " + soma/qtd_notas);
        System.out.println("DRE com maior média: " + melhor_aluno);
    }
}