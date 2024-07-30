package dataStructures.exercise6_recursion.scenario2;
// AI Guided and AI Copied (manually)
public class DocumentBase {
    Document drive;
    Document left;
    Document right;

    public DocumentBase() {
        left = null;
        right = null;
        this.drive = new Document(100, "drive");
    }

    public class Document {
        Document left;
        Document right;
        int height;
        int key;
        String content;

        public Document(int key, String content) {
            this.key = key;
            this.content = content;
            left = null;
            right = null;
            height = 0;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Document getLeft() {
            return left;
        }

        public void setLeft(Document left) {
            this.left = left;
        }

        public Document getRight() {
            return right;
        }

        public void setRight(Document right) {
            this.right = right;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int calculateHeight(Document doc) {
            if (doc == null)
                return -1;
            
            return doc.getHeight();
        }

        public int calculateBalance() {
            if (left == null && right == null)
                return 0;

            int leftHeight = (left == null) ? -1 : left.getHeight();
            int rightHeight = (right == null) ? -1 : right.getHeight();

            return leftHeight - rightHeight;
        }

        public void updateHeight() {
            int leftHeight = (left == null) ? -1 : left.getHeight();
            int rightHeight = (right == null) ? -1 : right.getHeight();

            height = Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public void setDrive(Document drive) {
        this.drive = drive;
    }

    public Document getDrive() {
        return drive;
    }

    public Document rotateLeft(Document doc) {
        Document newDoc = doc.getRight();
        Document lowerDoc = newDoc.getLeft();
        newDoc.setLeft(doc);
        doc.setRight(lowerDoc);

        doc.updateHeight();
        newDoc.updateHeight();

        return doc;
    }

    public Document rotateRight(Document doc) {
        Document newDoc = doc.getLeft();
        Document lowerDoc = newDoc.getRight();
        newDoc.setRight(doc);
        doc.setLeft(lowerDoc);

        doc.updateHeight();
        newDoc.updateHeight();

        return doc;
    }

    public void insert(Document doc) {
        drive = insertHelper(drive, doc);
    }

    private Document insertHelper(Document doc, Document newDoc) {
        if (doc == null) {
            return newDoc;
        }

        if (newDoc.getKey() < doc.getKey()) {
            doc.setLeft(insertHelper(doc.getLeft(), newDoc));
        }
        else if (newDoc.getKey() > doc.getKey()) {
            doc.setRight(insertHelper(doc.getRight(), newDoc));
        }
        else {
            return doc;
        }

        doc.updateHeight();
        int balance = doc.calculateBalance();

        if (balance > 1) {
            if (newDoc.getKey() > doc.getLeft().getKey()) {
                return rotateRight(doc);
            }
            if (newDoc.getKey() < doc.getLeft().getKey()) {
                doc.setLeft(rotateRight(doc.getLeft()));
                return rotateRight(doc);
            }
        }

        if (balance < -1) {
            if (newDoc.getKey() < doc.getRight().getKey()) {
                return rotateLeft(doc);
            }
            if (newDoc.getKey() > doc.getRight().getKey()) {
                doc.setRight(rotateLeft(doc.getRight()));
                doc.updateHeight();
                doc.calculateBalance();
                return rotateLeft(doc);
            }
        }
        return doc;
    }
    public void delete(Document doc) {
        if (doc == null)
            return;

        drive = deleteHelper(drive, doc.getKey());
    }

    private Document deleteHelper(Document doc, int key) {
        if (doc == null)
            return doc;

        if (key < doc.getKey()) {
            doc.setLeft(deleteHelper(doc.getLeft(), key));
        }
        else if (key > doc.getKey()) {
            doc.setRight(deleteHelper(doc.getRight(), key));
        }
        else {
            if (doc.getLeft() == null || doc.getRight() == null) {
                Document temp = null;
                if (temp == doc.getLeft())
                    temp = doc.getRight();
                else
                    temp = doc.getLeft();

                if (temp == null)
                    doc = null;
                else
                    doc = temp;
            }
            else {
                Document temp = minValueNode(doc.getRight());
                doc.setKey(temp.getKey());
                doc.setRight(deleteHelper(doc.getRight(), temp.getKey()));
            }
        }

            if (doc == null)
                return doc;

            doc.updateHeight();
            int balance = doc.calculateBalance();

            if (balance > 1) {
                if (doc.getLeft().calculateBalance() >= 0)
                    return rotateRight(doc);
                if (doc.getLeft().calculateBalance() < 0) {
                    doc.setLeft(rotateLeft(doc.getLeft()));
                    return rotateRight(doc);
                }
            }

            if (balance < -1) {
                if (doc.getRight().calculateBalance() >= 0) 
                    return rotateLeft(doc);
                if (doc.getRight().calculateBalance() < 0) {
                    doc.setRight(rotateRight(doc.getRight()));
                    return rotateLeft(doc);
                }
            }
            return doc;
        }

    private Document minValueNode(Document doc) {
        Document currentDoc = doc;
        while (currentDoc.getLeft() != null) {
            currentDoc = currentDoc.getLeft();
        }
        return currentDoc;
    }

    public void inOrderTraversal() {
        inOrderHelper(drive);
    }

    private void inOrderHelper(Document doc) {
        if (doc != null) {
            inOrderHelper(doc.getLeft());
            System.out.println(doc.getContent());
            inOrderHelper(doc.getRight());
        }
    }

    public void preOrderTraversal() {
        preOrderHelper(drive);
    }

    private void preOrderHelper(Document doc) {
        if (doc != null) {
            System.out.println(doc.getContent());
            preOrderHelper(doc.getLeft());
            preOrderHelper(doc.getRight());
        }
    }

    public void postOrderTraversal() {
        postOrderHelper(drive);
    }

    private void postOrderHelper(Document doc) {
        if (doc != null) {
            postOrderHelper(doc.getLeft());
            postOrderHelper(doc.getRight());
            System.out.println(doc.getContent());
        }
    }

    public void generateDocumentsForTests(int number) {
        Document doc = null;
        for (int i = 0; i < number; i++) {
            doc = new Document((int)(Math.random() * 1000), "");
            doc.setContent(i + " doc with " + i + " much content");
            insert(doc);
        }
    }
}

