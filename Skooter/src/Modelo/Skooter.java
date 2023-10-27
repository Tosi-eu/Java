package Modelo;

import java.io.Serializable;

/**
 * @author Junio
 */
public class Skooter extends Elemento implements Serializable{
    public Skooter(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }

    @Override
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
