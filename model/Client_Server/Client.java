package model.Client_Server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{	
        Socket client =new Socket("localhost",6666);
        
        DataInputStream input = new DataInputStream(client.getInputStream());	
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String text = "",text2 = "";  
        while(!text.equals("stop")){  
        text=reader.readLine();  
        output.writeUTF(text);  
        output.flush();  
        text2=input.readUTF();  
        System.out.println("From Server: " + text2);  
        }  
          
        output.close();  
        client.close();
        
        }catch(Exception e){System.out.println(e);}
    }
    
}
