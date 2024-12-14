import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.*;
import java.net.*;
public class TCPServer {
    public static void main(String[] args) {

        try(ServerSocket server=new ServerSocket(8080)){
            while(true){
                Socket socket=server.accept();
                DataInputStream dis=new DataInputStream(socket.getInputStream());
                DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
                String message="Message from SERVER";
                dos.writeUTF(message);
                String inpu;

            }
        }catch(Exception e){

        }

    }

}
