package sockettest;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.sun.xml.internal.ws.server.ServerRtException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 聊天室服务端
 *
 */
public class Server {
    private ServerSocket serverSocket;

    public Server() {
        try {
            System.out.println("服务端正在启动...");
            serverSocket = new ServerSocket(8088);
            System.out.println("服务端启动成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        try {
            while (true) {
                System.out.println("等待客户端连接...");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端已连接！");
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();

    }

    private class ClientHandler implements Runnable{
        private Socket socket;
        private String host;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            host = socket.getInetAddress().getHostAddress();
        }


        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(host+"说"+line);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
