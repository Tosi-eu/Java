package Modelo;

import Controler.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Junio
 */
public class Robo extends Elemento implements Serializable{
    private boolean bRight;
    private boolean foiPraCima = false;
    private boolean foiPraBaixo = false;
    private boolean foiPraEsquerda = false;
    private boolean foiPraDireita = false;
    private final ControleDeJogo cControle = new ControleDeJogo();
    ArrayList<Elemento> eElementos;
    public Robo(String sNomeImagePNG,ArrayList<Elemento> eElementinhos) {
        super(sNomeImagePNG);
        eElementos = eElementinhos;
        this.bTransponivel = true;
        this.bMortal = true;
    }
    
    @Override
    public void autoDesenho(){
        Random random = new Random();
        int a = random.nextInt(4);
        switch (a) {
            case 0: {
                if (!foiPraDireita) {
                    this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna() + 1);
                    if (!cControle.ehPosicaoValidaRobos(this.eElementos, this.getPosicao())) {
                        this.voltaAUltimaPosicao();
                    }
                    foiPraDireita = true;
                    foiPraCima = false;
                    foiPraBaixo = false;
                    foiPraEsquerda = true;
                } else {
                    this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna());
                }
            }
            case 1: {
                if (!foiPraEsquerda) {
                    this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna() - 1);
                    if (!cControle.ehPosicaoValidaRobos(this.eElementos, this.getPosicao())) {
                        this.voltaAUltimaPosicao();
                    }
                    foiPraDireita = true;
                    foiPraCima = false;
                    foiPraBaixo = false;
                    foiPraEsquerda = true;
                } else {
                    this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna());
                }
            }
            case 2: {
                if (!foiPraCima) {
                    this.setPosicao(pPosicao.getLinha() - 1, pPosicao.getColuna());
                    if (!cControle.ehPosicaoValidaRobos(this.eElementos, this.getPosicao())) {
                        this.voltaAUltimaPosicao();
                    }
                    foiPraDireita = false;
                    foiPraCima = true;
                    foiPraBaixo = true;
                    foiPraEsquerda = false;
                } else {
                    this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna());
                }
            }
            case 3: {
                if (!foiPraBaixo) {
                    this.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
                    if (!cControle.ehPosicaoValidaRobos(this.eElementos, this.getPosicao())) {
                        this.voltaAUltimaPosicao();
                    }
                    foiPraDireita = false;
                    foiPraCima = true;
                    foiPraBaixo = true;
                    foiPraEsquerda = false;
                } else {
                    this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna());
                }
            }
            default: this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna());
        }
        super.autoDesenho();
        bRight = !bRight;
    }
    @Override
    public void voltaAUltimaPosicao(){
        boolean volta = this.pPosicao.volta();
    }
}