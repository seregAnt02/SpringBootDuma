import java.io.IOException;
import java.net.Socket;

public class structure {

    class Message{
        public String getName(){ return "name"; }

        public String getToName() { return "toName"; }

        public String getMassage() { return "massage"; }

        }

    class Server{
        public void runServer(){}

        void closeSocket(){}
    }

    class RunServer{
        public static void main(){}
    }

    class RunClient{
        public static void main(){}
    }

    class Client{
        public void sendMessage(){}

        private void modelSerializable(Message modelMessage){}

        public void listenForMessage(){}

        private void closeEverything(Socket socket){}
    }

    class ClientManager implements Runnable{
        @Override
        public void run() {

        }

        private Message modelDeserialization() throws IOException, ClassNotFoundException{
            return new Message();
        }

        private void modelSerializable() throws IOException{}

        private String[] parsMessage(String massageToSend){
            return new String[8];
        }

        private void sendMessageToClient(Message message){}

        private void sendMessageToAll(Message message){}

        private void closeEverything(){}

        public void removeClient(){}
    }
}
