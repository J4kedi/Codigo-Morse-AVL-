package src;

import java.util.Scanner;
import arvoreBinaria.ArvoreMorse;

public class Main {
    public static void main(String[] args) {
        ArvoreMorse arvore = new ArvoreMorse();
        Scanner input = new Scanner(System.in);

        System.out.print("\nDigite o código Morse: ");
        String codMorse = input.nextLine();
        
        System.out.println("Frase decifrada: " + decifrarFrase(codMorse, arvore));

        arvore.mostrarArvore();

        input.close();
    }

    public static String decifrarFrase(String codMorse, ArvoreMorse arvore) {
        String decifrado = "";
        String[] sequenciasMorse = codMorse.split(" ");

        for (String sequencia : sequenciasMorse) {
            if (sequencia.equals("/")) 
                decifrado += " ";
            else 
                decifrado += arvore.decifrar(sequencia);
        }

        return decifrado;
    }
}