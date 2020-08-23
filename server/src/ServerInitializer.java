import service.impl.ServiceFactoryImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerInitializer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(5050);
            registry.rebind("cmjd83", ServiceFactoryImpl.getInstance());
            System.out.println("Server Started on port 5050");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}