/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treebranchfractal;

import javax.swing.JFrame;

/**
 *
 * @author bruno
 */
public class TreeBranchFractal extends JFrame {

    //Variaveis declaradas aqui para facilitar a alteracao dos valores 
    private static int nVezes;
    private static long tEspera;

    public TreeBranchFractal(int nVezes, double tEspera) {
        this.tEspera = (long)tEspera;
        this.nVezes = nVezes;
        initGui();
    }

    //Inicializar componentes gráficos
    private void initGui() {
        //Alterando titulo
        this.setTitle("Tree Branch Fractal");
        //Tamanho em pixels altura e largura
        setSize(750, 750);
        //Janela aparecer no meio
        setLocationRelativeTo(null);
        //terminar a aplicacao ao fechar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Desenho desenho = new Desenho(nVezes, tEspera);
        this.add(desenho);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Tornar a janela visivel
        setVisible(true);
        setAlwaysOnTop(true);
    }

}
