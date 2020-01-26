import server.BasicHttpServer;

public class Main {

    public static void main(String[] args) throws Exception {
        BasicHttpServer basicHttpServer = new BasicHttpServer();
        basicHttpServer.start();
    }
}
