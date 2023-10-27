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
public class Parede extends Elemento implements Serializable {
    public Parede(String sNomeImagePNG,boolean breakbl) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.bQuebravel = breakbl;
        this.bMovel = false;
    }
}