import java.util.Random;
import java.util.Scanner;

/*
O sistema “Matricula Aleatória” deve gerar o seu número de matrícula na tela na ordem
da esquerda para direita. Para isso, porém, ele utiliza um gerador de números aleatórios
inteiros que recebe do usuário o valor máximo da geração. A cada geração, o sistema
verifica se o número gerado é o dígito da sequência que precisa ser exibido, respeitando
a ordem. Se for, exibe,senão, rejeita e gera um novo número. O sistema termina quando
a sequência completa da matrícula for gerada.
 */

public class GeradorMatricula {

    private Integer matricula;

    public GeradorMatricula(final Integer matricula){
        this.matricula = matricula;
    }

    public void gerar(){

        System.out.println("Gerador aleatório da matrícula " + matricula);

        final Integer maximumValue = getMaximumValue();
        final Random random = new Random();

        final char[] digitosMatricula = matricula.toString().toCharArray();

        for (char c : digitosMatricula){

            Integer count = 1;
            while (random.nextInt(maximumValue + 1) != Integer.valueOf(String.valueOf(c))){
                count = count + 1;
            }

            System.out.println("Dígito " + c + ": " + "Tentativas: " + count);
        }
    }

    private Integer getMaximumValue(){

        System.out.println("Defina o valor máximo de geração: ");

        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
