1. Implement a `TaskList` class using ArrayList to manage tasks.

   - Your `TaskList` class should have an `ArrayList<Task>` as a member variable. The `Task` class should have attributes like `title`, `description`, `dueDate`, `priority`, etc.
   - _Potential input_: `TaskList taskList = new TaskList();`
   - _Desired Output_: An instance of `TaskList` class.
   - _Coach Suggestions_: Start by defining the `Task` class and its attributes. Then, define the `TaskList` class with an `ArrayList<Task>` as a member variable.

2. Develop methods to add, remove, and retrieve tasks from the list.

   - Implement `addTask(Task task)`, `removeTask(Task task)`, and `getTask(int index)` methods in your `TaskList` class.
   - _Potential input_: `Task task = new Task("Title", "Description", "2022-12-31", 1); taskList.addTask(task); taskList.removeTask(task); taskList.getTask(0);`
   - _Desired Output_: The task is added to and removed from the list. The `getTask` method returns the task at the given index.
   - _Coach Suggestions_: The `addTask` and `removeTask` methods should call the `add` and `remove` methods of the `ArrayList`, respectively. The `getTask` method should call the `get` method of the `ArrayList`.

3. Enable sorting and filtering of tasks based on various criteria.

   - Implement a `sortTasks(Comparator<Task> comparator)` method that sorts the tasks using the given comparator. Also, implement a `filterTasks(Predicate<Task> predicate)` method that returns a new `TaskList` with tasks that match the given predicate.
   - _Potential input_: `taskList.sortTasks(Comparator.comparing(Task::getDueDate)); taskList.filterTasks(task -> task.getPriority() == 1);`
   - _Desired Output_: The tasks are sorted by due date. The `filterTasks` method returns a new `TaskList` with only high-priority tasks.
   - _Coach Suggestions_: The `sortTasks` method should call the `sort` method of the `ArrayList` with the given comparator. The `filterTasks` method should create a new `TaskList`, iterate over the tasks, and add any task that matches the predicate to the new list.
