import java.net.URI;

import simpleclient.Receiver;
import simpleclient.SimpleEndPoint;
public class Main {

    public static void main(String[] args) {
        //PLReceiver blah = new PLReceiver();
        Receiver testR = (String msg, SimpleEndPoint ep)-> System.out.println("test");
        ConnReceiver first = new ConnReceiver();
        try {
            SimpleEndPoint clientEndPoint;
            clientEndPoint = new SimpleEndPoint(new URI("ws://127.0.0.1:12345"), first);
            testR.callBack("blah", clientEndPoint);
            //clientEndPoint = new SimpleEndPoint(new URI("wss://echo.websocket.org"), first);
            //first.sourceEndPoint = clientEndPoint;
            try {
                Thread.sleep(50000);
            }catch(Exception e){}
            //System.out.println(clientEndPoint.msgDelivery);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
