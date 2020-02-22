import simpleclient.Receiver;
import simpleclient.SimpleEndPoint;

public class Vibes implements Receiver {
    public void callBack(String msg, SimpleEndPoint endPoint){
        /*try {
            Thread.sleep(2000);
        }catch(Exception e){}*/
        //PLReceiver blah = new PLReceiver();
        String turnOn = "[\n" +
                "  {\n" +
                "    \"VibrateCmd\": {\n" +
                "      \"Id\": 1,\n" +
                "      \"DeviceIndex\": 1,\n" +
                "      \"Speeds\": [\n" +
                "        {\n" +
                "          \"Index\": 0,\n" +
                "          \"Speed\": 0.1\n" +
                "        }" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "]\n";
        String turnOff = "[\n" +
                "  {\n" +
                "    \"StopDeviceCmd\": {\n" +
                "      \"Id\": 1,\n" +
                "      \"DeviceIndex\": 1\n" +
                "    }\n" +
                "  }\n" +
                "]\n";
        System.out.println(msg);
        endPoint.setCallback(new PLReceiver());
        //endPoint.setCallback(blah);
        endPoint.sendMessage(turnOn);
        try {
            Thread.sleep(3000);
        }catch(Exception e){
            System.out.println(e);
        }
        endPoint.sendMessage(turnOff);
        endPoint.closeSession();
    }
}