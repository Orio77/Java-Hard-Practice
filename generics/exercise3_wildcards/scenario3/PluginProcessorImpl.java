package generics.exercise3_wildcards.scenario3;

public class PluginProcessorImpl<T extends Plugin> implements PluginProcessor<T> {
    
    @Override
    public void process(T plugin) {
        System.out.println("Retrieving data from the plugin");
        System.out.println("Data: " + plugin.getData());
    }
}
