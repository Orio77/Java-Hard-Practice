package algorithms.exercise3_dataStructures.scenario2;

public class NetworkDemo {
    public static void main(String[] args) {
        Network net = new Network();

        net.simulateUserBase(10);
        net.showNetwork(net.getUserBase().get(0));
    }
}
