import java.io.IOException;
import java.net.ServerSocket;

public class SingleServer {

	private static int port = 5000;
	
	public static void main(String[] args) {
		
	    try(ServerSocket serverSocket = new ServerSocket(port)) {
	    	
            while(true) {
                new ThreadClient(serverSocket.accept()).start();
            }

        } catch(IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
	
}
