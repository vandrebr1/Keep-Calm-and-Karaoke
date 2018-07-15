package karaoke.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListeningThread extends Thread {

    private SocketServer socketServer;
    private ServerSocket serverSocket;
    private Vector<ConnectionThread> connectionThreads;
    private Vector<ConnectionThread> notRunningConnectionThreads;
    private boolean isRunning;

    public ListeningThread(SocketServer socketServer, ServerSocket serverSocket) {
        this.socketServer = socketServer;
        this.serverSocket = serverSocket;
        this.connectionThreads = new Vector<ConnectionThread>();
        this.notRunningConnectionThreads = new Vector<ConnectionThread>();
        isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            if (serverSocket.isClosed()) {
                isRunning = false;
                break;
            }

            getConnectionThreads();

            try {
                Socket socket;
                socket = serverSocket.accept();
                ConnectionThread connectionThread = new ConnectionThread(socket, socketServer);
                connectionThreads.addElement(connectionThread);
                connectionThread.start();
            } catch (IOException e) {
                Logger.getLogger(ListeningThread.class.getName()).log(Level.SEVERE, null, e);

            }
        }
    }

    public void stopRunning() {
        for (int i = 0; i < connectionThreads.size(); i++) {
            connectionThreads.elementAt(i).stopRunning();
        }
        isRunning = false;
    }

    public Vector<ConnectionThread> getConnectionThreads() {
        // Remove not running connection threads.
        for (ConnectionThread connectionThread : connectionThreads) {
            if (!connectionThread.isRunning()) {
                notRunningConnectionThreads.addElement(connectionThread);
            }
        }
        for (ConnectionThread connectionThread : notRunningConnectionThreads) {
            connectionThreads.remove(connectionThread);
        }
        notRunningConnectionThreads.clear();

        return connectionThreads;
    }

}
