/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fases;

import Modelo.*;
import Controler.*;
import java.util.ArrayList;

/**
 * @author Tosi
 */
public class fase1 {
    public fase1(ArrayList<Elemento> eElementos, Tela tTela, Skooter hSkooter){
        
        hSkooter.setPosicao(4, 4);
        tTela.addElemento(hSkooter);
        
        tTela.Backgroundfase ="background_1.png";
        
        Premios(eElementos,tTela);
        Paredes(eElementos,tTela);
        ParedesFuradas(eElementos,tTela);
        Inimigos(eElementos,tTela);
        tTela.addElemento(hSkooter);
    }
    private void Inimigos(ArrayList<Elemento> eElementos, Tela tTela){
        
        Robo Verde = new Robo("robo_verde.png",eElementos);
        Verde.setPosicao(10, 1);
        tTela.addElemento(Verde);     

        Robo Amarelo = new Robo("robo_amarelo.png",eElementos);
        Amarelo.setPosicao(2, 0);
        tTela.addElemento(Amarelo);

        Robo Azul = new Robo("robo_azul.png",eElementos);
        Azul.setPosicao(10, 9);        
        tTela.addElemento(Azul);
        
        Robo Rosa = new Robo("robo_rosa.png",eElementos);
        Rosa.setPosicao(0, 9);        
        tTela.addElemento(Rosa);
    }
    private void Premios(ArrayList<Elemento> eElementos, Tela tTela){
        Prizes prize_1 = new Prizes("cereja.png");
        prize_1.setPosicao(10, 0);
        tTela.addElemento(prize_1); 
        
        Prizes prize_2 = new Prizes("limao.png");
        prize_2.setPosicao(0, 10);
        tTela.addElemento(prize_2); 
        
        Prizes prize_3 = new Prizes("morango.png");
        prize_3.setPosicao(10, 10);
        tTela.addElemento(prize_3); 
        
        Prizes prize_4 = new Prizes("uva.png");
        prize_4.setPosicao(0, 0);
        tTela.addElemento(prize_4); 
    }
    private void Paredes(ArrayList<Elemento> eElementos, Tela tTela){
        int i,a=0,j;
        Parede[] paredes = new Parede[25];
        for(i=1;i<11;i=i+2){
            for(j=1;j<11;j=j+2){
                paredes[a] = new Parede("quadrado_vermelho.png",false);
                paredes[a].setPosicao(i, j);
                tTela.addElemento(paredes[a]);
                a++;
            }
        }
    }
    
    private void inserirParedeFurada(String imagem, int linha, int coluna, Tela tTela) {
    ParedeAtravessavel paredeFurada = new ParedeAtravessavel(imagem);
    paredeFurada.setPosicao(linha, coluna);
    tTela.addElemento(paredeFurada);
}

    
    private void ParedesFuradas(ArrayList<Elemento> eElementos, Tela tTela){
        
        this.inserirParedeFurada("quadrado_verde_liso.png", 0, 1, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 1, 2, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 2, 1, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 3, 0, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 4, 1, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 5, 2, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 0, 5, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 2, 5, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 1, 8, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 1, 10, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 3, 8, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 4, 9, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 6, 5, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 5, 6, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 6, 7, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 7, 8, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 8, 9, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 7, 10, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 9, 8, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 10, 7, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 9, 5, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 8, 3, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 9, 2, tTela);
        this.inserirParedeFurada("quadrado_verde_liso.png", 9, 2, tTela);
    }
}
