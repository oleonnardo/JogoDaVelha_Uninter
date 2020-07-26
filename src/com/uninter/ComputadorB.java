/*
 * CST ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
 * LEONARDO SILVA
 */
package com.uninter;

import java.util.Random;

/**
 *
 * @author Leonardo
 */
public class ComputadorB extends Computador {
       
    
    @Override
    public void jogar(Tabuleiro tab) {
        Random random = new Random();
        int p = random.nextInt(9);
        
        int posicao = (int) tab.getPosicaoTab().get(p);
       
        if(posicao == 0) {
            // se a posição não estiver marcada, a escolha é registrada
            tab.setPosicaoTab(p, 2);
        } else {
            this.jogar(tab);
        }
        
        super.jogar(tab);
    }
    
}
