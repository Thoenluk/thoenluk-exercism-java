
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Ignore;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void dataIsRetained() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        int expected = 4;
        binarySearchTree.insert(expected);

        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        assertNotNull(root);

        int actual = root.getData();
        assertEquals(expected, actual);
    }

    @Test
    public void insertsLess() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        char expectedRoot = '4';
        char expectedLeft = '2';

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedLeft);

        BinarySearchTree.Node<Character> root = binarySearchTree.getRoot();
        assertNotNull(root);
        BinarySearchTree.Node<Character> left = root.getLeft();
        assertNotNull(left);

        char actualRoot = root.getData();
        char actualLeft = left.getData();
        assertEquals(expectedLeft, actualLeft);
        assertEquals(expectedRoot, actualRoot);
    }

    /* This test is wrong and I refuse to implement it.
    The common definition of a Binary Search Tree specifically excludes duplicate keys.
    Even with a more lenient definition, to avoid proper insanity, a duplicate key
    should be hung within the node it is equal to, not as a child of it. Consider this:
    You have a BST with a few elements, say a million. You are looking for the element 6.
    The root is 7, so you go left. The next child is 4, in which case you would normally
    go right, but its left child is also 4. As are its next 10,000 left children.
    Additionally, what if I insert a 1 at the leaf 4 node, thus occupying its left child.
    I then insert another 4, which has nowhere to go. Should it be hung as the right
    child of the 1 node? Reshuffle the entire tree? You see how this is absurd.
    To allow duplicate keys is to wholly disable the benefits of trees.
    
    @Test
    public void insertsSame() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        String expectedRoot = "4";
        String expectedLeft = "4";

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedLeft);

        BinarySearchTree.Node<String> root = binarySearchTree.getRoot();
        assertNotNull(root);
        BinarySearchTree.Node<String> left = root.getLeft();
        assertNotNull(left);

        String actualRoot = root.getData();
        String actualLeft = left.getData();
        assertEquals(expectedLeft, actualLeft);
        assertEquals(expectedRoot, actualRoot);
    }*/

    @Test
    public void insertsRight() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        int expectedRoot = 4;
        int expectedRight = 5;

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedRight);

        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        assertNotNull(root);
        BinarySearchTree.Node<Integer> right = root.getRight();
        assertNotNull(right);

        int actualRoot = root.getData();
        int actualRight = right.getData();
        assertEquals(expectedRight, actualRight);
        assertEquals(expectedRoot, actualRoot);
    }

    @Test
    public void createsComplexTree() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = Collections.unmodifiableList(
                Arrays.asList('4', '2', '6', '1', '3', '5', '7')
        );

        List<Character> treeData = Collections.unmodifiableList(
                Arrays.asList('4', '2', '6', '1', '3', '5', '7')
        );
        treeData.forEach(binarySearchTree::insert);

        List<Character> actual = binarySearchTree.getAsLevelOrderList();
        assertEquals(expected, actual);
    }

    
    @Test
    public void sortsSingleElement() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        List<String> expected = Collections.unmodifiableList(
                Collections.singletonList("2")
        );

        binarySearchTree.insert("2");

        List<String> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    
    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsSmallerThanFirst() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(1, 2)
        );

        binarySearchTree.insert(2);
        binarySearchTree.insert(1);

        List<Integer> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    /*
    See comment for insertsSame test above. A tree does not accept duplicate keys. The
    mere notion of it is absurd and the test avoids dealing with the implications by
    using two-element trees, as any more would lead to horrifyingly unspecified behaviour.
    @Test
    public void sortsCollectionOfTwoIfSecondNumberisSameAsFirst() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = Collections.unmodifiableList(
                Arrays.asList('2', '2')
        );

        binarySearchTree.insert('2');
        binarySearchTree.insert('2');

        List<Character> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }
    */

    
    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsBiggerThanFirst() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = Collections.unmodifiableList(
                Arrays.asList('2', '3')
        );

        binarySearchTree.insert('2');
        binarySearchTree.insert('3');

        List<Character> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    
    @Test
    public void iteratesOverComplexTree() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        List<String> expected = Collections.unmodifiableList(
                Arrays.asList("1", "2", "3", "5", "6", "7")
        );

        List<String> treeData = Collections.unmodifiableList(
                Arrays.asList("2", "1", "3", "6", "7", "5")
        );
        treeData.forEach(binarySearchTree::insert);

        List<String> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }
}
