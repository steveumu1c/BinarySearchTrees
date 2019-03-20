package project3cmsc350;

/*In addition to the main class that defines the GUI, you should have a generic class for the binary
search tree. That class needs a method to initialize the tree,*/
public class Node<T extends Comparable<T>> { //added comparable very important
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    // Node constructor
    public Node(T data) {
        this.data = data;
    } // end constructor

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

} // end class