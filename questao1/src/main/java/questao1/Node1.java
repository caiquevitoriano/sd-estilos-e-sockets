/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author caique
 */
public class Node1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int recebido;
        final Random random = new Random();

        Socket cliente = new Socket("127.0.0.1", 2222);

        int x = random.nextInt(101);
        int y = random.nextInt(101);

        System.out.println("<----- GERANDO NUMEROS ----->");
        System.out.println("Numero 1 (x): " + x);
        System.out.println("Numero 2 (y): " + y);

        List<Integer> numeros = new ArrayList<>();

        numeros.add(x);
        numeros.add(y);

        ObjectOutputStream outputStream = new ObjectOutputStream(cliente.getOutputStream());
        outputStream.writeObject(numeros);

        ObjectInputStream inputStream = new ObjectInputStream(cliente.getInputStream());
        recebido = inputStream.readInt();

        if (recebido == 0) {
            System.out.println("<----- ERRO ----->");
            System.out.println("Os valores são iguais");
        }

    }

}
