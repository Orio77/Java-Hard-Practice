package dataStructures.exercise3_trees.scenario3;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Decision {
    private Decision left;
    private Decision right;
    private String contents;

    public Decision(Decision left, Decision right) {
        this.left = left;
        this.right = right;
        this.contents = null;
    }

    public Decision getLeft() {
        return left;
    }



    public void setLeft(Decision left) {
        this.left = left;
    }



    public Decision getRight() {
        return right;
    }



    public void setRight(Decision right) {
        this.right = right;
    }



    public String getContents() {
        return contents;
    }



    public void setContents(String contents) {
        this.contents = contents;
    }



    public void add(Decision decisionToAdd, Decision target) {

        if (decisionToAdd == null || target == null)
            return;

        if (target.getLeft() == null)
            target.setLeft(decisionToAdd);
        if (target.getRight() == null)
            target.setRight(decisionToAdd);
        else
            System.out.println("Can not add a decision there");
    }

    public void remove(Decision root, Decision target) {

        Stack<Decision> path = getDecisionPath(root, target);
        if (path == null || path.isEmpty())
            return;
        
        Decision parent = getDecisionPath(root, target).peek();

        if (parent.getLeft().equals(target))
            parent.setLeft(null);
        if (parent.getRight().equals(target))
            parent.setRight(null);
    }

    public Decision search(Decision root, Decision target) {

        if (root == null || target == null)
            return null;

        if (root.equals(target))
            return root;

        Decision inLeft = null;
        if (root.getLeft() != null)
            inLeft = search(root.getLeft(), target);
        
        Decision inRight = null;
        if (root.getRight() != null)
            inRight = search(root.getRight(), target);

        if (inLeft.equals(target))
            return inLeft;
        else if (inRight.equals(target))
            return inRight;
        else 
            return null;
    }

    public Stack<Decision> getDecisionPath(Decision root, Decision target) {

        if (root == null || target == null)
            return null;

        Stack<Decision> path = new Stack<>();
        Set<Decision> visitedNodes = new HashSet<>();

        path.push(root);
        visitedNodes.add(root);

        while (!path.isEmpty()) {

            Decision currentDecision = path.peek();

            if (currentDecision.equals(target))
                return path;

            if (currentDecision.getLeft() != null && !visitedNodes.contains(currentDecision.getLeft())) {
                path.push(currentDecision.getLeft());
                visitedNodes.add(currentDecision.getLeft());
                continue;
            }

            if (currentDecision.getRight() != null && !visitedNodes.contains(currentDecision.getRight())) {
                path.push(currentDecision.getRight());
                visitedNodes.add(currentDecision.getRight());
                continue;
            }

            path.pop();
        }
        return null;
    }

    public void showDecisionPath(Decision root, Decision target) {
        List<Decision> reverseDecisionPath = getDecisionPath(root, target).stream().collect(Collectors.toList());
        Collections.reverse(reverseDecisionPath);
        System.out.println(reverseDecisionPath);
    }

    @Override
    public String toString() {
        return contents;
    }
}
