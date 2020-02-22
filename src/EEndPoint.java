import javax.websocket.*;
import java.net.URI;


public class EEndPoint extends Endpoint{
    Session userSession = null;
    //pivate MessageHandler messageHandler;

    /*public EEndPoint(URI endpointURI) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }*/
    //@Overide
    public void onOpen(Session userSession, EndpointConfig confg) {
        System.out.println("connected");
        this.userSession = userSession;
    }
}