/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao1;

import java.util.Random;

/**
 *
 * @author caique
 */
public class Node1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final Random random = new Random();
        int n1 = random.nextInt(101);
        int n2 = random.nextInt(101);
        
        System.out.println("<----- GERANDO NUMEROS ----->");
        System.out.println("Numero 1: " + n1);
        System.out.println("Numero 2: " + n2);

    }

}
