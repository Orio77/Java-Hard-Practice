1. Design an interface for plugin modules with methods for integration.

   - Your `Plugin` interface should have methods like `initialize()`, `execute()`, and `terminate()`. These methods will be called when the plugin is loaded, run, and unloaded, respectively.
   - _Potential input_: `public interface Plugin { void initialize(); void execute(); void terminate(); }`
   - _Desired Output_: An interface named `Plugin` with the specified methods.
   - _Coach Suggestions_: Start by defining the `Plugin` interface and its methods. These methods should not have a body, as they will be implemented by the classes that implement the interface.

2. Implement concrete plugin classes that adhere to the interface.

   - Create classes like `SpellCheckPlugin`, `AutoCompletePlugin`, etc., each implementing the `Plugin` interface. Implement the methods in each class to provide the desired functionality.
   - _Potential input_: `public class SpellCheckPlugin implements Plugin { /* implement methods here */ }`
   - _Desired Output_: Classes that implement the `Plugin` interface and provide the functionality of each plugin.
   - _Coach Suggestions_: Define each class and make it implement the `Plugin` interface. In each class, implement the `initialize`, `execute`, and `terminate` methods to provide the functionality of the plugin.

3. Allow users to extend the text editor's functionality by adding plugins.

   - In your `TextEditor` class, implement a `addPlugin(Plugin plugin)` method that adds the plugin to a list of plugins. Also, implement a `runPlugins()` method that calls the `execute` method of each plugin in the list.
   - _Potential input_: `TextEditor editor = new TextEditor(); editor.addPlugin(new SpellCheckPlugin()); editor.runPlugins();`
   - _Desired Output_: The plugins are added to the text editor and their `execute` methods are called.
   - _Coach Suggestions_: In the `TextEditor` class, define a `List<Plugin>` to store the plugins. The `addPlugin` method should add the plugin to this list. The `runPlugins` method should iterate over the list and call the `execute` method of each plugin.
