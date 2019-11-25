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
public class Node2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        int x = 0;
        int y = 0;

        ServerSocket serverSocket = new ServerSocket(2222);

        List<Integer> numeros = new ArrayList<>();
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        Socket aceito = null;

        while (x == y) {
            
            if (aceito != null) {
                outputStream = new ObjectOutputStream(aceito.getOutputStream());
                outputStream.writeInt(0);
                outputStream.flush();
            }

            aceito = serverSocket.accept();
            inputStream = new ObjectInputStream(aceito.getInputStream());
            numeros = (List<Integer>) inputStream.readObject();
            
            x = numeros.get(0);
            y = numeros.get(1);

        }

        outputStream = new ObjectOutputStream(aceito.getOutputStream());
        outputStream.writeInt(1);
        outputStream.flush();
        
        Socket cliente = new Socket("127.0.0.1", 3333);
        numeros.add(x);
        numeros.add(y);
        
        ObjectOutputStream outputStream1 = new ObjectOutputStream(cliente.getOutputStream());
        outputStream1.writeObject(numeros);
        
        ObjectInputStream inputStream1 = new ObjectInputStream(cliente.getInputStream());
        Double resultado = inputStream1.readDouble();
        
       
        System.out.println("<----- Recebendo Resultato do Node 3 ----->");        
        System.out.println("Valor: "+ resultado);
        outputStream1.close();

    }
    
}
