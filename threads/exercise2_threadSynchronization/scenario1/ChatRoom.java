package threads.exercise2_threadSynchronization.scenario1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
// AI Guided & AI Copied
class ChatRoom {
    private Queue<String> messages;
    private ReentrantLock lock;
    private Condition condition;

    public ChatRoom() {
        this.messages = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    void sendMessage(String message) {
        try {
            lock.lock();
            messages.add(message);
        } finally {
            lock.unlock();
        }
    }

    String receiveMessage() {
        lock.lock();
        try {
            while (messages.isEmpty()) {
                condition.await();
            }
            return messages.poll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } finally {
            lock.unlock();
        }
    }
}

class User {
    private String name;
    private ChatRoom currentChatRoom;
    private ReentrantLock lock;

    public User(String name) {
        this.name = name;
        this.currentChatRoom = null;
        this.lock = new ReentrantLock();
    }

    public String getName() {
        return name;
    }

    void enterChatRoom(ChatRoom chatRoom) {
        lock.lock();
        try {
            if (currentChatRoom != null) {
                leaveChatRoom();
            }
    
            currentChatRoom = chatRoom;
        } finally {
            lock.unlock();
        }
    }

    void leaveChatRoom() {
        lock.lock();
        try {
            currentChatRoom = null;
        } finally {
            lock.unlock();
        }
    }
}

class UserContext {
    private ThreadLocal<User> userThreadLocal;

    public UserContext() {
        this.userThreadLocal = new ThreadLocal<>();
    }

    void setUserContext(User user) {
        userThreadLocal.set(user);
    }

    User getUserContext() {
        return userThreadLocal.get();
    }
}

class ChatRoomManager {
    private Map<String, ChatRoom> chatRooms;
    private ExecutorService executorService;
    private ReentrantLock lock;

    public ChatRoomManager() {
        this.chatRooms = new HashMap<>();
        this.executorService = Executors.newFixedThreadPool(10);
        this.lock = new ReentrantLock();
    }

    void createChatRoom(String chatRoomName) {
        executorService.submit(() -> {
            lock.lock();
            try {
                chatRooms.put(chatRoomName, new ChatRoom());
            } finally {
                lock.unlock();
            }
        });
    }

    void deleteChatRoom(String chatRoomName) {
        executorService.submit(() -> {
            lock.lock();
            try {
                if (chatRooms.containsKey(chatRoomName)) {
                    chatRooms.remove(chatRoomName);
                }
            } finally {
                lock.unlock();
            }
        });
    }

    Future<List<String>> listChatRooms() {
        return executorService.submit(() -> {
            lock.lock();
        try {
            return chatRooms.keySet().stream().toList();
        } finally {
            lock.unlock();
        }
        });
    }
}
