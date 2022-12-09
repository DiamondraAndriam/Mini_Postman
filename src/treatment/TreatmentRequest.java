package treatment;

import java.net.*;
import java.util.*;;

public class TreatmentRequest {
    //static String[] listMethod = { "POST", "GET", "PUT", "DELETE" };

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
    public int getPort(){
        return this.port;
    }
    public String getHost(){
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
    public void setPort(int port){
        if(port == -1) port = 80;
        this.port = port;
    }
    public void setHost(String host){
        this.host = host;
    }
    public void setUrl(String url) throws Exception {
        this.url = new URL(url);
    }

    public void setRequestHeader() throws Exception{
        Vector<String> header = new Vector<String>();
        if(this.url == null){
            throw new Exception("Pas d'url");
        }
        String path = this.url.getPath();
        setHost(url.getHost());
        setPort(url.getPort());
        if(port == -1) port = 80;

        if(path.equalsIgnoreCase("")) path = "/";
        String pattern = this.method + " " + path + " HTTP/1.1";
        // pour la méthode GET : si on ne met pas la version de HTTP, on ne reçoit pas de header

        header.add(pattern);
        header.add("Host: " + host + ":" + port);
        header.add("User-Agent: navigateur_postman/2022.12.0");
        if(this.method.equalsIgnoreCase("POST")){
            String thisUrl = url.toString();
            String parameter = thisUrl.split("?",2)[1];
            header.add("Content-Type: application/x-www-form-urlencoded");
            header.add("Content-Length: " + parameter.length());
            requestBody = parameter;
        }
        if(this.method.equalsIgnoreCase("PUT")){
            header.add("Content-type: text/html");
            header.add("Content-length: 16");
            requestBody = "<p>Nouveau fichier</p>";
        }
        // mety miampy pour autre methode que get, post sy put

        String[] reqHeaders = new String[header.size()];
        int i = 0;
        for(Object head:header.toArray()){
            reqHeaders[i] = (String) head;
            System.out.println(reqHeaders[i]);
            i++;
        }
        requestHeader = reqHeaders;
    }

    public TreatmentRequest(String url, String method) throws Exception {
        try {
            setMethod(method);
            setUrl(url);
            setRequestHeader();
        } catch (Exception e) {
            throw new Exception("Requete incorrecte");
        }
    }

    //test fonctionnement test Treatement
    /*public static void main(String[] args) throws Exception{
        TreatmentRequest treat = new TreatmentRequest("http://localhost:8080/form/","GET");
    }*/
}