package karaoke.socket;

public interface MessageHandler {
    public void onReceive(Connection connection, String message);
    
    public void onVotar(Connection connection, String message);

    public void onSolicitarCantores(Connection connection, String message);
    
    public void onSolicitarMusicas(Connection connection, String message);
    
    public void onSolicitarUltimoResultado(Connection connection, String message);

}