package treatment;

import java.net.*;
import java.util.*;;

public class TreatmentRequest{
    static String[] listMethod = { "POST","GET","PUT","DELETE"};
    
    String method;
    URL url;
    String httpVersion;             /*** mbola amboarina ***/

    String host;
    int port;

    String[] requestHeader;
    String[] requestBody;

    public String getMethod(){
        return this.method;
    }
    public URL getUrl(){
        return this.url;
    }
    public String getHttpVersion(){
        return this.httpVersion;
    }
    
    public String[] getRequestHeader(){
        return this.requestHeader;
    }
    public String[] getRequestBody(){
        return this.requestBody;
    }

    public void setMethod(String method){
        this.method = method;
    }
    public void setHttpVersion(String httpVersion){
        this.httpVersion = httpVersion;
    }
    public void setUrl(String url) throws Exception{
        this.url = new URL(url);
    }

    public void setRequestHeader() throws Exception{
        Vector<String> header = new Vector<String>();
        if(this.url == null){
            throw new Exception("Pas d'url");
        }
        String path = this.url.getPath();
        if(this.httpVersion == null){
            setHttpVersion("HTTP/1.1");
        }
        String host = url.getHost();
        int port = url.getPort();
        if(port == -1) port = 80;

        String pattern = this.method + " " + path + this.httpVersion;
        header.add(pattern);
        header.add("Host: " + host + ":" + port);
        header.add("User-Agent: navigateur_postman/2022.12.0");
        
    }
    public void setRequestBody() throws Exception{
        if(this.method.equalsIgnoreCase("POST")){
            //mbola asiana zavatra   
        }
    }

    public TreatmentRequest(String url, String method) throws Exception{
        try{
            setMethod(method);
            setUrl(url);
            setRequestHeader();
            setRequestBody();
        }
        catch(Exception e){
            throw new Exception("Requete incorrecte");
        }
    }
}