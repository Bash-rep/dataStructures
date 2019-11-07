package dataStructures;

class BTNode<E> implements Node<E>{
	
	protected BTNode<E> parent;
	protected BTNode<E> left;
	protected BTNode<E> right;
	public void setParent(BTNode<E> parent) {
		this.parent = parent;
	}
	public void setLeft(BTNode<E> left) {
		this.left = left;
	}
	public void setRight(BTNode<E> right) {
		this.right = right;
	}
	public void setElement(E element) {
		this.element = element;
	}

	protected E element;

	
	public BTNode(E elem,BTNode<E> parent,BTNode<E> left,BTNode<E> right){
		this.parent=parent;
		this.left=left;
		this.right=right;
		element=elem;
	}
	public BTNode(E elem){
		this(elem,null,null,null);
	}
	@Override
	public E getElement() {
		return element;
	}

	public Node<E> getLeft() {
		return left;
	}
	
	public Node<E> getRight() {
		return right;
	}

	public Node<E> getParent() {
		return parent;
	}
	
}
