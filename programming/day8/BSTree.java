public class BSTree <K extends Comparable<K>,V> implements IDict<K,V>{
    Node<K, V> root;
    Node<K, V> curr;
    int size = 0;
    K[] keys;
    int count = 0;
    Node<K, V> temp;

    /**
     * Makes a new empty tree
     */
    public BSTree() {
        root = null;
        curr = null;
    }

    /**
     * Places a new node in the tree
     * @param k key for the new node
     * @param v value for new node
     */
    public V add(K k, V v) {
        // look at the root first
        curr = root;
        if(curr==null) {
            root=new Node<K, V>(k,v);
            size++;
            return root.getValue();
        }
        // What to do if we aren't inserting the root
        return helper(k,v);
    }
    // Helps with the insertion method
    public V helper(K k, V v) {
        // Does the new node fit as a direct child
        if((k.compareTo(curr.getKey()) < 0 && curr.getLeft()==null) || (k.compareTo(curr.getKey())>0 && curr.getRight()==null)){
            if(k.compareTo(curr.getKey())<0) {
                // insert left
                curr.setLeft(new Node<K, V>(k,v));
            } else {
                // insert right
                curr.setRight(new Node<K, V>(k,v));
            }
            // Work done for the easy case
            size++;
            return curr.getValue();
        }
        // Place the node with one of the children, based on if the key
        // goes to the left or the right
        if(k.compareTo(curr.getKey())<0) {
            curr = curr.getLeft();
        } else {
            curr = curr.getRight();
        }
        return helper(k,v);
    }

    /**
     * Get the value associated with some key
     * @param k key to search for in the tree
     * @return value associated with the key
     */
    public V fetch(K k) {
        // start at the root
        curr = root;
        // while we haven't found the key
        while(curr.getKey()!=k) {
            if(k.compareTo(curr.getKey()) > 0) {
                // walk right
                curr = curr.getRight();
            } else {
                // walk left
                curr = curr.getLeft();
            }
        }
        // We have found the key or ran out of children
        return curr.getValue();
    }

    /**
     * Removes a node from the tree based on the key
     * @param k the key to remove
     */
    public V remove(K k) {
        // Find the node to remove and it's parent
        Node<K, V> parent = null;
        // start at the root
        curr = root;
        // while we haven't found the key
        while(curr.getKey()!=k) {
            if(k.compareTo(curr.getKey()) > 0) {
                // walk right
                parent = curr;
                curr = curr.getRight();
            } else {
                // walk left
                parent = curr;
                curr = curr.getLeft();
            }
        }
        V returnValue = curr.getValue();
        // We have the node and it's parent

        // Case 1: no children, just kill the node
        // ...could have used isLeaf... but didn't think of that first
        if(curr.getRight()==null && curr.getLeft()==null) {
            if(parent.getRight()==curr) { parent.setRight(null); }
            if(parent.getLeft()==curr)  { parent.setLeft(null); }
            curr = root;
            size--;
            return returnValue;
        }
        // Case 2: 1 child, replace node with child
        // ...maybe redundant... might remove later
        if(curr.getRight()==null || curr.getLeft()==null) {
            // Set the parent to point at the child
            if(curr.getRight()==null) {
                if(parent.getRight()==curr) {
                    parent.setRight(curr.getLeft());
                } else {
                    parent.setLeft(curr.getLeft());
                }
            } else {
                // if(curr.getLeft()==null)
                if(parent.getRight()==curr) {
                    parent.setRight(curr.getRight());
                } else {
                    parent.setLeft(curr.getRight());
                }
            }
            curr=root;
            size--;
            return returnValue;
        }
        // Case 3: Go right once, go left until you can't, remove that
        //         left most node, replace the node you wanted to remove
        //         with the left most node
        // Does this work if the curr is the root... Probably not
        Node<K, V> swapparent = curr;
        Node<K, V> swapnode = curr.getRight(); // trying to find the one to swap
                                            // into curr's place in the tree
        while(swapnode.getLeft() != null) {
            swapparent=swapnode;
            swapnode=swapnode.getLeft();
        }
        // Have left most node, set the left most parent to the right child
        swapparent.setLeft(swapnode.getRight());
        swapnode.setLeft(curr.getLeft());
        swapnode.setRight(curr.getRight());
        if(parent.getRight()==curr) { parent.setRight(swapnode); }
        if(parent.getLeft()==curr)  { parent.setLeft(swapnode); }
        curr = root;
        size--;
        return returnValue;
    }

    public int size(){
      return size;
    }

    public void addKeys(K k){
      if (temp.getRight() == null && temp.getLeft() == null){
        keys[count] = temp.getKey();
        count++;
      }
      else if (temp.getRight() == null && temp.getLeft() != null){
        keys[count] = temp.getKey();
        temp = temp.getLeft();
        count++;
        addKeys(temp.getKey());
      }
      else if (temp.getRight() != null && temp.getLeft() == null){
        keys[count] = temp.getKey();
        temp = temp.getRight();
        count++;
        addKeys(temp.getKey());
      }
      else{
        keys[count] = temp.getKey();
        count++;
        temp = curr.getRight();
        addKeys(temp.getKey());
        temp = curr.getLeft();
        addKeys(temp.getKey());
      }
    }

    public K[] keys(){
      temp = root;
      keys = (K[]) new Object[size];
      addKeys(temp.getKey());
      return keys;
    }

    /**
     * Main method to do some basic checks on functionality
     */
    public static void main(String[] argv) {
        IDict<Integer,Integer> tree   = new BSTree<Integer,Integer>();
        tree.add(17,17);
        tree.add(20,20);
        tree.add(25,25);
        tree.add(18,18);
        tree.add(1,1);
        tree.add(21,21);
        tree.add(22,22);
        tree.remove(20);
        System.out.println(tree.fetch(22));
        System.out.println(tree.fetch(20));
    }
}
