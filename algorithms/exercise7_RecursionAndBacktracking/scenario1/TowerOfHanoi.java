package algorithms.exercise7_RecursionAndBacktracking.scenario1;
// AI Copied
public class TowerOfHanoi {
    int disks;

    public TowerOfHanoi(int disks) {
        this.disks = disks;
    }

    public void moveDisk() {
        moveDiskHelper(disks, 'A', 'B', 'C');
    }

    public void moveDiskHelper(int n, char from, char auxiliary, char to) {
        if (n == 1) {
            System.out.println("Move disk 1 from peg " + from + " to peg " + to);
            return;
        }

        moveDiskHelper(n - 1, from, to, auxiliary);
        System.out.println("Move disk " + n + " from peg " + from + " to peg " + to);
        moveDiskHelper(n - 1, auxiliary, from, to);
    }
}
