/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treebranchfractal;

/**
 *
 * @author bruno
 */
public class Ramo {
    int nivel;
    int[] p1;
    int[] p2;

    public Ramo(int nivel, int x1, int y1, int x2, int y2) {
        this.nivel = nivel;
        this.p1 = new int[2];
        this.p2 = new int [2];
        this.p1[0] = x1;
        this.p1[1] = y1;
        this.p2[0] = x2;
        this.p2[1] = y2;
    }
    
    
}
