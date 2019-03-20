package project3cmsc350;

/*one that allows a new value to be
inserted in the tree and one that performs an inorder tree traversal that generates and returns a
string that contains the tree elements in sorted order. one that allows a new value to be
inserted in the tree and one that performs an inorder tree traversal that generates and returns a
string that contains the tree elements in sorted order.*/
public class BinarySearchTree <T extends Comparable<T>> {
    private Node root;
    private StringBuilder textOutput = new StringBuilder();
	/*
	 * private T data; private BinarySearchTree<T> leftChild; // Reference to left
	 * child private BinarySearchTree<T> rightChild; // Reference to right child
	 */    // constructor of root node
	
	public BinarySearchTree() { 
		  root = null; }
	 
    
//recursive insert needs base case established, in this case the incoming data
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);//see Node class no need for key
        } else {
            //try to insert new node using recursion
            insert(root, data);//this calls the next insert method
        }
    }
    //insert method to insert node in binary search tree
    private Node insert(Node node, T data) {
        //base condition of the recursive method
        if(node == null) {
            return new Node<>(data);
        }

        if (node.getData().compareTo(data) > 0) {
            node.setLeftChild(insert(node.getLeftChild(), data));
        } else {
            node.setRightChild(insert(node.getRightChild(), data));
        }
        return node;
    }


    // method for in order traverse of binary search tree
    // used for ascending order Note this will take fractions without separate method!
    public StringBuilder Ascending( Node node) {
        if (node != null) {
            Ascending( node.getLeftChild());
            textOutput.append(node.getData().toString()).append(" ");
            Ascending( node.getRightChild());
        } // end if
        return textOutput;
    } // end method

    // method for reverse order traverse of binary search tree
    // used for descending order
    public StringBuilder Descending( Node node) {
        if (node != null) {
            Descending( node.getRightChild());
            textOutput.append(node.getData().toString()).append(" ");
            Descending( node.getLeftChild());
        } // end if
        return textOutput;
    } // end method

    public Node getRoot() {
        return root;
    }
}
