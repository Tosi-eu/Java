package Controler;

import Modelo.*;
import Auxiliar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import fases.*;
/**
 * @author junio
 */
public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {

    private Skooter hSkooter;
    private ArrayList<Elemento> eElementos;
    private ControleDeJogo cControle = new ControleDeJogo();
    private Graphics g2;
    public String Backgroundfase;
    private int vidas = 5;
    private int fase = 1;
    /**
     * Creates new form
     */
    public Tela() {
        Cenario.setCenario(this); /*Desenhador funciona no modo estatico*/
        initComponents();
 
        //this.addMouseListener(this); /*mouse*/
        this.addKeyListener(this);   /*teclado*/
        
        /*Cria a janela do tamanho do cenario + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
            Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);
        
        /*Cria o Heroi*/
        hSkooter = new Skooter("skoot.png");

        if(lerSave() != -1){
            fase = lerSave();
        }

        /*seletor de fases*/
        switch (fase) {
            case 1: {
                eElementos = new ArrayList<Elemento>(100);
                new fase1(eElementos, this, hSkooter);
                break;
            }
            case 2: {
                escreverSave(2);
                eElementos = new ArrayList<Elemento>(100);
                new fase2(eElementos, this, hSkooter);
                break;
            }
            case 3: {
                escreverSave(3);
                eElementos = new ArrayList<Elemento>(100);
                new fase3(eElementos, this, hSkooter);
                break;
            }
            case 4: {
                escreverSave(4);
                eElementos = new ArrayList<Elemento>(100);
                new fase4(eElementos, this, hSkooter);
                break;
            }
            case 5: {
                escreverSave(5);
                eElementos = new ArrayList<Elemento>(100);
                new fase5(eElementos, this, hSkooter);
                break;
            }
            default: {
                break;
            }
        }
    }
    public void Tela(int faseAtual) {
        fase=faseAtual;

        if(lerSave() != -1){
            fase = lerSave();
        }

        /*seletor de fases*/
        hSkooter = new Skooter("skoot.png");
        switch (faseAtual) {
            case 1: {
                eElementos = new ArrayList<Elemento>(100);
                new fase1(eElementos, this, hSkooter);
                break;
            }
            case 2: {
                escreverSave(2);
                eElementos = new ArrayList<Elemento>(100);
                new fase2(eElementos, this, hSkooter);
                break;
            }
            case 3: {
                escreverSave(3);
                eElementos = new ArrayList<Elemento>(100);
                new fase3(eElementos, this, hSkooter);
                break;
            }
            case 4: {
                escreverSave(4);
                eElementos = new ArrayList<Elemento>(100);
                new fase4(eElementos, this, hSkooter);
                break;
            }
            case 5: {
                escreverSave(5);
                eElementos = new ArrayList<Elemento>(100);
                new fase5(eElementos, this, hSkooter);
                break;
            }
            default: {
                break;
            }
        }
    }

/*--------------------------------------------------*/
    public void addElemento(Elemento umElemento) {
        eElementos.add(umElemento);
    }

    public void removeElemento(Elemento umElemento) {
        eElementos.remove(umElemento);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    /*Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos*/    
    @Override
    public void paint(Graphics grafico) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        /*Desenha cenário*/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    /*Linha para alterar o background*/
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + Backgroundfase);
                    g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        /*Aqui podem ser inseridos novos processamentos de controle*/
        if (!this.eElementos.isEmpty()) {
            this.cControle.desenhaTudo(eElementos);
            this.cControle.processaTudo(eElementos);
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask redesenhar = new TimerTask() {
            @Override
            public void run() {
                repaint(); /*(executa o metodo paint)*/
            }
        };        
        
        /*Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos*/
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.FRAME_INTERVAL);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        /*Movimento do heroi via teclado*/
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hSkooter.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hSkooter.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hSkooter.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hSkooter.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_R && this.fase == 0) {
            this.eElementos.clear();
            this.vidas = 5;
            Tela(1);
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            this.eElementos.clear();
            Tela(fase);
        }
        if (cControle.ehPosicaoMortal(this.eElementos, hSkooter.getPosicao())) {
            vidas--;
            System.out.println("Vidas: "+ vidas);
            if (vidas == 0){
                System.out.println("Game Over");
                System.out.println("Voce perdeu, amigão!");
                this.eElementos.clear();
                this.fase = 0;
            }
            this.eElementos.clear();
            Tela(fase);
        }
        if (!cControle.ehPosicaoValida(this.eElementos, hSkooter.getPosicao())) {
            hSkooter.voltaAUltimaPosicao();
        }
        /* checa se o objetivo foi atingido*/
        if(cControle.CondicaoDeVitoria(this.eElementos, hSkooter.getPosicao())){
            if(fase!=0){
                
                this.eElementos.clear();
                fase++;
                if(fase==5){
                    System.out.println("Voce Ganhou!");
                    System.out.println("Créditos: Guilherme Tosi e Perdo Salmaze");
                    fase = 0;
                }
            }
            Tela(fase);
        }
        this.setTitle("-> Cell: " + (hSkooter.getPosicao().getColuna()) + ", " + (hSkooter.getPosicao().getLinha()));
    }

    @Override
    public void mousePressed(MouseEvent e) {
         //Movimento via mouse
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.hSkooter.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);

        if (!cControle.ehPosicaoValida(this.eElementos, hSkooter.getPosicao())) {
            hSkooter.voltaAUltimaPosicao();
        }         
         
        repaint();
    }

    public static int lerSave() {
        int valor = -1;
        try (BufferedReader reader = new BufferedReader(new FileReader("Save.txt"))) {
            String linha = reader.readLine();
            valor = Integer.parseInt(linha);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Formato inválido do dado no arquivo.");
        }
        return valor;
    }

    public static boolean escreverSave(int novoValor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Save.txt"))) {
            writer.write(Integer.toString(novoValor));
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao alterar o arquivo: " + e.getMessage());
            return false;
        }
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projeto de POO 2023");
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
