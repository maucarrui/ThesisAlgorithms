package com.github.maucarrui.algorithms.treeisomorphism;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Class to represent a tree isomorpher.
 *
 * A tree isomorpher is capable of telling if two rooted trees are isomorphic,
 * and if so, return an isomorphism between the two.
 */
public class TreeIsomorpher<U extends Comparable<U>, V extends Comparable<V>> {

    /**
     * Unique empty constructor to initialize a tree isomorpher and have access
     * to its methods.
     */
    public TreeIsomorpher(){}

    /**
     * Auxiliary method to append the leaves found on the 0-th level to its
     * parent list.
     * @param T the rooted tree.
     * @param children the mapping of the ordered children.
     */
    private <K extends Comparable<K>> void
	setInitialChildren(RootedTree<K> T, HashMap<K, LinkedList<K>> children) {
	for (K leaf : T.getVerticesOfLevel(0)) {
	    K parent = T.getParent(leaf);

	    if (children.containsKey(parent)) {
		children.get(parent).add(leaf);
	    } else {
		LinkedList<K> ch = new LinkedList<>();
		ch.add(leaf);
		children.put(parent, ch);
	    }
	}
    }

    /**
     * Auxiliary method to obtain the structures found on the current level.
     * @param T the rooted tree.
     * @param children the map that contains the ordered list of children of the
     *        vertices on the current level.
     * @param values the values map, where each structure is associated with an
     *        unique value.
     * @param level the current level.
     * @return a mapping to the structures found on the current level.
     */
    private <K extends Comparable<K>> HashMap<K, MultiSet<Integer>>
	getStructsOnLevel(RootedTree<K> T, HashMap<K, LinkedList<K>> children,
			  HashMap<K, Integer> values, int level) {
	/* Define an empty mapping of structures. */
	HashMap<K, MultiSet<Integer>> structures = new HashMap<>();

	/* Traverse each vertex found on the current level. */
	for (K v : T.getVerticesOfLevel(level)) {
	    MultiSet<Integer> struct = new MultiSet<>();

	    /* Build the structure by adding the values of the children. */
	    for (K child : children.get(v)) {
		struct.add(values.get(child));
	    }

	    structures.put(v, struct);
	}

	return structures;
    }

    /**
     * Returns whether two rooted trees are isomorphic.
     * @param G on of the rooted trees to the check for isomorphism.
     * @param rootG the root of the rooted tree G.
     * @param H the other rooted tree to check for isomorphism.
     * @param rootH the root of the rooted tree H.
     * @return the isomorphism between the two rooted trees, if the trees are
     *         not isomorphic it returns null.
     */
    public HashMap<U, V> areIsomorphic(Graph<U> G, U rootG, Graph<V> H, V rootH) {
	return new HashMap<U, V>();
    }


    /**
     * Returns whether two trees are isomorphic.
     * @param G on of the trees to the check for isomorphism.
     * @param H the other tree to check for isomorphism.
     * @return the isomorphism between the two trees, if the trees are not
     *         isomorphic it returns null.
     */
    public HashMap<U, V> areIsomorphic(Graph<U> G, Graph<V> H) {
	return new HashMap<U, V>();
    }
}
