package streamAPI.exercise14_streamOrdering.scenario1;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

public class FinanceDepartment {
    private List<Database> databases;
    private Stack<Error> errorLog;

    public List<Transaction> sortByDate() {
        return databases.stream().flatMap(database -> database.getTransactions().stream()).sorted(Comparator.comparing(Transaction::getDate)).toList();
    }

    public List<Transaction> processTransactions() {
        return databases.stream().flatMap(database -> {
            try {
                return database.getTransactions().stream();
            } catch (Error e) {
                errorLog.push(e);
                return Stream.empty();
            }
        })
        .sorted((t1, t2) -> {
            if (t1.getDate() == null) return -1;
            if (t2.getDate() == null) return -1;
            return t1.getDate().compareTo(t2.getDate());
        })
        .toList();
    }

    public Collection<Transaction> optimizedProcessTransactions() {
        Transaction[] transactionArray = (Transaction[]) databases.parallelStream().flatMap(database -> {
            try {
                return database.getTransactions().stream();
            } catch (Error e) {
                errorLog.push(e);
                return Stream.empty();
            }
        })
        .toArray();

        // AI Helped
        Arrays.parallelSort(transactionArray, Comparator.comparing(Transaction::getDate, Comparator.nullsLast(Comparator.naturalOrder())));

        return Arrays.stream(transactionArray).collect(Collectors.toCollection(ConcurrentLinkedQueue::new));
    }

    // AI Helped
    public List<Transaction> persistentTransactionsProcessing(int persistance) {
        return databases.stream().flatMap(database -> {
            for (int attempt = 0; attempt < persistance; attempt++) {
                try {
                    return database.getTransactions().stream();
                } catch (Error e) {
                    if (attempt == persistance - 1) {
                        errorLog.push(e);
                    }
                }
            }
            return Stream.empty();
        })
        .sorted((t1, t2) -> {
            LocalDateTime date1 = null;
            LocalDateTime date2 = null;
            for (int attempt = 0; attempt < persistance; attempt++) {
                try {
                    date1 = t1.getDate();
                    date2 = t2.getDate();
                    break;
                } catch (Error e) {
                    if (attempt == persistance - 1) {
                        errorLog.push(e);
                        return -1;
                    }
                }
            }
            if (date1 == null) return -1;
            if (date2 == null) return 1;
            return date1.compareTo(date2);
        })
        .toList();
    }
}
