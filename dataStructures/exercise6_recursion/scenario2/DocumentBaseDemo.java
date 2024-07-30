package dataStructures.exercise6_recursion.scenario2;

public class DocumentBaseDemo {
    public static void main(String[] args) {
        
        DocumentBase docBase = new DocumentBase();
        System.out.println(docBase.getDrive());

        docBase.generateDocumentsForTests(100);
        docBase.inOrderTraversal();
        docBase.postOrderTraversal();
        docBase.preOrderTraversal();
    }
}
