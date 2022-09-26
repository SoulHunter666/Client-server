import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Сервер в деле");
        Socket clientSocket = server.accept();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            String message = "privetik";
            out.write(message+"\n");
            out.flush();
            message = in.readLine();
            System.out.println(message);
        }catch (IOException e){
            System.out.println(e);
        }finally {
            System.out.println("Пока-пока!");
            server.close();
        }
    }
}
