import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] arg) throws Exception {
        Logger log=Logger.getLogger("xwisen");
        log.info("star java http server ......");
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/ping", new PingHandler());
        server.start();
    }

    static  class PingHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "ping";
            exchange.sendResponseHeaders(200, 0);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
            Logger log=Logger.getLogger("xwisen");
            log.info("/ping");
        }
    }
}