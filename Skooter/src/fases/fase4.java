
package fases;

import Modelo.*;
import Controler.*;
import java.util.ArrayList;

/**
 *
 * @author Tosi
 */
public class fase4 {
    public fase4(ArrayList<Elemento> eElementos, Tela tTela, Skooter hSkooter){
        
        hSkooter.setPosicao(4, 5);
        tTela.addElemento(hSkooter);
        
        tTela.Backgroundfase ="background_4.png";
        
        Premios(eElementos,tTela);
        Paredes(eElementos,tTela);
        Inimigos(eElementos,tTela);
        tTela.addElemento(hSkooter);
    }
    private void Inimigos(ArrayList<Elemento> eElementos, Tela tTela){
        
        Robo Verde = new Robo("robo_verde.png",eElementos);
        Verde.setPosicao(5, 0);
        tTela.addElemento(Verde);     

        Robo Amarelo = new Robo("robo_amarelo.png",eElementos);
        Amarelo.setPosicao(0, 5);
        tTela.addElemento(Amarelo);

        Robo Azul = new Robo("robo_azul.png",eElementos);
        Azul.setPosicao(5, 10);        
        tTela.addElemento(Azul);
        
        Robo Rosa = new Robo("robo_rosa.png",eElementos);
        Rosa.setPosicao(10, 5);        
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
    
    private void inserirParede(String imagem, int linha, int coluna, ArrayList<Elemento> eElementos, Tela tTela) {
        Parede parede = new Parede(imagem, false);
        parede.setPosicao(linha, coluna);
        tTela.addElemento(parede);
}
    private void Paredes(ArrayList<Elemento> eElementos, Tela tTela){
        int i,a=0,j;
        Parede[] paredes = new Parede[41];
        for(i=1;i<11;i=i+2){
            for(j=1;j<11;j=j+2){
                paredes[a] = new Parede("quadrado_verde_liso.png",true);
                paredes[a].setPosicao(i, j);
                tTela.addElemento(paredes[a]);
                a++;
            }
        }
        for(i=2;i<9;i=i+2){
            for(j=2;j<9;j=j+2){
                paredes[a] = new Parede("quadrado_verde_liso.png",true);
                paredes[a].setPosicao(i, j);
                tTela.addElemento(paredes[a]);
                a++;
            }
        }
        
        this.inserirParede("quadrado_vermelho.png", 10, 1, eElementos, tTela);
        this.inserirParede("quadrado_vermelho_liso.png", 8, 10, eElementos, tTela);
        this.inserirParede("quadrado_vermelho.png", 8,7, eElementos, tTela);
        this.inserirParede("quadrado_vermelho.png", 8, 1, eElementos, tTela);
        this.inserirParede("quadrado_vermelho.png", 7, 0, eElementos, tTela);
        this.inserirParede("quadrado_vermelho.png", 6, 3, eElementos, tTela);
        this.inserirParede("quadrado_vermelho.png", 5, 8, eElementos, tTela);
        this.inserirParede("quadrado_vermelho.png", 5, 2, eElementos, tTela);
        this.inserirParede("quadrado_vermelho.pngo", 3, 10, eElementos, tTela);
        this.inserirParede("quadrado_vermelho.png", 3, 2, eElementos, tTela);
        this.inserirParede("quadrado_vermelho.pngo", 2, 5, eElementos, tTela);
        this.inserirParede("quadrado_vermelho.png", 1, 8, eElementos, tTela);
        this.inserirParede("quadrado_vermelho.png", 1, 0, eElementos, tTela);
        this.inserirParede("quadrado_vermelho.png", 0, 7, eElementos, tTela);
        this.inserirParede("quadrado_vermelho.png", 0, 3, eElementos, tTela);
    }
}