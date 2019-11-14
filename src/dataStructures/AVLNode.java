package dataStructures;

class AVLNode<E> extends BTNode<E>{
	
	// Height of the node
	protected int height;
	
	public AVLNode(E elem) {
		super(elem);
		height=1;
	}
	
	public AVLNode( E element, AVLNode<E> parent,AVLNode<E> left, AVLNode<E> right ){ //char balance, 
		super(element, parent,left, right);
		height= 1 + Math.max(getHeight((AVLNode<E>)left),getHeight((AVLNode<E>)right));
	}
	
	protected int getHeight(AVLNode<E> no) {
		if (no==null)
			return 0;
		return no.getHeight();
	}
	
	public int getHeight() {
		return height;
	}

	public boolean isBalance() {
		int dif= getHeight((AVLNode<E>)left)-getHeight((AVLNode<E>)right);
		return dif==0 ||dif==-1 ||dif ==1;
	}
	
	public int setHeight() {
		height= 1 + Math.max(getHeight((AVLNode<E>)left),getHeight((AVLNode<E>)right));
		return height;
	}
}
