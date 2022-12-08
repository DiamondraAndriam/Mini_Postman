package treatment;

import java.io.*;
import java.net.*;

public class Client {
    private Socket clientSocket;
    private URL url;
    private Header header;
    private String[] body;

    public void setUrl(URL url) {
        this.url = url;
    }
    public void setHeader(Header header){
        this.header = header;
    }
    public void setBody(String[] body){
        this.body = body;
    }

    public URL getUrl(){
        return this.url;
    }
    public Header getHeader(){
        return this.header;
    }
    public String[] getBody(){
        return this.body;
    }

    public Client(){}
    public Client(String method, URL url, String[] requestHeader, String[] requestBody) throws Exception{
        setUrl(url);
        String host = url.getHost();
        int port = url.getPort();
    }

}
