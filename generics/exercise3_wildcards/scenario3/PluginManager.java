package generics.exercise3_wildcards.scenario3;

import java.util.ArrayList;
import java.util.List;

public class PluginManager<T extends Plugin> implements PluginProcessor<T> {
    private List<T> plugins;
    private PluginProcessorImpl<T> processor;


    public PluginManager() {
        plugins = new ArrayList<>();
        processor = new PluginProcessorImpl<>();
    }

    public List<?> getAllData() {
        List<?> list = new ArrayList<>();

        for (Plugin plugin : plugins) {
            list.add(plugin.getData());
        }

        return list;
    }

    @Override
    public void process(T plugin) {
        processor.process(plugin);
    }

    public List<?> processAll() {
        for (T plugin : plugins) {
            process(plugin);
        }
        return getAllData();
    }
}
