/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questao2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caique
 */
public class Node3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here

        int x;
        int y;
        int op;
        List<Integer> valores = new ArrayList<>();

        ServerSocket server = new ServerSocket(3333);
        Socket aceito = server.accept();

        ObjectInputStream inputStream = new ObjectInputStream(aceito.getInputStream());
        valores = (List<Integer>) inputStream.readObject();
        x = valores.get(0);
        y = valores.get(1);
        op = valores.get(2);

        if (op == 2) {

            op2(x, y);
            ObjectOutputStream outputStream = new ObjectOutputStream(aceito.getOutputStream());
            outputStream.flush();

        } else if (op == 1) {
            System.out.println("VAI PRO NODE 1");
        }
    }

    public static void op2(int x, int y) {

        System.out.println("<----- OP 2 - NODE 1 ----->");

        double total = (2 * x) / y;
        System.out.println("op2: " + total);
    }

}
