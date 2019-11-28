/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questao3;

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
public class Node2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here

        int op;
        List<Integer> valores = new ArrayList<>();

        ServerSocket server = new ServerSocket(2222);
        Socket aceito = server.accept();

        ObjectInputStream inputStream = new ObjectInputStream(aceito.getInputStream());
        valores = (List<Integer>) inputStream.readObject();

        op = valores.get(2);

        Socket cliente = null;

        if (op == 2) {
            System.out.println("Envia para node 3");
            cliente = new Socket("127.0.0.1", 3333);
        } else if (op == 1) {
            System.out.println("Envia para device (node4)");
            cliente = new Socket("127.0.0.1", 4444);
        }

        ObjectOutputStream outputStream1 = new ObjectOutputStream(cliente.getOutputStream());
        outputStream1.writeObject(valores);

        outputStream1.close();
        cliente.close();

    }
}
