package br.tche.ucpel.tads.doo1.comunicacaorede.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author mertins
 */
public class Conexao {

    private Socket socket;
    private ServerSocket serverSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Conexao() {
    }

    public void aguardarCliente() throws IOException {
        serverSocket = new ServerSocket(8888);
        socket = serverSocket.accept();
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    public void conectarServidor(String local) throws UnknownHostException, IOException {
        socket = new Socket(local, 8888);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    public void enviar(Mensagem x) throws IOException {
        out.writeObject(x);
    }

    public Mensagem receber() throws IOException, ClassNotFoundException {
        return (Mensagem) in.readObject();
    }

    
    public void close() {
        try {
            in.close();
        } catch (Exception ex) {
        }
        try {
            out.close();
        } catch (Exception ex) {
        }
        try {
            socket.close();
        } catch (Exception ex) {
        }
        try {
            serverSocket.close();
        } catch (Exception ex) {
        }
    }
}
