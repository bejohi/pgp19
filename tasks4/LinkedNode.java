public class LinkedNode<E extends Comparable> {


    private Node root;

    private class Node<E extends Comparable> {

        private E item;      // reference to the item stored at this node
        private Node<E> nextNode;    // reference to the subsequent node in the list

        private Node() {
            this(null, null);
        }

        private Node(E element, Node<E> next) {
            item = element;   // creates a node with the given item
            nextNode = next;  // and next mode.
        }

        public E getElement( ) { return item; } // Accessor methods
        public Node<E> getNextNode( ) { return nextNode; }
        public void setElement (E element) { this.item = element; }
        public void setNextNode(Node<E> Node) { this.nextNode = Node; }
    }

    public LinkedNode() {
        //TODO: your implementation of constructor goes here

    }

    public void insert(E item) {
        Node currentNode = this.root;
        if(currentNode == null){
            this.root = new Node(item,null);
            return;
        }
        while(currentNode.getNextNode() != null){
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(new Node(item,null));

    }

    public boolean contains(E item) {
        Node currentNode = this.root;
        while(currentNode != null){
            if(currentNode.getElement().compareTo(item) == 0){
                return true;
            }
            currentNode = currentNode.getNextNode();

        }
        return false;
    }

    public int getLength() {
        Node currentNode = this.root;
        int counter = 0;
        while(currentNode != null){
            counter++;
            currentNode = currentNode.getNextNode();

        }
        return counter;
    }

    public String toString() {
        Node currentNode = this.root;
        StringBuilder resultString = new StringBuilder();
        while(currentNode != null){
            resultString.append(currentNode.getElement() + "|");
            currentNode = currentNode.getNextNode();
        }
        return resultString.toString();
    }


    public static void main(String[] Args)
    {
        LinkedNode<Integer> nodeList = new LinkedNode<>();
        assert nodeList.getLength() == 0;
        nodeList.insert(1);
        nodeList.insert(2);
        nodeList.insert(3);
        assert nodeList.getLength() == 3;
        assert nodeList.contains(2);
        assert !nodeList.contains(0);
        assert nodeList.toString().equals("1|2|3|");
    }
}
