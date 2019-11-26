package dataStructures;

import dataStructures.BST.BSTNode;

public class BinarySearchTree<K extends Comparable<K>, V> extends BinaryTree<Entry<K, V>> implements SortedMap<K, V> {

	protected BinarySearchTree(Node<Entry<K, V>> n) {
		root = n;
	}

	public BinarySearchTree() {
		this(null);
	}

	@Override
	protected Node<Entry<K, V>> left(Node<Entry<K, V>> n) {
		return ((BTNode<Entry<K, V>>) n).getLeft();
	}

	@Override
	protected Node<Entry<K, V>> right(Node<Entry<K, V>> n) {
		return ((BTNode<Entry<K, V>>) n).getRight();
	}

	@Override
	protected Node<Entry<K, V>> parent(Node<Entry<K, V>> n) {
		return ((BTNode<Entry<K, V>>) n).getParent();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<Entry<K, V>> iterator() {
		return new BSTOrderIterator<K, V>((BSTNode<Entry<K, V>>) root);
	}

	@Override
	public Iterator<K> keys() throws NoElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> values() throws NoElementException {
		// TODO Auto-generated method stub
		return null;
	}

	private Node<Entry<K, V>> findNode(Node<Entry<K, V>> n, K key) {
		Node<Entry<K, V>> res = null;
		if (n != null) {
			int num = n.getElement().getKey().compareTo(key);
			if (num == 0)
				res = n;
			else if (num < 0)
				res = findNode(left(n), key);
			else
				res = findNode(right(n), key);
		}
		return res;
	}

	@Override
	public V find(K key) {
		Node<Entry<K, V>> res = findNode(root, key);
		if (res == null)
			return null;
		return res.getElement().getValue();
	}

	@Override
	public V insert(K key, V value) {
		BTNode<Entry<K, V>> node = new BTNode<>(new EntryClass<K, V>(key, value));
		return insertNode(node, (BTNode<Entry<K, V>>) root);
	}

	private V insertNode(BTNode<Entry<K, V>> node, BTNode<Entry<K, V>> current) {
		int a = current.getElement().getKey().compareTo(node.getElement().getKey());

		if (a == 0) {
			current.setElement(node.getElement());
			return current.getElement().getValue();
		} else if (a < 0) {
			if (left(current) == null) {
				current.setLeft(node);
				node.setParent(current);
				return null;
			}
			return insertNode(node, (BTNode<Entry<K, V>>) left(current));
		} else {
			if (right(current) == null) {
				current.setRight(node);
				node.setParent(current);
				return null;
			}
			return insertNode(node, (BTNode<Entry<K, V>>) right(current));
		}
	}

	@Override
	public V remove(K key) {
		BTNode<Entry<K,V>> node = (BTNode<Entry<K, V>>) findNode(root, key);
		
		//if(node.equals(root)) {root = null;}
		
		if(isLeaf(node)) {
			//remove o no
			if(isLeftSon(node)) {
				node.parent.setLeft(null);
			}
			else {
				node.parent.setRight(null);
			}
		}
		else if(hasOnlyLeftChild(node)){
			//liga o filho esquerdo ao pai do current
			
			//falta o avo
			if(isLeftSon(node)) {
				node.parent.setLeft(node.left);
			}else {
				node.parent.setRight(node.left);
			}
		}
		else if(hasRightChild(node)) {
			//liga o filho direito ao pai do current
			
			//falta o avo
			
			if(isLeftSon(node)) {
				node.parent.setLeft(node.right);
			}
			else {
				node.parent.setRight(node.right);
			}
		}else {
			//do the jibijanga with the min subDir
			BTNode<Entry<K,V>> rightSideMin = findMin(node.right);
			
			
			node.setElement(rightSideMin.element);
			
			if(isLeftSon(rightSideMin)) {
				//rightSideMin.parent.setLeft(null);
			}
			else {
				rightSideMin.parent.setRight(null);
			}
			
		
			
		}
		
		return node.getElement().getValue();
	}

	private boolean isLeftSon(BTNode<Entry<K, V>> node) {
		return node.parent.getLeft().equals(node);
	}

	private BTNode<Entry<K, V>> findMin(BTNode<Entry<K, V>> node) {
		if (true /*quando fica sem esq*/) {
			return node;
		} else {
			return findMin(node.left);
		}
	}

	private boolean hasRightChild(BTNode<Entry<K, V>> node) {
		return node.getLeft() == null && node.getRight() != null;
	}

	private boolean hasOnlyLeftChild(BTNode<Entry<K, V>> node) {
		return node.getLeft() != null && node.getRight() == null;
	}

	private boolean isLeaf(BTNode<Entry<K, V>> node) {
		return node.getLeft() == null && node.getRight() == null;
	}

	@Override
	public Entry<K, V> minEntry() throws NoElementException {
		// TODO
		return null;
	}

	@Override
	public Entry<K, V> maxEntry() throws NoElementException {
		if (this.isEmpty())
			throw new NoElementException();
		return this.maxNode(root).getElement();
	}

	// Precondition: node != null.
	protected Node<Entry<K, V>> maxNode(Node<Entry<K, V>> node) {
		if (((BTNode<Entry<K, V>>) node).getRight() == null)
			return node;
		return this.maxNode(((BTNode<Entry<K, V>>) node).getRight());
	}

}
