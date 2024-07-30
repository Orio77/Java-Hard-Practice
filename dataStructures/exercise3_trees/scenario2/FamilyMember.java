package dataStructures.exercise3_trees.scenario2;

import java.util.ArrayList;
import java.util.LinkedList;

public class FamilyMember {
    private FamilyMember left;
    private FamilyMember right;
    private FamilyMember parent;
    private String name;
    
    public FamilyMember(String name) {
        this.name = name;
    }

    public FamilyMember getLeft() {
        return left;
    }

    public void setLeft(FamilyMember left) {
        this.left = left;
    }

    public FamilyMember getRight() {
        return right;
    }

    public void setRight(FamilyMember right) {
        this.right = right;
    }

    public FamilyMember getParent() {
        return parent;
    }

    public void setParent(FamilyMember parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(FamilyMember familyMember) {

        if (left == null)
            this.setLeft(familyMember);
        
        if (right == null)
            this.setRight(familyMember);
        else {
            System.out.println("This family member has 2 children already!");
            return;
        }

        familyMember.setParent(this);
    }

    public void remove(FamilyMember familyMember) {

        if (familyMember == null)
            return;

        if (familyMember.getParent() == null && familyMember.getLeft() == null && familyMember.getRight() == null) {
            familyMember = null;
            return;
        }

        if (familyMember.getParent().getLeft().equals(familyMember)) {
            familyMember.getParent().setLeft(null);
            familyMember.setParent(null);
        }
        if (familyMember.getParent().getRight().equals(familyMember)) {
            familyMember.getParent().setRight(null);
            familyMember.setParent(null);
        }

        remove(familyMember.getLeft());
        remove(familyMember.getRight());
    }

    public void showImmediateFamilyMembers(FamilyMember familyMember) {

        if (familyMember == null)
            return;

        if (familyMember.getParent() != null) {
            System.out.print("Parent: " + familyMember.getParent());
        }

        if (familyMember.getLeft() != null) 
            System.out.println("First child: " + familyMember.getLeft());

        if (familyMember.getRight() != null)
            System.out.println("Second child: " + familyMember.getRight());
    }

    public FamilyMember findFamilyMember(FamilyMember root, FamilyMember target) { // 7 mins

        if (root == null || target == null)
            return null;

        if (root.equals(target))
            return root;

        FamilyMember foundLeft = findFamilyMember(root.getLeft(), target);
        FamilyMember foundRight = findFamilyMember(root.getRight(), target);
        
        if (foundLeft == target)
            return foundLeft;
        if (foundRight == target)
            return foundRight;
        else
            return null;
    }


    public ArrayList<ArrayList<FamilyMember>> showGenerationHelper(FamilyMember root, int number) { // 30 mins answer(20)
        ArrayList<ArrayList<FamilyMember>> generationMemberList = new ArrayList<>();
        LinkedList<FamilyMember> toVisitList = new LinkedList<>();
        
        if (root != null)
            toVisitList.add(root);

        while (!toVisitList.isEmpty() && generationMemberList.size() < number) {
            ArrayList<FamilyMember> currentGeneration = new ArrayList<>();
            int size = toVisitList.size();

            for (int i = 0; i < size; i++) {
                FamilyMember current = toVisitList.poll();
                currentGeneration.add(current);

                if (current.getLeft() != null)
                    toVisitList.add(current.getLeft());
                if (current.getRight() != null)
                    toVisitList.add(current.getRight());
            }
            generationMemberList.add(currentGeneration);
        }
        return generationMemberList;
    }

    @Override
    public String toString() {
        return name;
    }

}
