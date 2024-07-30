package generics.exercise3_wildcards.scenario3;

public interface PluginProcessor<T> {
    
    public void process(T plugin);
}
