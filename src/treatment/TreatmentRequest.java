package treatment;

import java.net.*;
import java.util.*;;

public class TreatmentRequest {
    // static String[] listMethod = { "POST", "GET", "PUT", "DELETE" };

    String method;
    URL url;

    String host;
    int port;

    String[] requestHeader;
    String requestBody;

    public String getMethod() {
        return this.method;
    }

    public URL getUrl() {
        return this.url;
    }

    public int getPort() {
        return this.port;
    }

    public String getHost() {
        return this.host;
    }

    public String[] getRequestHeader() {
        return this.requestHeader;
    }

    public String getRequestBody() {
        return this.requestBody;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setPort(int port) {
        if (port == -1)
            port = 80;
        this.port = port;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setUrl(String url) throws Exception {
        this.url = new URL(url);
    }

    public void setRequestHeader(String url) throws Exception {
        Vector<String> header = new Vector<String>();
        if (this.url == null) {
            throw new Exception("Pas d'url");
        }

        setHost(this.url.getHost());
        setPort(this.url.getPort());

        String path = this.url.getPath();
        if (path.equalsIgnoreCase(""))  path = "/";

        // cas ou il y a un query avec l'url
        String query = this.url.getQuery();

        // si methode get -> query avec le path
        if(this.method.equalsIgnoreCase("GET")){
            if(query!=null){
                path += "?"+query;
            }
        }
        // si methode post -> query dqns le body de la requete
        if(this.method.equalsIgnoreCase("POST")){
            requestBody = query;
        }

        // requete pour envoyer le path
        String pattern = this.method + " " + path + " HTTP/1.1";

        header.add(pattern);
        header.add("Host: " + host + ":" + port);
        header.add("User-Agent: navigateur_postman/1.0");
        
        if (this.method.equalsIgnoreCase("PUT")) {
            header.add("Content-type: text/html");
            header.add("Content-length: 16");
            requestBody = "<p>Nouveau fichier</p>";
        }
        // mety miampy pour autre methode que get, post sy put

        String[] reqHeaders = new String[header.size()];
        int i = 0;
        for (Object head : header.toArray()) {
            reqHeaders[i] = (String) head;
            //System.out.println(reqHeaders[i]);
            i++;
        }
        requestHeader = reqHeaders;
    }

    public TreatmentRequest(String url, String method) throws Exception {
        try {
            setMethod(method);
            setUrl(url);
            setRequestHeader(url);
        } catch (Exception e) {
            throw new Exception("Requete incorrecte");
        }
    }

    // test fonctionnement test Treatement
    /*
     * public static void main(String[] args) throws Exception{
     * TreatmentRequest treat = new
     * TreatmentRequest("http://localhost:8080/form/","GET");
     * }
     */
}