package simpleclient;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnOpen;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.net.URI;

@ClientEndpoint
public class SimpleEndPoint {
    Session userSession = null;
    public Receiver msgDelivery;
    //pivate MessageHandler messageHandler;

    public SimpleEndPoint(URI endpointURI, Receiver usrFunction) {
        msgDelivery = usrFunction;
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @OnOpen
    public void onOpen(Session userSession) {
        this.userSession = userSession;
        msgDelivery.callBack("connected", this);
    }

    @OnMessage
    public void onMessage(String message){
        //System.out.println("msg received");
        msgDelivery.callBack(message, this);
    }
    public void setCallback(Receiver newReceiver){
        msgDelivery = newReceiver;
    }
    public void sendMessage(String txt){
        try{
            userSession.getBasicRemote().sendText(txt);
            //userSession.getAsyncRemote().sendText(txt);
            //System.out.println("message sent");
        }
        catch (Exception e){
            //stem.out.println("message fail");
        }
    }
    public void closeSession(){
        try {
            userSession.close();
        }catch(Exception e){}
    }
}
