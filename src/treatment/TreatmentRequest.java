package treatment;

import java.net.*;
import java.util.*;;

public class TreatmentRequest {
    static String[] listMethod = { "POST", "GET", "PUT", "DELETE" };

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

    public String[] getRequestHeader() {
        return this.requestHeader;
    }

    public String getRequestBody() {
        return this.requestBody;
    }

    public void setMethod(String method) {
        this.method = method;
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
        String host = url.getHost();
        int port = url.getPort();
        if(port == -1) port = 80;

        String pattern = this.method + " " + path + "HTTP/1.1";
        if(this.method.equalsIgnoreCase("GET")){
            pattern = this.method + " " + path;
        }
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
        // mety miampy pour autre methode que get

        String[] reqHeaders = new String[header.size()];
        int i = 0;
        for(Object head:header.toArray()){
            reqHeaders[i] = (String) head;
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
}