**Task 1: Thread Synchronization and Inter-thread Communication**

You are given a blockchain network where each block represents a transaction. The network is represented as a list of blocks. Each block has a `transactionId` and a `verificationStatus` (initially set to `false`).

Your task is to implement two methods:

1. `verifyTransaction(int transactionId)`: This method should simulate the verification of a transaction by setting the `verificationStatus` of the block with the given `transactionId` to `true`. This operation should be synchronized to avoid race conditions.
    
2. `waitForVerification(int transactionId)`: This method should wait until the block with the given `transactionId` has been verified. It should use inter-thread communication to avoid busy waiting.
    

Example:

Blockchain network = new Blockchain();

network.addBlock(new Block(1));

network.addBlock(new Block(2));

Thread t1 = new Thread(() -> network.verifyTransaction(1));

Thread t2 = new Thread(() -> network.waitForVerification(1));

t1.start();

t2.start();

t1.join();

t2.join();

// The block with transactionId 1 should now be verified.

assert network.getBlock(1).isVerified();

**Task 2: Thread Pools and Atomic Variables**

Given the same blockchain network, your task is to implement two methods:

1. `verifyTransactions(List<Integer> transactionIds)`: This method should use a thread pool to verify multiple transactions in parallel. It should return the total number of successfully verified transactions as an atomic integer.
    
2. `getVerifiedTransactions()`: This method should return a list of all verified transactions.
    

Example:

Blockchain network = new Blockchain();

network.addBlock(new Block(1));

network.addBlock(new Block(2));

network.verifyTransactions(Arrays.asList(1, 2));

// Both transactions should now be verified.

assert network.getVerifiedTransactions().size() == 2;

**Task 3: Lock Objects and Deadlock Avoidance**

Given the same blockchain network, your task is to implement two methods:

1. `transfer(int fromTransactionId, int toTransactionId)`: This method should simulate a transfer of assets from one transaction to another. It should use lock objects to ensure that the transfer operation is atomic and deadlock-free.
    
2. `getBalance(int transactionId)`: This method should return the current balance of the given transaction.
    

Example:

Blockchain network = new Blockchain();

network.addBlock(new Block(1, 100));

network.addBlock(new Block(2, 50));

network.transfer(1, 2, 50);

// The balance of transaction 1 should now be 50.

assert network.getBalance(1) == 50;

**Task 4: Executors Framework and Fork/Join Framework**

Given the same blockchain network, your task is to implement three methods:

1. `verifyAllTransactions()`: This method should use the Executors framework to verify all transactions in the network in parallel.
    
2. `splitAndVerify(List<Integer> transactionIds)`: This method should use the Fork/Join framework to split the given list of transaction IDs into smaller tasks, verify the transactions in parallel, and combine the results.
    
3. `getVerificationStatus()`: This method should return a map with the verification status of all transactions in the network.
    

Example:

Blockchain network = new Blockchain();

network.addBlock(new Block(1));

network.addBlock(new Block(2));

network.verifyAllTransactions();

// All transactions should now be verified.

assert network.getVerificationStatus().get(1);

assert network.getVerificationStatus().get(2);