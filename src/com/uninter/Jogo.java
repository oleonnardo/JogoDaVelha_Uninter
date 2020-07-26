/*
 * CST ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
 * LEONARDO SILVA
 */

package com.uninter;

import java.util.Scanner;

/**
 *
 * @author Leonardo
 */
public class Jogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tabuleiro tab = new Tabuleiro();
        Jogador jogador = new Jogador();
        Computador comp = new ComputadorA();
	int opcao;
       
        
        do {
            Scanner teclado = new Scanner(System.in);
            System.out.println("|==================================|");
            System.out.println("JOGO DA VELHA");
            System.out.println("Escolha a dificuldade 1, 2 ou 3:");
            opcao = teclado.nextInt();

            switch(opcao) {
                case 1: {
                    comp = new ComputadorA();
                    break;
                }
                case 2: {
                    comp = new ComputadorB();
                    break;
                }
                case 3: {
                    comp = new ComputadorC();
                    break;
                }
                default: {
                    System.out.println("Opção inválida\n");
                    opcao = 0;
                }
                    
            }

        } while (opcao == 0);
        
        System.out.println("\n|==================================|\n");
                    
        //definir comportamento para as outras opções
       	int vez = 1;
        
        while(tab.getSituacao() == 0) {
            
            if(vez == 1) { //Jogador Humano
                
                System.out.println("É A SUA VEZ:");
                jogador.jogar(tab);
                vez = 2;
            }
            else if(vez == 2) {	
                
                System.out.println("VEZ DO COMPUTADOR");
                comp.jogar(tab);
                vez = 1;
            
            }
            
            tab.visualizar();
            tab.setSituacao(jogador.testaVencedor(tab));
            System.out.println("|==================================|\n");
            
        }
        
        if(tab.getSituacao() == 3) {
            System.out.println("EMPATE!");
        }
        
    }
    
}
