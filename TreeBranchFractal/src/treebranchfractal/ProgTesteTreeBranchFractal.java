/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treebranchfractal;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class ProgTesteTreeBranchFractal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Deseja inserir os dados? (1 = sim): ");
        int opcao = 12;// sc.nextInt();
        int n;
        double t;
        if (opcao == 1) {
            System.out.print("Insira o nivel desejado: ");
            n = sc.nextInt();
            System.out.print("Insira o tempo entre um nivel e outro (em milisegundos): ");
            t = sc.nextDouble();
        }else{
            t = 500;
            n = 17;
            System.out.println("Os dados utilizados serao os que estao no codigo:");
            System.out.println("n = " + n + ", e t = " + t);
        }
        TreeBranchFractal tbf = new TreeBranchFractal(n, t);
    }

}
