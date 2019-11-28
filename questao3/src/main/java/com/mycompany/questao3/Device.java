/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questao3;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
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
public class Device {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here

        int x;
        int y;
        int op;
        int resultado = 0;
        List<Integer> valores = new ArrayList<>();

        ServerSocket device = new ServerSocket(4444);
        Socket aceito = device.accept();

        ObjectInputStream inputStream = new ObjectInputStream(aceito.getInputStream());
        valores = (List<Integer>) inputStream.readObject();
        x = valores.get(0);
        y = valores.get(1);
        op = valores.get(2);

        if (op == 1) {
            resultado = x + y;
        } else if (op == 2) {
            resultado = x - y;
        }
        
        System.out.println("Resultado da op" + op + ": " + resultado);
        
        ObjectOutputStream outputStream = new ObjectOutputStream(aceito.getOutputStream());
        outputStream.writeInt(resultado);
        outputStream.close();

    }

}
