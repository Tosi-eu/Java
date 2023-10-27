package Modelo;

import Auxiliar.Consts;
import Auxiliar.Cenario;
import Auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 * @author Junio
 */
public abstract class Elemento implements Serializable {
    protected ImageIcon iImage;
    protected Posicao pPosicao;
    protected boolean bTransponivel; 
    protected boolean bMortal;      
    protected boolean bColetavel;     
    protected boolean bMovel;  
    protected boolean bQuebravel;
    protected boolean seta;
    
    protected Elemento(String sNomeImagePNG) {
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bMortal = false;
        this.bColetavel = false;
        this.bMovel = false;
        this.bQuebravel = false;
        this.seta=false;
        try {
            iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImage.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Posicao getPosicao() {
        return pPosicao;
    }

    public boolean isbTransponivel() {
        return bTransponivel;
    }
    public boolean isbMortal() {
        return bMortal;
    }
    public boolean isbColetavel(){
        return bColetavel;
    }
    public boolean isbMovable(){
        return bMovel;
    }
    public boolean isbBreakable(){
        return bQuebravel;
    }
    public boolean isSeta(){
        return seta;
    }
    public void setbTransponivel(boolean bTransponivel) {
        this.bTransponivel = bTransponivel;
    }

    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }
    public boolean setPosicao(){
        return pPosicao.setPosicao(0, 0);
    }
    
    public boolean moveUp() {
        return this.pPosicao.moveUp();
    }

    public boolean moveDown() {
        return this.pPosicao.moveDown();
    }

    public boolean moveRight() {
        return this.pPosicao.moveRight();
    }

    public boolean moveLeft() {
        return this.pPosicao.moveLeft();
    }
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
   public void autoDesenho(){
        Cenario.desenhar(this.iImage, pPosicao.getColuna(), pPosicao.getLinha());
    }    
}
