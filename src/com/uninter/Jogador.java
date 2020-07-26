/*
 * CST ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
 * LEONARDO SILVA
 */
package com.uninter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Leonardo
 */
public class Jogador {
    
    private String[] jogadores = {
        "VOCÊ",
        "COMPUTADOR",
    };
    
    
    private int[][] posicoesValidas = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {1, 4, 7},
        {2, 5, 8},
        {3, 6, 9},
        {1, 5, 9},
        {3, 5, 7},
    };
   
    
    public void jogar(Tabuleiro tab) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe uma posição no tabuleiro[1-9]: ");
        String str = scanner.next();
        
        // validar a posição
        int p = tab.validarPosicao(str);
        p--;
       
        // verificar se a posição escolhida está preenchida
        int posicao = (int) tab.getPosicaoTab().get(p);
       
        if(posicao == 0) {
           
            // se a posição não estiver marcada, a escolha é registrada
            tab.setPosicaoTab(p, 1);
           
        } else {
           
            System.out.println("Posição marcada...\n");
            this.jogar(tab);
            
        }
       
    }


    public int testaVencedor(Tabuleiro tab) {
        ArrayList<Integer> marcacoes = tab.getPosicaoTab();
        
        for (int[] posicoesValida : this.posicoesValidas) {
            int contadorJ1 = 0;
            int contadorJ2 = 0;
            
            for(int posicao : posicoesValida) {
                
                if(marcacoes.get(posicao-1) == 1) {
                    contadorJ1++;
                }
                
                if(marcacoes.get(posicao-1) == 2) {
                    contadorJ2++;
                }
            
            }
            
            if(contadorJ1 == 3) {
                System.out.println(this.getJogador(1) + " venceu!");
                return 1;
            }
            
            if(contadorJ2 == 3) {
                System.out.println(this.getJogador(2) + " venceu!");
                return 2;
            }
        }
        
        
        if(tab.hasEmpate()) {
            return 3;
        }
        
        return 0;
    }
       
    
    public String[] getJogadores() {
        return this.jogadores;
    }
    
    public String getJogador(int jogador) {
        return this.jogadores[jogador-1];
    }
    
}
