package treatment;

import java.io.*;
import java.net.*;
import java.util.Vector;

public class Client {
    Socket clientSocket;
    URL url;
    String[] response;
    String[] header;
    String[] body;

    public void setClientSocket(Socket socket) {
        this.clientSocket = socket;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public void setHeaderBody(String[] response) {
        Vector<String> m_header = new Vector<String>();
        Vector<String> m_body = new Vector<String>();

        int i = 0;
        try {
            while (!response[i].equalsIgnoreCase("<!DOCTYPE html>")) {
                m_header.add(response[i]);
                i++;
            }
            while (i != response.length) {
                m_body.add(response[i]);
                i++;
            }
            String[] listHeader = new String[m_header.size()];
            String[] listBody = new String[m_body.size()];
            System.out.println("Header:");
            for (i = 0; i < m_header.size(); i++) {
                listHeader[i] = m_header.get(i);
                // System.out.println(listHeader[i]);
            }
            this.header = listHeader;
            System.out.println();
            System.out.println("Body:");
            for (i = 0; i < m_body.size(); i++) {
                listBody[i] = m_body.get(i);
                // System.out.println(listBody[i]);
            }
            this.body = listBody;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public URL getUrl() {
        return this.url;
    }

    public String[] getHeader() {
        return this.header;
    }

    public String[] getBody() {
        return this.body;
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
                // System.out.println(response[i]);
                i++;
            }
            System.out.println(response.length);
            setHeaderBody(response);
        } catch (Exception e) {
            throw new Exception("Erreur sur l'output");
        }
    }

    public static Client createClient(TreatmentRequest treat) throws Exception {
        return new Client(treat.getMethod(), treat.getHost(), treat.getPort(), treat.getRequestHeader(),
                treat.getRequestBody());
    }

    // test fonctionnement fonction
    /*
     * public static void main(String[] args) throws Exception{
     * String[] header = new String[3];
     * header[0] = "GET /L2/08_Ajax_v3/ HTTP/1.1";
     * header[1] = "Host: localhost:8080";
     * header[2] = "User-Agent: navigateur_postman/";
     * Client client = new Client("GET","localhost",80,header,null);
     * }
     */

}
