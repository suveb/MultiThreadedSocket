import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SenderThread extends Thread{
	private Socket socket;
	private String sendFile;

    public SenderThread(Socket socket,String sendFile) {
        this.socket = socket;
        this.sendFile = sendFile;
    }

    @Override
    public void run() {
    	
    	FileInputStream fis = null;
    	DataOutputStream dos = null;
    	OutputStream os = null;
    	
        try {
            File file = new File(sendFile);
            fis = new FileInputStream(file);
            
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);
          	int temp = 0;
                
          	dos.writeUTF(file.getName());
            System.out.println("Sending " + file.getName());
                
            while((temp = fis.read()) != -1) {
            	os.write(temp);
            }
            
            System.out.println("Send Complete");

            fis.close();
        } catch(IOException e) {
            System.out.println("Oops: " + e.getMessage());
        }

    }
}