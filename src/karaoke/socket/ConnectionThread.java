package karaoke.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionThread extends Thread {

    private Socket socket;
    private SocketServer socketServer;
    private Connection connection;
    private boolean isRunning;

    public ConnectionThread(Socket socket, SocketServer socketServer) {
        this.socket = socket;
        this.socketServer = socketServer;
        connection = new Connection(socket);
        isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            // Check whether the socket is closed.
            if (socket.isClosed()) {
                isRunning = false;
                break;
            }

            BufferedReader reader;
            try {
                reader = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                if (reader == null) {
                    throw new NullPointerException("Desconecção forçada pelo cliente");
                }
                String rawMessage = reader.readLine();
                String messageFlag = rawMessage.substring(0, 1);
                String message = rawMessage.substring(1);

                // Check the message flag.
                switch (messageFlag) {
                    case MessageFlag.KEY_CONECTAR:
                        // Handle the message.
                        if (message != null) {
                            socketServer.getMessageHandler().onReceive(connection, message);
                        }
                        break;
                    case MessageFlag.KEY_DESCONECTAR:
                        stopRunning();
                        break;

                    case MessageFlag.KEY_SOLICITARCANTORES:
                        if (message != null) {
                            socketServer.getMessageHandler().onSolicitarCantores(connection, message);
                        }
                        break;
                    case MessageFlag.KEY_VOTAR:
                        if (message != null) {
                            socketServer.getMessageHandler().onVotar(connection, message);
                        }
                        break;
                        
                    case MessageFlag.KEY_MUSICAS:
                        if (message != null) {
                            socketServer.getMessageHandler().onSolicitarMusicas(connection, message);
                        }
                        break;
                        
                    case MessageFlag.KEY_ULTIMORESULTADO:
                        if (message != null) {
                            socketServer.getMessageHandler().onSolicitarUltimoResultado(connection, message);
                        }
                        break;
                    default:
                        break;
                }

            } catch (IOException | NullPointerException e) {
                Logger.getLogger(ConnectionThread.class.getName()).log(Level.SEVERE, null, e);
                stopRunning();
            }
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void stopRunning() {
        isRunning = false;
        try {
            socket.close();
            System.out.println("Desconectado");
        } catch (IOException e) {
            Logger.getLogger(ConnectionThread.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
