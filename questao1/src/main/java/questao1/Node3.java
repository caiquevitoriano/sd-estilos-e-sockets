/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao1;

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
        List<Integer> numeros = new ArrayList<>();
        ServerSocket serverSocket = new ServerSocket(3333);
        Socket aceito = serverSocket.accept();

        ObjectInputStream inputStream = new ObjectInputStream(aceito.getInputStream());
        numeros = (List<Integer>) inputStream.readObject();
        x = numeros.get(0);
        y = numeros.get(1);

        Double operacao = Math.pow(y, y) + Math.pow(x, x);
        System.out.println("<----- Realizando Operação  ----->");
        System.out.println("f(x, y) = y^y + x^x  = " + operacao);
        
        ObjectOutputStream outputStream = new ObjectOutputStream(aceito.getOutputStream());
        outputStream.writeDouble(operacao);
        outputStream.flush();

    }

}
