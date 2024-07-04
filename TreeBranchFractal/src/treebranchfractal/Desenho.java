/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treebranchfractal;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author bruno
 */
public class Desenho extends Canvas {

    //Variaveis declaradas aqui para facilitar a alteracao dos valores 
    private static int nVezes;
    private static long tEspera;
    
    

    private static long[] tempsEsperaSeg;

    public Desenho(int nVezes, long tEspera) {
        this.tEspera = tEspera;
        this.nVezes = nVezes;
        tempsEsperaSeg = new long[nVezes];
        for (int i = 0; i < tempsEsperaSeg.length; i++) {
            tempsEsperaSeg[i] = this.tEspera;
            this.tEspera /= 2;
        }
        for (int i = 1; i < 4; i++) {
            tempsEsperaSeg[tempsEsperaSeg.length - i] *= 2;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        criaSegmento(g);
    }

    private void criaSegmento(Graphics g) {
        System.out.println("Calculando ramos...");
        int d = 150;
        int largura = getWidth() - 5;
        int altura = getHeight() - 30;
        double ang = -Math.PI / 2;
        Ramo r = new Ramo(0, largura / 2, altura, largura / 2, altura - d);
//        g.drawLine(largura / 2, altura, largura / 2, altura - d);
        ListaEstatica lRamos = new ListaEstatica(nVezes);
        lRamos.add(r);
        d = 100;
        calculaRamos(g, 1, nVezes, d, ang, r, lRamos);
        System.out.println("ATENCAO: Comecei a desenhar!!!");
        g.setColor(new Color(128, 00, 00));
        desenhaRamos(g, lRamos);
    }

    private void calculaRamos(Graphics g, int n, int nMax, int d, double ang,
              Ramo r, ListaEstatica lRamos) {
        if (n <= nMax) {
            double ang1 = ang - Math.PI / 12f;
            double ang2 = ang + Math.PI / 12f;
            Ramo nRamo1 = new Ramo(n, r.p2[0], r.p2[1],
                      (int) (r.p2[0] + d * Math.cos(ang1)),
                      (int) (r.p2[1] + d * Math.sin(ang1)));
            lRamos.add(nRamo1);
            Ramo nRamo2 = new Ramo(n, r.p2[0], r.p2[1],
                      (int) (r.p2[0] + d * Math.cos(ang2)),
                      (int) (r.p2[1] + d * Math.sin(ang2)));
            lRamos.add(nRamo2);
//            g.drawLine(nRamo1.p1[0], nRamo1.p1[1], nRamo1.p2[0], nRamo1.p2[1]);
//            g.drawLine(nRamo2.p1[0], nRamo2.p1[1], nRamo2.p2[0], nRamo2.p2[1]);
            d *= 0.8;
            calculaRamos(g, n + 1, nMax, d, ang1, nRamo1, lRamos);
            calculaRamos(g, n + 1, nMax, d, ang2, nRamo2, lRamos);
        }
    }

    double multiplicador = 2;

    public void desenhaRamos(Graphics g, ListaEstatica lRamos) {
        //Cor marrom
        g.setColor(new Color(150, 75, 00));
        //Desenha o retangulo da base
        g.fillRect(0, getHeight() - 30, getWidth(), 30);
        //150 75 00
        int v = 100, m = 128;
        double vM = m / nVezes;
        double vV = v / nVezes;
        v = 50;
        for (int i = 0; i < nVezes; i++) {
            g.setColor(new Color(m, v, 0));
            m -= vM;
            v += vV;
            if (i == nVezes) {
                //Verde escuro
                g.setColor(new Color(0, 100, 0));
            } else if (nVezes > 7 && i > nVezes - 5) {
                int resto = i % 3;
                if (resto == 1) {
                    g.setColor(new Color(0, 255, 0));
                } else if (resto == 2) {
                    g.setColor(new Color(50, 205, 50));
                } else {
                    g.setColor(new Color(34, 139, 34));
                }
            }
            Ramo[] nRamos = lRamos.getNivel(i);
            for (int j = 0; j < nRamos.length; j++) {
                try {
                    Thread.sleep(tEspera);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                Ramo r = nRamos[j];
                g.drawLine(r.p1[0], r.p1[1], r.p2[0], r.p2[1]);
            }
            tEspera = tempsEsperaSeg[i];
            //multiplicador += (20 - i)/nVezes;
        }
    }

}
