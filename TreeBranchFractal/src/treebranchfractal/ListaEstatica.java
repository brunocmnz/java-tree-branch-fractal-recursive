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
public class ListaEstatica {

    private Ramo[][] ramos;

    public ListaEstatica(int nivelMax) {
        ramos = new Ramo[nivelMax + 1][];
    }

    public void add(Ramo r) {
        //Se a posicao esta nula cria um vetor de Ramo com 10 posicoes
        if (ramos[r.nivel] == null) {
            inicializaNivelAtual(r.nivel);
        }
        //For passando em nAtual verificando se existe posicao vazia para adicionar
        int i = 0;
        Ramo[] nAtual = ramos[r.nivel];
        for (; i < nAtual.length; i++) {
            //Se encontra uma posicao vazia, da um break
            if (nAtual[i] == null) {
                break;
            }
        }
        ramos[r.nivel] = nAtual;
        ramos[r.nivel][i] = r;
        if (ramos[r.nivel][ramos[r.nivel].length - 1] != null) {
            System.out.println("Nivel " + r.nivel + " Ok!");
        }
    }

    public void inicializaNivelAtual(int n) {
        int len = 1;
        for (int i = 0; i < n; i++) {
            len *= 2;
        }
        ramos[n] = new Ramo[len];
    }

    public Ramo[] getNivel(int nivel) {
        return ramos[nivel];
    }

}
