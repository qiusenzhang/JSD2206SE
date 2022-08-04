package sockettest;

import sun.nio.cs.ext.ISO2022_CN_CNS;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class Client {
    private Socket socket;
    public Client(){
        try {
            System.out.println("正在连接服务端...");
            socket = new Socket("localhost", 8088);
            System.out.println("与服务端连接成功！");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void start(){
        Scanner scanner = new Scanner(System.in);
        try {
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw, true);
            while (true) {
                String line = scanner.nextLine();
                if ("exit".equals(line)) {
                    System.out.println("退出连接！");
                    break;
                } else {
                    pw.println(line);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

}
