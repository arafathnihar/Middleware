package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CapitalizeClient {

    private BufferedReader in;
    private PrintWriter out;

    public void connectToServer() throws IOException {

        Socket socket = new Socket("127.0.0.1", 9898);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        Calculator c = new Calculator();
        c.calculator();
    }
    public static void main(String args[]){
        CapitalizeClient cc = new CapitalizeClient();
        try {
            cc.connectToServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
