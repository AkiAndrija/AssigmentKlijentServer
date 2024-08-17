
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;


public class Klijent {
    public static void main(String[] args) {

        try(Socket socket = new Socket("localhost", 1080);
            BufferedReader bis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream())) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a first number:");
            int numb1 = sc.nextInt();
            bos.write(numb1);
            bos.flush();

            System.out.println("Enter a second number:");
            int numb2 = sc.nextInt();
            bos.write(numb2);
            bos.flush();
            int res = bis.read();

            System.out.println("Rezultat je:" + res);



        } catch(IOException e){
            System.out.println(e.getMessage());

        }
    }
}
