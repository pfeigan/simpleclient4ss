import simpleclient.Receiver;
import simpleclient.SimpleEndPoint;

public class ConnReceiver implements Receiver{
    public void callBack(String msg, SimpleEndPoint endPoint){
        /*try {
            Thread.sleep(2000);
        }catch(Exception e){}*/
        PLReceiver blah = new PLReceiver();
        String handshake = "[\n" +
                "  {\n" +
                "    \"RequestServerInfo\": {\n" +
                "      \"Id\": 1,\n" +
                "      \"ClientName\": \"SSClient\",\n" +
                "      \"MessageVersion\": 1\n" +
                "    }\n" +
                "  }\n" +
                "]\n";
        System.out.println(msg);
        endPoint.setCallback(new DeviceAsker());
        //endPoint.setCallback(blah);
        endPoint.sendMessage(handshake);
        try {
            Thread.sleep(20000);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
