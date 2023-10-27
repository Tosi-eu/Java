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
public class ParedeAtravessavel extends Elemento implements Serializable {

    public ParedeAtravessavel(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.bMovel = true;
        this.bQuebravel = true;
    }
    public ParedeAtravessavel(String sNomeImagePNG, boolean vermelha) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.bMovel = true;
        this.bQuebravel = false;
    }
}
