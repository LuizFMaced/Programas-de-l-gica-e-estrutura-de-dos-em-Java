/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fila;

import java.util.Scanner;

/**
 *
 * @author luiz
 */
public class Teste {

    public static void main(String[] args) {
        Fila<String> fila = null;
        int tmpCap = 0;
        int opcao = 0;
        do {
            System.out.println("____FILA Carro________");
            System.out.println("|1-Inicializar        |");
            System.out.println("|2-Adicionar          |");
            System.out.println("|3-Remover            |");
            System.out.println("|4-Exibir             |");
            System.out.println("|5-Quem é o Primeiro ?|");
            System.out.println("|6-Sair               |");
            System.out.println("|Entre com a Opção    |");
            System.out.println("|_____________________|");
            Scanner sc = new Scanner(System.in);
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    tmpCap = Integer.parseInt(perguntar(opcao));
                    fila = new Fila<>(tmpCap);
                    break;
                case 2:
                    if (fila.retornarOTamanho() < tmpCap) {
                        fila.enfileirar(perguntar(opcao));
                    } else {
                        System.out.println("Fila esta cheia!");
                    }
                    break;
                case 3:
                    if (!fila.estaVazia())//se estiver cheia
                    {
                        System.out.println(fila.desenfileirar() + ", saiu da fila.");
                    } else {
                        System.out.println("Fila esta vazia!");
                    }
                    break;
                case 4:
                    System.out.println(fila.toString());
                    break;
                case 5:
                    System.out.println(fila.espiar());
                    break;
                default:

                    break;
            }
        } while (opcao < 6);
        System.out.println("Saindo");
    }

    public static String perguntar(int tmpOpcao) {
        String elemento = "";
        if (tmpOpcao == 1) {
            System.out.println("Entre com a capacidade da fila: ");
            Scanner sc = new Scanner(System.in);
            elemento = sc.nextLine();
            return elemento;
        } else if (tmpOpcao == 2) {
            System.out.println("Digite o nome do veículo: ");
            Scanner sc = new Scanner(System.in);
            elemento = sc.nextLine();
            return elemento;
        }
        return null;
    }

}
