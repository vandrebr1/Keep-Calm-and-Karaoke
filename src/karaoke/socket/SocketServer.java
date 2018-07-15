package karaoke.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketServer {

    private ServerSocket serverSocket;
    private ListeningThread listeningThread;
    private MessageHandler messageHandler;

    public SocketServer(int port, MessageHandler handler) throws IOException {
        messageHandler = handler;

        serverSocket = new ServerSocket(port);
        listeningThread = new ListeningThread(this, serverSocket);
        listeningThread.start();

    }

    public void setMessageHandler(MessageHandler handler) {
        messageHandler = handler;
    }

    public MessageHandler getMessageHandler() {
        return messageHandler;
    }

    public void closeServer() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                listeningThread.stopRunning();
                listeningThread.suspend();
                listeningThread.stop();

                serverSocket.close();
            }
        } catch (IOException e) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ListeningThread getListeningThread() {
        return listeningThread;
    }

    public void setListeningThread(ListeningThread listeningThread) {
        this.listeningThread = listeningThread;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

}
