package dataStructures.exercise6_recursion.scenario1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class Room {
    private LinkedList<Room> rooms;
    String name;

    public Room() {
        rooms = new LinkedList<>();
    }

    // AI help
    public Stack<Room> findExitPath(Room entryRoom) {

        if (entryRoom == null) 
            return null;

        Stack<Room> path = new Stack<>();
        Set<Room> visitedRooms = new HashSet<>();

        while (!path.isEmpty()) {
            Room currentRoom = path.peek();
            boolean roomAdded = false;

            for (Room room : currentRoom.getRooms()) {
                if (!visitedRooms.contains(room)) {
                    path.push(room);
                    visitedRooms.add(room);
                    roomAdded = true;
                    break;
                }
            }

            if (!roomAdded)
                path.pop();
        }
        return path;
    }

    // AI help
    public LinkedHashSet<Room> findShortestPath(Room entryRoom, LinkedHashSet<Room> path) {

        if (entryRoom == null)
            return null;

        LinkedHashSet<Room> winnerPath = new LinkedHashSet<>();
        path.add(entryRoom);

        if (entryRoom.getName().matches("Exit")) {
            if (winnerPath.isEmpty() || path.size() < winnerPath.size())
                winnerPath = new LinkedHashSet<>(path);
        }
        else {
            for (Room room : entryRoom.getRooms()) {
                if (!path.contains(room)) {
                    LinkedHashSet<Room> newPath = new LinkedHashSet<>();
                    LinkedHashSet<Room> resultPath = findShortestPath(room, newPath);
                    if (!resultPath.isEmpty() && (winnerPath.isEmpty() || resultPath.size() < winnerPath.size()))
                        winnerPath = resultPath;
                }
            }
        }
        return winnerPath;
    }

    // AI generated (starting to learn the BFS)
    public LinkedList<Room> shortestPathBFS(Room entryRoom) {
        if (entryRoom == null)
            return null;

        LinkedList<LinkedList<Room>> queue = new LinkedList<>();
        Set<Room> visitedRooms = new HashSet<>();

        LinkedList<Room> startPath = new LinkedList<>();
        startPath.add(entryRoom);
        queue.add(startPath);
        visitedRooms.add(entryRoom);

        while (!queue.isEmpty()) {
            LinkedList<Room> path = queue.poll();
            Room lastRoomInPath = path.getLast();

            if (lastRoomInPath.getName().matches("Exit"))
                return path;

            for (Room room : lastRoomInPath.getRooms()) {
                if (!visitedRooms.contains(room)) {
                    LinkedList<Room> newPath = new LinkedList<>(path);
                    newPath.add(room);
                    queue.add(newPath);
                    visitedRooms.add(room);
                }
            }
        }
        return null;
    }

    

    public LinkedList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(LinkedList<Room> rooms) {
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



// My try:

/*    public Stack<Room> findExitPath(Room entryRoom) {

        if (entryRoom == null)
            return null;

        Stack<Room> path = new Stack<>();
        Set<Room> visitedRooms = new HashSet<>();
        LinkedList<Integer> indices = new LinkedList<>();

        path.add(entryRoom);
        visitedRooms.add(entryRoom);

        while (!path.isEmpty()) {

            for (int i = 0; i < entryRoom.getRooms().size(); i++) {
                indices.add(Integer.valueOf(0));
            }
            int count = 0;
            int value = indices.get(count);
            Room currentRoom = path.peek().getRooms().get(indices.get(count));

            if (currentRoom != null && !visitedRooms.contains(currentRoom)) {
                path.add(currentRoom);
                visitedRooms.add(currentRoom);
                value++;
                indices.set(count, value);
            }

            if (currentRoom == null || visitedRooms.contains(currentRoom))
            path.pop();
        }

        return path;
    } */