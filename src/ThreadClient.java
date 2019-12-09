import java.net.Socket;
import java.util.Scanner;

public class ThreadClient extends Thread {
    private Socket socket;

    public ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
    	
    	Scanner scanner = null;
    	
        try {
        	
            scanner = new Scanner(System.in);
            String path;
//          switch(c) {
//          case 1:
//          case 2:
//          }
            
            new RecieverThread(socket,"D:\\Suveb\\a\\server\\").start();
            
            do {
                System.out.println("Enter File to be Sent:");
                path = scanner.nextLine();
                new SenderThread(socket,"D:\\Suveb\\a\\img.pn"+path).start();
            } while (path != "0");
            
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
