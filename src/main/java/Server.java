import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        System.out.println("Listening...");


        try (ServerSocket serverSocket = new ServerSocket(1080);
             Socket socket = serverSocket.accept();
             BufferedReader bis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream())) {

            Scanner sc = new Scanner(System.in);

           int numb1 = bis.read();
           int numb2 = bis.read();
           int res = numb1+numb2;
           bos.write(res);

        } catch (IOException exc) {
            System.out.println(exc.getMessage());


        }
    }
}
