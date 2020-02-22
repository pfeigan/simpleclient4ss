import simpleclient.Receiver;
import simpleclient.SimpleEndPoint;

public class PLReceiver implements Receiver {
    public void callBack(String msg, SimpleEndPoint endPoint){
        System.out.println(msg);
    }

}
