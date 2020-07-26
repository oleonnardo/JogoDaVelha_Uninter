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
public class Tabuleiro {
   
    // declaração das variáveis
    private char[][] tab = { 
        { ' ', '|', ' ', '|', ' ' },
        { '-', '+', '-', '+', '-' }, 
        { ' ', '|', ' ', '|', ' ' },
        { '-', '+', '-', '+', '-' }, 
        { ' ', '|', ' ', '|', ' ' } 
    };
    
    private int situacao = 0;
    private ArrayList<Integer> posicaoTab;
   
    public Tabuleiro() {
        this.posicaoTab = new ArrayList<>();
        
        // inicialização dos arrays
        for (int i = 0; i < 9; i++) {
            this.posicaoTab.add(0);
        }
        
    }
    

    /**
     * Responsável pelo preenchimento do tabuleiro
     * @param value
     * @param linha
     * @param coluna 
     */
    public void setTab(char value, int linha, int coluna) {
        this.tab[linha][coluna] = value;
    }   
    
    
    /**
     * Reponsável por "desenhar" o tabuleiro
     */
    public void visualizar() {
        for (char[] row : this.tab) {
            
            for (char column : row) {
                System.out.print(column);
            }
            
            System.out.println();
        }
        
        System.out.println();
    }   

  
    /**
     * Responsável por validar a posição no tabuleiro
     * @param str
     * @return 
     */
    public int validarPosicao(String str) {
        
        while (!str.matches("[1-9]")) {
            System.out.println("Posição inválida...\n");
            Scanner scan = new Scanner(System.in);
            System.out.print("Informe uma posição no tabuleiro[1-9]: ");
            str = scan.next();
            
            return this.validarPosicao(str);
	}
        
        int p = Integer.parseInt(str);
	return p;
    }
    
    
    public void setSituacao(int jogador) {
        this.situacao = jogador;
    }
    
    
    /**
     * @return 
     */
    public int getSituacao() {
        return this.situacao;
    }
    
    
    /**
     * @return 
     */
    public ArrayList<Integer> getPosicaoTab() {
        return posicaoTab;
    }

  
    /**
     * @param posicao
     * @param item 
     */
    public void setPosicaoTab(int posicao, int item) {
        this.posicaoTab.set(posicao, item);
        this.atualizarTabuleiro(posicao, item);
    }
    
    private void atualizarTabuleiro(int posicao, int item) {
        char marcador = 'O'; 
        
        if(item == 1) {
            marcador = 'X';
        }
        
        switch(posicao) {
            case 0: this.setTab(marcador, 0, 0); break;
            case 1: this.setTab(marcador, 0, 2); break;
            case 2: this.setTab(marcador, 0, 4); break;
            case 3: this.setTab(marcador, 2, 0); break;
            case 4: this.setTab(marcador, 2, 2); break;
            case 5: this.setTab(marcador, 2, 4); break;
            case 6: this.setTab(marcador, 4, 0); break;
            case 7: this.setTab(marcador, 4, 2); break;
            case 8: this.setTab(marcador, 4, 4); break;
        }
    }

    public boolean hasEmpate() {
        int contador = 0;
        
        contador = this.getPosicaoTab()
                .stream()
                .filter((item) -> (item!=0))
                .map((_item) -> 1)
                .reduce(contador, Integer::sum);
        
        return (contador==9);
    }

    
}
