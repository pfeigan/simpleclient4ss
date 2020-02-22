import javax.websocket.ClientEndpointConfig;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.net.URI;

public class EMain {
    public static void main(String[] args) {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            container.connectToServer(EEndPoint.class,
                    ClientEndpointConfig.Builder.create().build(),
                    URI.create("ws://127.0.0.1:12345"));
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
