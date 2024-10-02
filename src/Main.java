package src;

import java.util.Scanner;

import arvoreBinaria.ArvoreMorse;

public class Main {
    public static void main(String[] args) {
        ArvoreMorse arvore = new ArvoreMorse();
        Scanner input = new Scanner(System.in);

        System.out.print("\nDigite o código Morse: ");
        String codMorse = input.nextLine();

        System.out.println("Letra decifrada: " + arvore.decifrar(codMorse));

        input.close();
    }
}
