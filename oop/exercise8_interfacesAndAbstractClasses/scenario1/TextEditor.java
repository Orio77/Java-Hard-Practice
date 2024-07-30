package oop.exercise8_interfacesAndAbstractClasses.scenario1;

import java.util.ArrayList;

public class TextEditor {
    ArrayList<Plugin> plugins;

    public TextEditor() {
        plugins = new ArrayList<>();
    }

    public boolean addPlugin(Plugin plugin) {
        return plugins.add(plugin);
    }

    public void runPlugins() {
        for (Plugin plugin : plugins) {
            plugin.execute();
        }
    }
}
