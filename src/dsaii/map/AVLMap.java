package dsaii.map;

import dsaii.bst.AVLTree;

public class AVLMap<K extends Comparable, V> extends BSTMap<K,V> {
    public AVLMap() {
        tree = new AVLTree<Entry<K,V>>();
    }
}
