
package fases;

import Modelo.*;
import Controler.*;
import java.util.ArrayList;

/**
 *
 * @author Tosi
 */
public class fase5 {
    public fase5(ArrayList<Elemento> eElementos, Tela tTela, Skooter hSkooter){
        
        hSkooter.setPosicao(4, 4);
        tTela.addElemento(hSkooter);
        
        tTela.Backgroundfase ="background_1.png";
        
        Premios(eElementos,tTela);
        Paredes(eElementos,tTela);
        Arrows(eElementos,tTela);
        Inimigos(eElementos,tTela);
        tTela.addElemento(hSkooter);
    }
    private void Inimigos(ArrayList<Elemento> eElementos, Tela tTela){
        
        Robo Verde = new Robo("robo_verde.png",eElementos);
        Verde.setPosicao(2, 5);
        tTela.addElemento(Verde);     

        Robo Amarelo = new Robo("robo_amarelo.png",eElementos);
        Amarelo.setPosicao(5, 2);
        tTela.addElemento(Amarelo);

        Robo Azul = new Robo("robo_azul.png",eElementos);
        Azul.setPosicao(5, 8);        
        tTela.addElemento(Azul);
        
        Robo Rosa = new Robo("robo_rosa.png",eElementos);
        Rosa.setPosicao(8, 5);        
        tTela.addElemento(Rosa);
    }
    
    private void Premios(ArrayList<Elemento> eElementos, Tela tTela){
        Prizes prize_1 = new Prizes("cereja.png");
        prize_1.setPosicao(2, 2);
        tTela.addElemento(prize_1); 
        
        Prizes prize_2 = new Prizes("limao.png");
        prize_2.setPosicao(2, 8);
        tTela.addElemento(prize_2); 
        
        Prizes prize_3 = new Prizes("morango.png");
        prize_3.setPosicao(8, 2);
        tTela.addElemento(prize_3); 
        
        Prizes prize_4 = new Prizes("uva.png");
        prize_4.setPosicao(8, 8);
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
    
    private void insereSetas(String imagem,  int dire, int linha, int coluna, ArrayList<Elemento> eElementos, Tela tTela){
        Arrow seta = new Arrow(imagem, dire,eElementos);
        seta.setPosicao(linha, coluna);
        tTela.addElemento(seta); 
    }
    
    
    private void Arrows(ArrayList<Elemento> eElementos, Tela tTela){
        //upper arrows
        this.insereSetas("seta_cima.png", 0, 0, 3, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 1, 0, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 1, 6, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 1, 8, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 3, 4, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 3, 10, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 5, 4, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 7, 0, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 7, 4, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 7, 6, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 7, 10, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 9, 2, eElementos, tTela);
        this.insereSetas("seta_cima.png", 0, 10, 1, eElementos, tTela);
      
        //right arrows
        this.insereSetas("seta_direita.png", 1, 2, 1, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 2, 3, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 2, 7, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 2, 9, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 5, 0, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 5, 10, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 6, 5, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 6, 7, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 7, 2, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 7, 8, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 8, 1, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 8, 3, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 8, 7, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 10, 5, eElementos, tTela);
        this.insereSetas("seta_direita.png", 1, 10, 9, eElementos, tTela);
        
        //down arrows
        this.insereSetas("seta_baixo.png", 2, 0, 5, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 0, 9, eElementos, tTela);  
        this.insereSetas("seta_baixo.png", 2, 1, 2, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 1, 4, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 3, 0, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 3, 2, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 3, 8, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 4, 7, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 5, 6, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 9, 0, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 9, 4, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 9, 6, eElementos, tTela);
        this.insereSetas("seta_baixo.png", 2, 9, 8, eElementos, tTela);
        
        
        //left arrows
        this.insereSetas("seta_esquerda.png", 3, 0, 1, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 0, 7, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 1, 10, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 3, 6, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 4, 1, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 4, 3, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 4, 5, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 4, 9, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 6, 1, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 6, 3, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 6, 9, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 8, 9, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 9, 10, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 10, 3, eElementos, tTela);
        this.insereSetas("seta_esquerda.png", 3, 10, 7, eElementos, tTela);
    }
}