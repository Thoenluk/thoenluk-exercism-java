
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



class BinarySearchTree<T extends Comparable<T>> {
    Node root;
    
    void insert(T value) {
        if(null == root) {
            root = new Node(value);
        } else {
            root.insert(value);
        }
    }

    List<T> getAsSortedList() {
        // The diligent coder would implement a stack-based algorithm which always
        // processes left followed by parent followed by right, recursively.
        // The efficient coder just gets all elements and sorts the list.
        // This is barely less efficient by the way. Both approaches would visit each
        // node twice for O(2n), this just adds a negligible log2(n) for the sorting.
        List<T> result = getAsLevelOrderList();
        result.sort(null);
        return result;
    }

    List<T> getAsLevelOrderList() {
        LinkedList<T> values = new LinkedList<>();
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(root);
        Node<T> current;
        while(!nodes.isEmpty()) {
            current = nodes.pop();
            values.add(current.getData());
            if(null != current.getLeft()) {
                nodes.add(current.getLeft());
            }
            if(null != current.getRight()) {
                nodes.add(current.getRight());
            }
        }
        return values;
    }

    Node<T> getRoot() {
        return root;
    }

    static class Node<T extends Comparable<T>> {
        private Node left, right;
        private final T data;
        
        Node(T data) {
            this.data = data;
        }

        Node<T> getLeft() {
            return left;
        }

        Node<T> getRight() {
            return right;
        }

        T getData() {
            return data;
        }

        void insert(T content) {
            switch(content.compareTo(data) / Math.abs(content.compareTo(data))) {
                case -1:
                    if(null == left) {
                        left = new Node(content);
                    } else {
                        left.insert(content);
                    }
                    break;
                case 0:
                    return;
                case 1:
                    if(null == right) {
                        right = new Node(content);
                    } else {
                        right.insert(content);
                    }
                    break;
            }
        }
    }
}
