package karaoke.socket;

import java.net.Socket;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection {

    private Socket socket;

    public Connection(Socket socket) {
        this.socket = socket;
    }

    public void println(String message) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream()), true);
            writer.println(message);
        } catch (IOException e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);

        }
    }
}
