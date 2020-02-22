package simpleclient;

@FunctionalInterface
public interface Receiver {
    public void callBack(String message, SimpleEndPoint endPoint);
}
