package ge.edu.btu.chat.client;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket;
        ObjectOutputStream objectOutputStream;

        try {
            socket = new Socket("localhost", 9011);
            System.out.println("მიმდინარეობს კავშირის დამყარება...");

            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            Scanner myObj = new Scanner(System.in);
            System.out.println("დასვი კითხვა: ");

            String question = myObj.nextLine();
            System.out.println("პასუხი: " + question);
            objectOutputStream.writeObject(question);



            objectOutputStream.close();
            socket.close();
        }catch (Exception ex){
            System.out.println("შეცდომა " + ex);
        }
    }
}
