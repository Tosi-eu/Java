/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;

/**
 * @author Salmaze
 * @author Tosi
 */

public class Prizes extends Elemento implements Serializable {

    @SuppressWarnings("empty-statement")
    public Prizes(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = true;
        this.bColetavel = true;
    }
    
}

