import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultiClient {

	private static int port = 5000;
	private static String server = "localhost";
	
    public static void main(String[] args) {
    	
    	Scanner scanner = null;
    	
        try (Socket socket = new Socket(server, port)) {
        	scanner = new Scanner(System.in);
        	String path;
//          switch(c) {
//          case 1:
//          case 2:
//          }
            
        	new RecieverThread(socket,"D:\\Suveb\\a\\client\\").start();
        	
        	do {
                System.out.println("Enter File to be Sent:");
                path = scanner.nextLine();
                new SenderThread(socket,"D:\\Suveb\\a\\img.pn"+path).start();
            } while (path != "0");

        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
        finally {
        	scanner.close();
        }
    }
}