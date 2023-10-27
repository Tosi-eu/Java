
package fases;

import Modelo.*;
import Controler.*;
import java.util.ArrayList;

/**
 *
 * @author Tosi
 */
public class fase2 {
    public fase2(ArrayList<Elemento> eElementos, Tela tTela, Skooter hSkooter){
        
        hSkooter.setPosicao(5, 5);
        tTela.addElemento(hSkooter);
        tTela.Backgroundfase ="background_2.png";
        
        Arrows(eElementos,tTela);
        Premios(eElementos,tTela);
        Paredes(eElementos,tTela);
        Inimigos(eElementos,tTela);
        hSkooter.setPosicao(5, 5);
        tTela.addElemento(hSkooter);
    }
    private void Inimigos(ArrayList<Elemento> eElementos, Tela tTela){
        
        Robo Verde = new Robo("robo_verde.png",eElementos);
        Verde.setPosicao(1, 9);
        tTela.addElemento(Verde);     

        Robo Amarelo = new Robo("robo_amarelo.png",eElementos);
        Amarelo.setPosicao(1, 1);
        tTela.addElemento(Amarelo);

        Robo Azul = new Robo("robo_azul.png",eElementos);
        Azul.setPosicao(9, 9);        
        tTela.addElemento(Azul);
        
        Robo Rosa = new Robo("robo_rosa.png",eElementos);
        Rosa.setPosicao(9, 1);        
        tTela.addElemento(Rosa);
    }
    private void Premios(ArrayList<Elemento> eElementos, Tela tTela){
        Prizes prize_1 = new Prizes("cereja.png");
        prize_1.setPosicao(5, 9);
        tTela.addElemento(prize_1); 
        
        Prizes prize_2 = new Prizes("uva.png");
        prize_2.setPosicao(5, 1);
        tTela.addElemento(prize_2); 
        
        Prizes prize_3 = new Prizes("morango.png");
        prize_3.setPosicao(9, 5);
        tTela.addElemento(prize_3); 
        
        Prizes prize_4 = new Prizes("limao.png");
        prize_4.setPosicao(1, 5);
        tTela.addElemento(prize_4); 
    }
    private void Paredes(ArrayList<Elemento> eElementos, Tela tTela){
        int i,a=0;
        Parede[] paredes = new Parede[16];
        for(i=1;i<11;i=i+2){
            paredes[a] = new Parede("quadrado_vermelho.png",false);
            paredes[a].setPosicao(i, 3);
            tTela.addElemento(paredes[a]);
            a++;
            
            paredes[a] = new Parede("quadrado_vermelho.png",false);
            paredes[a].setPosicao(i, 7);
            tTela.addElemento(paredes[a]);
            a++;
        }
        for(i=1;i<11;i=i+4){
            paredes[a] = new Parede("quadrado_vermelho.png",false);
            paredes[a].setPosicao(3, i);
            tTela.addElemento(paredes[a]);
            a++;
            
            paredes[a] = new Parede("quadrado_vermelho.png",false);
            paredes[a].setPosicao(7, i);
            tTela.addElemento(paredes[a]);
            a++;
        }
    }
    
    private void insereSetas(String imagem,  int dire, int linha, int coluna, ArrayList<Elemento> eElementos, Tela tTela){
        Arrow seta = new Arrow(imagem, dire,eElementos);
        seta.setPosicao(linha, coluna);
        tTela.addElemento(seta); 
    }
    
    
    private void Arrows(ArrayList<Elemento> eElementos, Tela tTela){
        //upper arrows
        this.insereSetas("seta_cima.png", 0, 7, 10, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 7, 8, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 7, 6, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 7, 0, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 6, 0, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 5, 0, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 4, 8, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 4, 0, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 3, 8, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 3, 6, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 3, 0, eElementos, tTela);
        
        
        //right arrows
        this.insereSetas("seta_direita.png", 1, 10, 7, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 8, 7, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 8, 3, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 6, 3, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 4, 7, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 4, 3, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 2, 3, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 0, 7, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 0, 3, eElementos, tTela);
        
        //down arrows
        this.insereSetas("seta_baixo.png", 2, 7, 4, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 7, 2, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 3, 10, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 3, 4, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 3, 2, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 2, 4, eElementos, tTela);
        
        
        //left arrows
        this.insereSetas("seta_esquerda.png", 3, 10, 3, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 6, 7, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 4, 9, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 4, 10, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 2, 7, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 2, 6, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 2, 5, eElementos, tTela);
    }
}
