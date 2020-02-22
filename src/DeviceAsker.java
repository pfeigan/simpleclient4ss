import simpleclient.Receiver;
import simpleclient.SimpleEndPoint;

public class DeviceAsker implements Receiver{
    public void callBack(String msg, SimpleEndPoint endPoint){
        System.out.println("asker start");
        PLReceiver blah = new PLReceiver();
        String devQuerry= "[\n" +
                "  {\n" +
                "    \"RequestDeviceList\": {\n" +
                "      \"Id\": 1\n" +
                "    }\n" +
                "  }\n" +
                "]\n";
        String startScan = "[\n" +
                "  {\n" +
                "    \"StartScanning\": {\n" +
                "      \"Id\": 1\n" +
                "    }\n" +
                "  }\n" +
                "]\n";
        String stopScan = "[\n" +
                "  {\n" +
                "    \"StopScanning\": {\n" +
                "      \"Id\": 1\n" +
                "    }\n" +
                "  }\n" +
                "]\n";
        System.out.println(msg);
        endPoint.setCallback(blah);
        endPoint.sendMessage(startScan);
        try {
            Thread.sleep(10000);
        }
        catch(Exception e){}
        endPoint.sendMessage(stopScan);
        endPoint.setCallback(new Vibes());
        endPoint.sendMessage(devQuerry);
        try {
            Thread.sleep(3000);
        }catch(Exception e){}
    }
    public String toString(){
        return "Device Asker";
    }
}
