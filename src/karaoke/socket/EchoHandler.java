package karaoke.socket;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import karaoke.control.MusicaControl;
import karaoke.control.PlayControl;
import karaoke.control.PontuacaoCalculadaControl;
import karaoke.dao.PontuacaoDao;
import karaoke.model.Pontuacao;
import karaoke.model.UltimoResultado;
import static karaoke.socket.MessageFlag.KEY_MUSICAS;
import static karaoke.socket.MessageFlag.KEY_SOLICITARCANTORES;
import static karaoke.socket.MessageFlag.KEY_ULTIMORESULTADO;

public class EchoHandler implements MessageHandler {

    @Override
    public void onReceive(Connection connection, String message) {
        System.out.println("Got a message from a client:");
        System.out.println(message);
        System.out.println("Send back the same message back to the client.");
        connection.println(MessageFlag.KEY_CONECTAR + "|" + message);
    }

    @Override
    public void onVotar(Connection connection, String message) {
        try {
            PontuacaoDao pontuacaoDao = new PontuacaoDao(Persistence.createEntityManagerFactory("karaokePU"));
            String mensagemRetorno = " ";
            List<Pontuacao> pontuacoes = new ArrayList<>();
            Gson gson = new Gson();

            pontuacoes = gson.fromJson(message, new TypeToken<List<Pontuacao>>() {
            }.getType());

            if (pontuacaoDao.createLote(pontuacoes)) {
                mensagemRetorno = "Obrigado por votar!";
            }
            connection.println(MessageFlag.KEY_VOTAR + "|" + MessageFlag.MSG_SUCESSO + "|" + mensagemRetorno);
        } catch (Exception ex) {
            connection.println(MessageFlag.KEY_VOTAR + "|" + MessageFlag.MSG_FALHA + "|" + ex);
            Logger.getLogger(EchoHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void onSolicitarCantores(Connection connection, String message) {
        //KEY_SOLICITARCANTORE|MUSICA - CANTOR|APELIDO1|APELIDO2|BATALHA
        //NOVO, Enviar STRING E TRATAR NA CLASS
        String resposta;
        PlayControl playControl = new PlayControl();
        playControl.retornarUltimoPlayAberto();

        resposta = KEY_SOLICITARCANTORES + playControl.getPlaySelecionado().toJson();
        connection.println(resposta);
    }

    @Override
    public void onSolicitarMusicas(Connection connection, String message) {
        Gson gson = new Gson();
        String resposta;
        MusicaControl musicaControl = new MusicaControl();
        musicaControl.pesquisarMusicaCantorNacional(true);

        resposta = KEY_MUSICAS + gson.toJson(musicaControl.getMusicaTabela());
        System.out.println(resposta);
        connection.println(resposta);
    }

    @Override
    public void onSolicitarUltimoResultado(Connection connection, String message) {
        Gson gson = new Gson();
        StringBuilder resposta = new StringBuilder(KEY_ULTIMORESULTADO);
        String retorno;
        PontuacaoCalculadaControl pontuacaoCalculadaControl = new PontuacaoCalculadaControl();
        List<Object[]> results = pontuacaoCalculadaControl.retornarUltimaVotacao();

        for (Object[] result : results) {
            resposta.append(result[0].toString()).append(": ").append(result[1].toString()).append("|");
        }
        
        retorno = resposta.substring(0, resposta.length() - 1);

        System.out.println(retorno);
        connection.println(retorno);
    }
}
