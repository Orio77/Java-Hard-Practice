package threads.exercise11_deadlocks.scenario3;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Block {
    private final int transactionId;
    private boolean verificationStatus;
    private double balance;

    public Block(int transactionId) {
        this.transactionId = transactionId;
        verificationStatus = false;
    }

    public void setVerificationStatus(boolean verificationStatus) {
        this.verificationStatus = verificationStatus;
    }
    public boolean getVerificationStatus() {
        return verificationStatus;
    }
    public int getTransactionId() {
        return transactionId;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class Blockchain {
    private List<Block> blocks;

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public void verifyTransaction(int transactionId) {
        synchronized(blocks) {
            blocks.get(transactionId).setVerificationStatus(true);
        }
    }

    public void waitForVerification(int transactionId) {
        synchronized(blocks) {
            try {
                while (!blocks.get(transactionId).getVerificationStatus()) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public AtomicInteger verifyTransactions(List<Integer> transactionIds) {
        AtomicInteger verified = new AtomicInteger(0);

        transactionIds.parallelStream().forEach(id -> {
            if (blocks.get(id).getVerificationStatus()) {
                verified.incrementAndGet();
            }
        });

        return verified;
    }

    public List<Integer> getVerifiedTransactions() {
        return blocks.parallelStream().filter(transaction -> transaction.getVerificationStatus()).map(Block::getTransactionId).toList();
    }

    public void transfer(int fromTransactionId, int toTransactionId) {
        synchronized(blocks) {
            double transfer = blocks.get(fromTransactionId).getBalance();
            blocks.get(toTransactionId).setBalance(blocks.get(toTransactionId).getBalance() + transfer);
        }
    }

    public double getBalance(int transactionId) {
        synchronized(blocks) {
            return blocks.get(transactionId).getBalance();
        }
    }

    public void verifyAllTransactions() {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (Block block : blocks) {
            executor.submit(() -> {
                block.setVerificationStatus(true);
            });
        }
    }

    public Future<Map<String, Boolean>> splitAndVerify(List<Integer> transactionIds) {
        ForkJoinPool pool = new ForkJoinPool();
        return pool.submit(() -> {
                return transactionIds.parallelStream().collect(Collectors.toMap(id -> String.valueOf(id), id -> blocks.get(id).getVerificationStatus()));
            });
    }

    public Map<Block, Boolean> getVerificationStatus() {
        return blocks.parallelStream().collect(Collectors.toMap(block -> block, Block::getVerificationStatus));
    }
}
