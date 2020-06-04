package D_behavioral.D_iterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class A_TreeTraversal {
    public static void main(String[] args) {
        //  1
        // / \
        //2   3

        // 213

        Node<Integer> root = new Node<>(1, new Node<>(2), new Node<>(3));
        InOrderIterator<Integer> it = new InOrderIterator<>(root);

        while (it.hasNext()) {
            System.out.print("" + it.next() + ",");
        }
        System.out.println();

        BinaryTree<Integer> tree = new BinaryTree<>(root);
        for (int n : tree) {
            System.out.print("" + n + ",");
        }
        System.out.println();
    }
}

class Node<T> {
    public T value;
    public Node<T> parent, left, right;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;

        this.left.parent = this.right.parent = this;
    }
}

class InOrderIterator<T> implements Iterator<T> {

    private Node<T> current, root;
    private boolean yieldedStart;

    public InOrderIterator(Node<T> root) {
        this.root = this.current = root;

        while (current.left != null) {
            this.current = current.left;
        }
    }

    private boolean hasRightMostParent(Node<T> node) {
        if (node.parent == null) {
            return false;
        } else {
            return (node == node.parent.left) || hasRightMostParent(node.parent);
        }
    }

    @Override
    public boolean hasNext() {
        return current.left != null
                || current.right != null
                || hasRightMostParent(current);
    }

    @Override
    public T next() {
        if (!yieldedStart) {
            yieldedStart = true;
            return current.value;
        }

        if (current.right != null) {
            current = current.right;
            while (current.left != null)
                current = current.left;
            return current.value;
        } else {
            Node<T> p = current.parent;
            while (p != null && current == p.right) {
                current = p;
                p = p.parent;
            }
            current = p;
            return current.value;
        }
    }
}

class BinaryTree<T> implements Iterable<T> {

    private Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator() {
        return new InOrderIterator<>(root);
    }

    @Override
    public void forEach(Consumer<? super T> consumer) {
        for (T item : this) {
            consumer.accept(item);
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}