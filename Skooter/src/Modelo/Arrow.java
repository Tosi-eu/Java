/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import Controler.*;

/**
 * @author Salmaze
 * @author Tosi
 */

public class Arrow extends Elemento implements Serializable {
    int dir;
    ArrayList<Elemento> eElementos;
    private final ControleDeJogo cControle = new ControleDeJogo();
    public Arrow(String sNomeImagePNG, int dire,ArrayList<Elemento> elementos) {
        super(sNomeImagePNG);
        dir = dire;
        this.bTransponivel = true;
        this.seta=true;
        eElementos = elementos;
    }
    public boolean empurrar(){
        Elemento eTemp;
        /*elemento auxiliar*/
        Parede Ver1 = new Parede("quadrado_vermelho.png",false);
        Ver1.setPosicao(10, 1);
        /*Validacao da posicao de todos os elementos com relacao a da seta atual*/
        for(int i = 1; i < eElementos.size(); i++){ /*Olha todos os elementos*/
            eTemp = eElementos.get(i); /*Pega o i-esimo elemento do jogo*/
            if(eTemp!=this)
                if(eTemp.getPosicao().estaNaMesmaPosicao(this.getPosicao()))
                    switch (dir) {
                        //empurra para cima
                        case 0: {
                            Ver1.setPosicao(eTemp.pPosicao.getLinha(), eTemp.pPosicao.getColuna());
                            Ver1.moveUp();
                            if (cControle.ehPosicaoValidaArrows(this.eElementos, Ver1.getPosicao())) {
                                eTemp.moveUp();
                            }
                        }
                        //empurra para direita
                        case 1: {
                            Ver1.setPosicao(eTemp.pPosicao.getLinha(), eTemp.pPosicao.getColuna());
                            Ver1.moveRight();
                            if (cControle.ehPosicaoValidaArrows(this.eElementos, Ver1.getPosicao())) {
                                eTemp.moveRight();
                            }
                        }
                        //empurra para baixo
                        case 2: {
                            Ver1.setPosicao(eTemp.pPosicao.getLinha(), eTemp.pPosicao.getColuna());
                            Ver1.moveDown();
                            if (cControle.ehPosicaoValidaArrows(this.eElementos, Ver1.getPosicao())) {
                                eTemp.moveDown();
                            }
                        }
                        //empurra para esquerda
                        case 3: {
                            Ver1.setPosicao(eTemp.pPosicao.getLinha(), eTemp.pPosicao.getColuna());
                            Ver1.moveLeft();
                            if (cControle.ehPosicaoValidaArrows(this.eElementos, Ver1.getPosicao())) {
                                eTemp.moveLeft();
                            }
                        }
                        default: {
                        }
                    }
                        
        }
        return true;
    }
    @Override
    public void autoDesenho(){
        super.autoDesenho();
        empurrar();
    }   
}