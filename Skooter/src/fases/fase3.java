package fases;

import Modelo.*;
import Controler.*;
import java.util.ArrayList;

/**
 *
 * @author Tosi
 */
public class fase3 {
    public fase3(ArrayList<Elemento> eElementos, Tela tTela, Skooter hSkooter){
        
        hSkooter.setPosicao(5, 5);
        tTela.addElemento(hSkooter);
        
        tTela.Backgroundfase ="background_3.png";
        
        Premios(eElementos,tTela);
        ParedesAtravessaveis(eElementos,tTela);
        Inimigos(eElementos,tTela);
        tTela.addElemento(hSkooter);
    }
    private void Inimigos(ArrayList<Elemento> eElementos, Tela tTela){
        
        Robo Verde = new Robo("robo_verde.png",eElementos);
        Verde.setPosicao(10, 5);
        tTela.addElemento(Verde);     

        Robo Amarelo = new Robo("robo_amarelo.png",eElementos);
        Amarelo.setPosicao(0, 5);
        tTela.addElemento(Amarelo);

        Robo Azul = new Robo("robo_azul.png",eElementos);
        Azul.setPosicao(8, 5);        
        tTela.addElemento(Azul);
        
        Robo Rosa = new Robo("robo_rosa.png",eElementos);
        Rosa.setPosicao(2, 5);        
        tTela.addElemento(Rosa);
    }
    
    private void Premios(ArrayList<Elemento> eElementos, Tela tTela){
        Prizes prize_1 = new Prizes("cereja.png");
        prize_1.setPosicao(5, 2);
        tTela.addElemento(prize_1); 
        
        Prizes prize_2 = new Prizes("uva.png");
        prize_2.setPosicao(5, 8);
        tTela.addElemento(prize_2); 
        
        Prizes prize_3 = new Prizes("limao.png");
        prize_3.setPosicao(5, 10);
        tTela.addElemento(prize_3); 
        
        Prizes prize_4 = new Prizes("morango.png");
        prize_4.setPosicao(5, 0);
        tTela.addElemento(prize_4); 
    }
    
    private void ParedesAtravessaveis(ArrayList<Elemento> eElementos, Tela tTela){
        int i,a=0;
        ParedeAtravessavel[] PF = new ParedeAtravessavel[48];
        
        for(i=1;i<10;i++){
            PF[a] = new ParedeAtravessavel("quadrado_vermelho_liso.png", true);
            PF[a].setPosicao(i, 1);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=2;i<10;i++){
            PF[a] = new ParedeAtravessavel("quadrado_vermelho_liso.png", true);
            PF[a].setPosicao(1, i);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=2;i<10;i++){
            PF[a] = new ParedeAtravessavel("quadrado_vermelho_liso.png", true);
            PF[a].setPosicao(9, i);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=2;i<9;i++){
            PF[a] = new ParedeAtravessavel("quadrado_vermelho_liso.png", true);
            PF[a].setPosicao(i, 9);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=3;i<8;i++){
            PF[a] = new ParedeAtravessavel("quadrado_vermelho_liso.png", true);
            PF[a].setPosicao(3, i);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=3;i<8;i++){
            PF[a] = new ParedeAtravessavel("quadrado_vermelho_liso.png", true);
            PF[a].setPosicao(7, i);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=4;i<7;i++){
            PF[a] = new ParedeAtravessavel("quadrado_vermelho_liso.png", true);
            PF[a].setPosicao(i, 3);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=4;i<7;i++){
            PF[a] = new ParedeAtravessavel("quadrado_vermelho_liso.png", true);
            PF[a].setPosicao(i, 7);
            tTela.addElemento(PF[a]);
            a++;
        }
    }
}
