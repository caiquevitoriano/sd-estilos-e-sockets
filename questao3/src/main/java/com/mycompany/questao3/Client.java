/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questao3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author caique
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        // x, y, op e node
        List<Integer> valores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        final Random random = new Random();
        int x;
        int y;

        System.out.println("<----- GERANDO NUMEROS ----->");
        System.out.print("Numero 1 (x): ");
        x = scanner.nextInt();
        System.out.println(" --------- ");

        System.out.print("Numero 2 (y): ");
        y = scanner.nextInt();
        
        valores.add(x);
        valores.add(y);

        System.out.println("-----------------------------");
        System.out.print("Informe a operação (1 ou 2): ");
        int op = scanner.nextInt();
        valores.add(op);

        Socket cliente = null;

        if (op == 2) {
            cliente = new Socket("127.0.0.1", 2222);
            System.out.println("--- ENVIANDO OP2 -> NODE 2 ---");
        } else if (op == 1) {
            cliente = new Socket("127.0.0.1", 3333);
            System.out.println("--- ENVIANDO OP1 -> NODE 3 ---");
        }

        ObjectOutputStream outputStream = new ObjectOutputStream(cliente.getOutputStream());
        outputStream.writeObject(valores);

        cliente.close();

    }

}
