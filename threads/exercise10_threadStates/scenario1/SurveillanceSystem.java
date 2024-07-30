package threads.exercise10_deadlocks.scenario1;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

class SurveillanceSystem {
    private ReentrantLock lock;

    public boolean detectDeadlock() {
        ThreadMXBean mx = ManagementFactory.getThreadMXBean();
        long[] ids = mx.getAllThreadIds();

        if (ids != null) {
            return true;
        }
        return false;
    }

    public boolean preventDeadlock() {
        boolean acquired = lock.tryLock();

        if (!acquired) {
            return false;
        }

        try {
            return true;
        } catch (Exception e) {
            
            return false;
        }
        finally {
            lock.unlock();
        }

    }

    public boolean requestResource(CustomThread thread, Resource resource) {
        synchronized(this) {
            CustomThread owner = resource.getOwner();
            if (owner == null) {
                resource.setOwner(thread);
                return true;
            }
            else if (owner.getWaitingResource() == null || owner.getWaitingResource() != resource) {
                thread.setWaitingResource(resource);
                return false;
            }
            else {
                return false;
            }
        }
    }

    public boolean releaseResource(CustomThread thread, Resource resource) {
        synchronized(this) {
            try {
                thread.setWaitingResource(null);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public void synchronizedAnalyze(Thread thread, VideoStream videoStream) {
        synchronized(this) {
            lock.lock();
            try {
                thread = new Thread(() -> {
                    if (videoStream == null) {
                        System.out.println("ViedoStream is null");
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }

    public void synchronizedAlert(Thread thread, Alert alert) {
        synchronized(this) {
            lock.lock();
            try {
                thread = new Thread(() -> {
                    alert.alert();
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

    }

    public void setPriority(Thread thread, int priority) {
        thread.setPriority(priority);
    }

    public int getPriority(Thread thread) {
        return thread.getPriority();
    }

    public void adjustPriorities() {
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();

        Thread[] threads = new Thread[currentGroup.activeCount()];
        currentGroup.enumerate(threads);

        Random random = new Random();

        for (Thread thread : threads) {
            if (thread != null) {
                if (!thread.isInterrupted()) {
                    thread.interrupt();
                }

                int newPriority = random.nextInt(Thread.MAX_PRIORITY - Thread.MIN_PRIORITY + 1) + Thread.MIN_PRIORITY;
                thread.setPriority(newPriority);

                if (!thread.isAlive()) {
                    thread.start();
                }
            }
        }
    }
}

class Resource {
    private CustomThread owner;

    public CustomThread getOwner() {
        return owner;
    }
    public void setOwner(CustomThread owner) {
        this.owner = owner;
    }
}

class CustomThread extends Thread{
    private Resource waitingResource;

    public Resource getWaitingResource() {
        return waitingResource;
    }
    public void setWaitingResource(Resource waitingResource) {
        this.waitingResource = waitingResource;
    }
}

class VideoStream {
    // VideoStream class
}

class Alert {
    
    
    public void alert() {
        System.out.println("!!!");
    }
}
