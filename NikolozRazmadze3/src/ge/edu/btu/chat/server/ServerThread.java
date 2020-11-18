package ge.edu.btu.chat.server;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket client;
    private int clientID;
    private boolean running = true;

    public ServerThread(Socket client, int clientID) {

        this.client = client;
        this.clientID = clientID;
    }

    public void run(){
        System.out.println(clientID);
        System.out.println(client);



        try {
            System.out.println("მონაცემების წაკითხვა ...");
            ObjectInputStream objectInputStream = new
                    ObjectInputStream(client.getInputStream());
            String str = (String) objectInputStream.readObject();
            System.out.println("მიღებული შეტყობინება :"  + str);

            System.out.println("კავშირის დასასრული !!!" );
        } catch (Exception ex) {
            System.out.println("შეცდომა : " + ex);
        }

    }
}

