package treatment;

import java.io.*;
import java.net.*;
import java.util.Vector;

public class Client {
    private Socket clientSocket;
    private URL url;
    private String[] response;
    private Header header;
    private String[] body;

    public void setClientSocket(Socket socket) {
        this.clientSocket = socket;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    /***
     * tokony jerena hoe akory ny affichage eo amin'ny separation header sy body
     ***/

    public void setHeader(String[] response) {

    }

    public void setBody(String[] response) {

    }

    public URL getUrl() {
        return this.url;
    }

    public Header getHeader() {
        return this.header;
    }

    public String[] getBody() {
        return this.body;
    }

    public Client() {
    }

    public Client(String method, String host, int port, String[] requestHeader, String requestBody) throws Exception {
        try {
            setUrl(url);
            setClientSocket(new Socket(host, port));
        } catch (Exception e) {
            throw new Exception("Verifiez votre connexion");
        }
        try {
            PrintStream out = new PrintStream(clientSocket.getOutputStream());
            for (String line : requestHeader) {
                out.println(line);
            }
            out.println();
            if (requestBody != null)
                out.println(requestBody);
            out.println();
            out.flush();
            clientSocket.shutdownOutput();
            Vector<String> liste = new Vector<String>();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            for (String object : in.lines().toList()) {
                liste.add(object);
                System.out.println("/" + object + "/");
            }
            clientSocket.close();
            response = new String[liste.size()];
            int i = 0;
            for (Object string : liste.toArray()) {
                response[i] = (String) string;
            }
            setHeader(response);
            setBody(response);
        } catch (Exception e) {
            throw new Exception("Erreur sur l'output");
        }
    }

}
