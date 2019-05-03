import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

class BinaryTree<T> {
    private T _value;
    private BinaryTree<T> _left;
    private BinaryTree<T> _right;

    public BinaryTree(T value) {
        this._value = value;
    }

    public BinaryTree<T> getLeft() {
        return this._left;
    }

    public BinaryTree<T> getRight() {
        return this._right;
    }

    public BinaryTree<T> setLeft(BinaryTree<T> node) {
        this._left = node;
        return node;
    }

    public BinaryTree<T> setRight(BinaryTree<T> node) {
        this._right = node;
        return node;
    }

    public T getValue() {
        return this._value;
    }

    public T setValue(T value) {
        this._value = value;
        return value;
    }

    public Iterator<T> iterate(Iterable<T> iter) {
        return iter.iterator();
    }
}

class Main {
    public static void main(String []args) {
        BinaryTree<Integer> root = new BinaryTree<Integer>(1);

        root.setLeft(new BinaryTree<Integer>(2));
        root.setRight(new BinaryTree<Integer>(3));

        // Your implementation should be able to perform a for each with the given syntax
        for(int item: new InorderIterable<Integer>(root)) {
            System.out.println(item);
        }
    }
}

class InorderIterable<T> implements Iterable<T>{

    private BinaryTree<T> root;
    public InorderIterable(BinaryTree<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Queue<BinaryTree<T>> iteratorQueue = inorderTravers();
            @Override
            public boolean hasNext() {
                return !iteratorQueue.isEmpty();
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                return iteratorQueue.poll().getValue();
            }
        };
    }

    /**
     *  Performs the Inorder Traversal method on the tree and returns a Queue with the correct order
     *  of elements.
     */
    private Queue<BinaryTree<T>> inorderTravers(){
        Stack<BinaryTree<T>> stack = new Stack<>();
        Queue<BinaryTree<T>> resultQueue = new LinkedBlockingQueue<>();
        BinaryTree<T> node = this.root;
        while(!stack.empty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.getLeft();
                continue;
            }
            node = stack.pop();
            resultQueue.add(node);
            node = node.getRight();
        }
        return resultQueue;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        inorderTravers().forEach(element -> action.accept(element.getValue()));
    }

}

class PreorderIterable<T> implements Iterable<T>{

    private BinaryTree<T> root;
    public PreorderIterable(BinaryTree<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Queue<BinaryTree<T>> iteratorQueue = preorderTravers();

            @Override
            public boolean hasNext() {
                return !iteratorQueue.isEmpty();
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                return iteratorQueue.poll().getValue();
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        preorderTravers().forEach(element -> action.accept(element.getValue()));
    }

    /**
     *  Performs the Preorder Traversal method on the tree and returns a Queue with the correct order
     *  of elements.
     */
    private Queue<BinaryTree<T>> preorderTravers(){
        Stack<BinaryTree<T>> stack = new Stack<>();
        Queue<BinaryTree<T>> resultQueue = new LinkedBlockingQueue<>();
        BinaryTree<T> node = this.root;
        stack.push(node);
        while(!stack.empty()){
            node = stack.pop();
            resultQueue.add(node);
            if(node.getRight() != null){
                stack.push(node.getRight());
            }
            if(node.getLeft() != null){
                stack.push(node.getLeft());
            }
        }
        return resultQueue;
    }
}

// TESTS.

@SuppressWarnings("Duplicates")
class InorderIterableTests{
    @Test
    public void foreach_treeHasOnlyElements_OnlyOneActionPerformed(){
        // Arrange
        BinaryTree<String> tree = new BinaryTree<>("A");
        StringBuilder checkString = new StringBuilder();

        // Act
        new InorderIterable<String>(tree).forEach(element -> checkString.append(element));

        // Assert
        Assertions.assertEquals("A", checkString.toString());
    }

    @Test
    public void foreach_treeHasALotOfElements_AllActionsPerformedInCorrectOrder(){
        // Arrange
        BinaryTree<String> tree = new BinaryTree<>("C");
        tree.setLeft(new BinaryTree<>("B"));
        tree.getLeft().setLeft(new BinaryTree<>("A"));
        tree.setRight(new BinaryTree<>("D"));

        StringBuilder checkString = new StringBuilder();

        // Act
        new InorderIterable<String>(tree).forEach(element -> checkString.append(element));

        // Assert
        Assertions.assertEquals("ABCD",checkString.toString());
    }

    @Test
    public void iterator_TreeHasSomeElements_AllElementsAreCalledOnce(){
        // Arrange
        BinaryTree<String> tree = new BinaryTree<>("C");
        tree.setLeft(new BinaryTree<>("B"));
        tree.getLeft().setLeft(new BinaryTree<>("A"));
        tree.setRight(new BinaryTree<>("D"));

        StringBuilder checkString = new StringBuilder();

        // Act
        for (String s : new InorderIterable<String>(tree)) {
            checkString.append(s);
        }

        // Assert
        Assertions.assertEquals("ABCD",checkString.toString());
    }
}

@SuppressWarnings("Duplicates")
class PreorderIterableTests{
    @Test
    public void foreach_treeHasOnlyElements_OnlyOneActionPerformed(){
        // Arrange
        BinaryTree<String> tree = new BinaryTree<>("A");
        StringBuilder checkString = new StringBuilder();

        // Act
        new PreorderIterable<String>(tree).forEach(element -> checkString.append(element));

        // Assert
        Assertions.assertEquals("A", checkString.toString());
    }

    @Test
    public void foreach_treeHasALotOfElements_AllActionsPerformedInCorrectOrder(){
        // Arrange
        BinaryTree<String> tree = new BinaryTree<>("A");
        tree.setLeft(new BinaryTree<>("B"));
        tree.getLeft().setLeft(new BinaryTree<>("C"));
        tree.setRight(new BinaryTree<>("D"));

        StringBuilder checkString = new StringBuilder();

        // Act
        new PreorderIterable<String>(tree).forEach(element -> checkString.append(element));

        // Assert
        Assertions.assertEquals("ABCD",checkString.toString());
    }

    @Test
    public void iterator_TreeHasSomeElements_AllElementsAreCalledOnce(){
        // Arrange
        BinaryTree<String> tree = new BinaryTree<>("A");
        tree.setLeft(new BinaryTree<>("B"));
        tree.getLeft().setLeft(new BinaryTree<>("C"));
        tree.setRight(new BinaryTree<>("D"));

        StringBuilder checkString = new StringBuilder();

        // Act
        for (String s : new PreorderIterable<String>(tree)) {
            checkString.append(s);
        }

        // Assert
        Assertions.assertEquals("ABCD",checkString.toString());
    }
}