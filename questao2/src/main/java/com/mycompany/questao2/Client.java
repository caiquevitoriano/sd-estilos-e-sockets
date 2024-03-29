/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questao2;

import java.io.IOException;
import java.io.ObjectInputStream;
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

        System.out.println("<----- CLIENTE ----->");
        Socket client = new Socket("127.0.0.1", 1111);
        Socket client2 = new Socket("127.0.0.1", 3333);

        // x, y, op e node
        List<Integer> valores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        final Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);

        System.out.println("<----- GERANDO NUMEROS ----->");
        System.out.println("Numero 1 (x): " + x);
        System.out.println("Numero 2 (y): " + y);
        valores.add(x);
        valores.add(y);

        System.out.println("< op1(x,y)=2yx --- op2(x,y)=2x/y >");
        System.out.print("Informe a operação (op1 ou op2): ");
        int op = scanner.nextInt();
        valores.add(op);

        System.out.print("Informe o Node: ");
        int node = scanner.nextInt();
        valores.add(node);

        if (node == 1) {
            ObjectOutputStream outputStream = new ObjectOutputStream(client.getOutputStream());
            outputStream.writeObject(valores);
            
            client2.close();
            client.close();
        } else if(node == 3){
            ObjectOutputStream outputStream = new ObjectOutputStream(client2.getOutputStream());
            outputStream.writeObject(valores);
            
            client.close();
            client2.close();
            
        } if(node == 2){
            System.out.println("NODE 2 - REPLICA");
        }

        

    }

}
