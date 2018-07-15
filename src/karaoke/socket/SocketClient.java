package karaoke.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketClient {

    private Socket socket;

    public SocketClient(InetAddress ip, int port) {
        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public void println(String message) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream()), true);
            writer.println(MessageFlag.KEY_CONECTAR + message);
        } catch (IOException e) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    /*
    This function blocks.
     */
    public String readLine() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            return reader.readLine();
        } catch (IOException e) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }

    /*
     * Ready for use.
     */
    public void close() {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream()), true);
            writer.println(MessageFlag.KEY_DESCONECTAR);

            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, e);

        }
    }
}
