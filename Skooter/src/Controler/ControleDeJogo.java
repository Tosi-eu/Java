package Controler;

import Modelo.Elemento;
import Modelo.Skooter;
import Auxiliar.Posicao;
import java.util.ArrayList;

/**
 * @author junio
 */
public class ControleDeJogo {
    public void desenhaTudo( ArrayList<Elemento> e){
        for (Elemento elemento : e) {
            elemento.autoDesenho();
        }
    }

    public void processaTudo( ArrayList<Elemento> e){
        Skooter hSkooter = (Skooter)e.get(0); /*O heroi (protagonista) eh sempre o primeiro do array*/
        Elemento eTemp;

        /*Processa todos os demais em relacao ao heroi*/
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            /*Verifica se o heroi se sobrepoe ao i-ésimo elemento*/
            if(hSkooter.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())){
                if(eTemp.isbMovable()){

                    int aLinha, aColuna,
                         linha, coluna,
                    operadorLinha, operadorColuna;

                    Elemento eOperador;
                    eOperador = e.get(0);
                    Posicao p = eOperador.getPosicao();
                    aLinha = p.getLinhaAnterior();
                    aColuna = p.getColunaAnterior();
                    linha = p.getLinha();
                    coluna = p.getColuna();
                    operadorLinha = linha - aLinha;
                    operadorColuna = coluna - aColuna;

                    eTemp.setPosicao((linha+operadorLinha), (coluna+operadorColuna));

                    //seta o objeto pra frente
                    //mas se o heroi continua no mesmo bloco
                    if(!eTemp.isbBreakable() && eTemp.getPosicao().estaNaMesmaPosicao(hSkooter.getPosicao())){
                        //volta o heroi para a ultima posicao
                        hSkooter.voltaAUltimaPosicao();
                    }

                    Elemento operadorSecundario;
                    //funcao para testar se o bloco movido sofreu colisao com outro
                    for(int j = 1; j < e.size(); j++){
                        if(j == i){
                            j++;
                        }

                        operadorSecundario = e.get(j);
                        if(eTemp.getPosicao().estaNaMesmaPosicao(operadorSecundario.getPosicao()) && !operadorSecundario.isSeta()){
                            //se ele nao for quebravel ele volta o estado dos afetados
                            if(!eTemp.isbBreakable()){
                                hSkooter.voltaAUltimaPosicao();
                                eTemp.voltaAUltimaPosicao();
                            }else{
                                //se for quebravel remove o objeto
                                e.remove(eTemp);
                            }
                        }   
                    }
                }

                if(eTemp.isbColetavel()){
                    e.remove(eTemp);
                }

                if(eTemp.isbBreakable() && !eTemp.isbMovable()){
                    e.remove(eTemp);
                }
            }
        }
    }
    public boolean ehPosicaoValida(ArrayList<Elemento> e, Posicao p){
        Elemento eTemp;
        /*Validacao da posicao de todos os elementos com relacao a Posicao p*/
        /*Olha todos os elementos*/
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            if(!eTemp.isbTransponivel() && !eTemp.isbMovable() && !eTemp.isbBreakable()){
                if(eTemp.getPosicao().estaNaMesmaPosicao(p)){
                    return false; /*A posicao p é invalida, pois ha um elemento (i-esimo eTemp) intransponivel lá*/
                }
            }
        }
        return true;
    }
    public boolean ehPosicaoValidaRobos(ArrayList<Elemento> e, Posicao p){
        int a = 0;
        Elemento eTemp;
        /*Validacao da posicao de todos os elementos com relacao a Posicao p do robo*/
        for(int i = 1; i < e.size(); i++){ /*Olha todos os elementos*/
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            if(eTemp.getPosicao().estaNaMesmaPosicao(p)){
                a++;
                /*tem de ser considerado que o proprio robo estara na mesma posicao*/
                if(a == 2){
                    return false; /*A posicao p é invalida, pois ha um elemento (i-esimo eTemp) intransponivel lá*/
                }
            }
        }
        return true;
    }
    public boolean ehPosicaoMortal(ArrayList<Elemento> e, Posicao p){
        Elemento eTemp;
        /*Validacao da posicao de todos os elementos com relacao a Posicao p*/
        for(int i = 1; i < e.size(); i++){ /*Olha todos os elementos*/
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            if(eTemp.isbMortal())
                if(eTemp.getPosicao().estaNaMesmaPosicao(p))
                    return true; /*A posicao p é mortal, pois ha um inimigo (i-esimo eTemp) lá*/
        }
        return false;
    }

    public boolean CondicaoDeVitoria(ArrayList<Elemento> e, Posicao p){
        Elemento eTemp;
        int winCondition = 0;
        //Passa por todos os itens do array
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i);
            if(eTemp.isbColetavel()){
                winCondition++;
            }
        }   
        //sem recompensas na fase, tem-se a vitória
        return winCondition == 0;
    }
    public boolean ehPosicaoValidaArrows(ArrayList<Elemento> e, Posicao p){
        Elemento eTemp;
        /*Validacao da posicao de todos os elementos com relacao a Posicao p da seta*/
        for (Elemento elemento : e) { /*Olha todos os elementos*/
            eTemp = elemento; /*Pega o i-esimo elemento do jogo*/
            if (!eTemp.isSeta()) {
                if (eTemp.getPosicao().estaNaMesmaPosicao(p)) {
                    return false; /*A posicao p é invalida, pois ha um elemento (i-esimo eTemp) que nao e uma seta lá*/
                }
            }
        }
        return true;
    }
}
