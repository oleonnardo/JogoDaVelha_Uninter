/*
 * CST ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
 * LEONARDO SILVA
 */
package com.uninter;

/**
 *
 * @author Leonardo
 */
public class ComputadorA extends Computador {
           
    @Override
    public void jogar(Tabuleiro tab) {
        
        for(int i = 0; i < tab.getPosicaoTab().size(); i++) {
            if(tab.getPosicaoTab().get(i) == 0) {
                tab.setPosicaoTab(i, 2); 
                break;
            }
        }

        super.jogar(tab);
    }
    
}
