package lt;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyhttpClient {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket accept = serverSocket.accept();
        server(accept);
    }

    static void server(Socket socket){
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("http/1.1 200 ok");
            String reponseBody="hello,java world2";
            writer.println("Content-length:"+reponseBody.getBytes().length);
            writer.println();
            writer.write(reponseBody);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
