package ge.edu.btu.chat.server;

import ge.edu.btu.chat.client.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket; // სერვერი
        Socket socket = null; // კლიენტი
        ObjectInputStream objectInputStream; // ნაკადი
        String str; // მიღებული მონაცემი
        int clientId = 0;
        ServerThread serverThread;

        try {
            serverSocket = new ServerSocket(9011);
            System.out.println("მიმდინარეობს კავშირის დამყარება... ");


            while (true) {

                socket = serverSocket.accept();
                serverThread = new ServerThread(socket, clientId);
                serverThread.start();
                System.out.println("კავშირი დამყარებულია !");
                clientId++;
                System.out.println("დასვი კითხვა: ");



            }

        }catch (Exception ex) {
            System.out.println("შეცდომა "+ex);
        }


    }
}
