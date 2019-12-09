import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

public class RecieverThread extends Thread {
	private Socket socket;
	private String recFile;

    public RecieverThread(Socket socket,String recFile) {
        this.socket = socket;
        this.recFile = recFile;
    }

    @Override
    public void run() {
    	
    	FileOutputStream fos = null;
    	DataInputStream dis = null;
    	InputStream is = null;
    	int i = 0;
    	
    	while(true) {
    		i++;
    		try {
        		System.out.println("Connecting...");
        	    is = socket.getInputStream();
        	    dis = new DataInputStream(is);
        	    fos = new FileOutputStream(recFile+ this.getName() + i + dis.readUTF());
        	    
        	    int bytesRead;
                int current = 0;
        	    
        	    Date d = new Date();
        	    while((bytesRead = is.read() ) > -1) {
        	    	fos.write(bytesRead);
        	    	if(bytesRead >= 0) current++;
        	    }
        	    System.out.println(new Date().getTime() - d.getTime());
        	          
        	   System.out.println("downloaded (" + current + " bytes read)");
        	   
        	   fos.close();
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
    	}
    }
}
