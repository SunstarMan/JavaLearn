/**
 * @author Chen Manman
 * @since 2022/12/15 21:11
 */

import java.net.*;
import java.io.*;

public class SocketServer extends Thread {
    private final ServerSocket serverSocket;

    public SocketServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "…");
                Socket socket = serverSocket.accept();
                System.out.println("远程主机地址：" + socket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("谢谢连接我：" + socket.getLocalSocketAddress() + "\nGoodbye!");
                socket.close();
            } catch (SocketTimeoutException s) {
                System.out.println("\"Socket timed out!\"");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = 5000;
        try {
            Thread t = new SocketServer(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
