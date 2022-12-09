package test;
import java.io.*;
import java.net.*;

/**
 * Test_client
 */
public class Test_client {
    /*
     * > GET / HTTP/1.1
     * > Host: localhost:8090
     * > User-Agent: insomnia/2022.4.2
     * > x-random: hellooooo world
     * > Accept: *
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        try {
            URL url = new URL("http://localhost:8080/form/");
            String host = url.getHost();
            System.out.println(host);
            InetAddress inetAddress = InetAddress.getByName(host); // inet
            String address = inetAddress.getHostAddress(); // addresse ip
            System.out.println(address);

            Socket clientSocket = new Socket("localhost", 80);
            PrintStream out = new PrintStream(clientSocket.getOutputStream());
            out.println("GET / HTTP/1.1");

            out.println("Host: localhost:80 ");
            out.println("User-Agent: navig_Postmab/2022.0.0");
            out.println();
            out.flush();

            clientSocket.shutdownOutput();
            BufferedReader azo = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            for (String object : azo.lines().toList()) {
                System.out.println(object);
            }
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("mbola manoratra");

    }
}
