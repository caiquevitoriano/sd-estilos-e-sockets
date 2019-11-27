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
public class Node1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here

        int x;
        int y;
        int op;
        List<Integer> valores = new ArrayList<>();  

        ServerSocket server = new ServerSocket(1111);       
        Socket aceito = server.accept();
        
        ObjectInputStream inputStream = new ObjectInputStream(aceito.getInputStream());
        valores = (List<Integer>) inputStream.readObject();
        x = valores.get(0);
        y = valores.get(1);
        op = valores.get(2);
        
        if(op == 1){
            
            op1(x, y);
            ObjectOutputStream outputStream = new ObjectOutputStream(aceito.getOutputStream());
            outputStream.flush();
           
        } else if(op == 2){
            System.out.println("VAI PRO NODE 3");
        }
        
        
        

    }

    public static void op1(int x, int y) {

        System.out.println("<----- OP 1 - NODE 1 ----->");

        double total = 2 * x * y;
        System.out.println("op1: " + total);
    }

}
