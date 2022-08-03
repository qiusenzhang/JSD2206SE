package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class Client {

    private Socket socket;
    public Client() {
        try {
            System.out.println("正在连接服务端...");
            socket = new Socket("localhost", 8088);
            System.out.println("与服务端建立连接！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        try {
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw,true);
            while (true){
                String line = scanner.nextLine();
                if ("exit".equals(line)){
                    System.out.println("退出连接！");
                    break;
                }else {
                    pw.println(line);
                    System.out.println("发送成功！");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                /*
                socket的close方法里封装了与服务端4次挥手操作，与服务端断开连接。
                并且该close还会在内部将通过socket获取的输入流与输出流关闭。
                 */
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
