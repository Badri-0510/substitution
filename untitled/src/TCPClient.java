import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.*;
import java.net.*;


public class TCPClient {

    public static void main(String[] args) { String host="localhost";
        int port=8080;

        try(Socket socket=new Socket(host,port)){
            DataInputStream dis=new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while(true){
                System.out.prin


            }
        }
        catch(Exception e){

        }
    }



}
