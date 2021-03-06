package dsaii.bst;

import dsaii.common.Position;
import dsaii.trees.AbstractLinkedBinaryTree;
import dsaii.trees.InvalidPositionException;
import dsaii.trees.ProperLinkedBinaryTree;

public class ProperLinkedBSTBinaryTree<T> extends ProperLinkedBinaryTree<T> {
    public T remove(Position<T> position) {
        if (isInternal(left(position)) && isInternal(right(position))) {
            throw new InvalidPositionException("Cannot remove a node with 2 internal children)");
        }

        Node<T> toRemove = toNode(position);
        Node<T> replacement;
        if (isInternal(right(position))) {
            replacement = toRemove.right;
        } else {
            replacement = toRemove.left;
        }
        replacement.parent = toRemove.parent;
        if (toRemove.parent.left == toRemove) {
            toRemove.parent.left = replacement;
        } else {
            toRemove.parent.right = replacement;
        }
        toRemove.parent = null;
        toRemove.right.parent = null;
        toRemove.right = null;
        toRemove.left = null;
        size-=2;
        return toRemove.element;
    }

}
