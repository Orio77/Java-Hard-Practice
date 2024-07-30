package oop.exercise18_refactoring.scenario2;

import java.util.*;
// Refactored on other computer
class NetworkDevice {
    private final String deviceId;
    private final String deviceType;
    private boolean isConnected;
    private final List<String> logs;

    public NetworkDevice(String deviceId, String deviceType) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        isConnected = false;
        logs = new ArrayList<>();
    }

    public void connect() { isConnected = true; }
    public void disconnect() { isConnected = false; }
    public void addLog(String log) { logs.add(log); }
    public String getDeviceStatus() { return isConnected ? "Connected" : "Disconnected"; }
    public List<String> getLogs() { return logs; }
    public String getDeviceId() {
        return deviceId;
    }
    public String getDeviceType() {
        return deviceType;
    }
}

class Network {
    private Map<String, NetworkDevice> devices = new HashMap<>();

    public void addDevice(NetworkDevice device) { 
        if (!handleNullDevice(device))
            return;
        
        devices.put(device.getDeviceId(), device); 
    }
    public void removeDevice(String deviceId) { 
        if (!handleNullString(deviceId))
            return;

        devices.remove(deviceId); 
    }
    public NetworkDevice getDevice(String deviceId) { 
        if (!handleNullString(deviceId))
            return null;

        return devices.get(deviceId); 
    }
    public void connectDevice(String deviceId) { 
        if (!handleNullString(deviceId))
            return;

        devices.get(deviceId).connect(); 
    }
    public void disconnectDevice(String deviceId) { 
        devices.get(deviceId).disconnect(); 
    }
    public void initializeDevice(NetworkDevice device) {
        if (!handleNullDevice(device))
            return;

        addDevice(device); 
        connectDevice(device.getDeviceId());
    }

    private boolean handleNullString(String str) {
        if (str == null || str.matches(""))
            return false;
        
        return true;
    }

    private boolean handleNullDevice(NetworkDevice device) {
        if (device == null)
            return false;
        
        return true;
    }
}

public class NetworkSystem {
    public static void main(String[] args) {
        Network network = new Network();
        NetworkDevice router = new NetworkDevice("router-01", "Router");
        network.initializeDevice(router);

        NetworkDevice switchDevice = new NetworkDevice("switch-01", "Switch");
        network.initializeDevice(switchDevice);

        System.out.println(network.getDevice("router-01").getDeviceStatus());
        network.getDevice("router-01").addLog("Connection established.");
        System.out.println(network.getDevice("router-01").getLogs());
    }
}
