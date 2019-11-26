package dataStructures;

public class RB <K extends Comparable<K>,V> extends AdvancedBST<K,V> implements SortedMap<K,V> {
	class RBNode<E> extends BSTNode<E>{

		protected boolean isRed;// we add a color field to a BTNode
		
		public RBNode(E elem) {
			super(elem);
			isRed=true;
		}
		public RBNode( E element, RBNode<E> parent,
												RBNode<E> left, RBNode<E> right ){
			super(element, parent,left, right);
			isRed=true;
		}
		
		public void setColour(boolean colour) {
			isRed=colour;
		}
		public boolean isRed() {
			return isRed;
		}

	}
	protected RB(RBNode<Entry<K,V>> n) {
		root=n;
	}
	public RB() {
		this(null);
	}
	
	@Override
	public V insert(K key, V value) {
		//TODO
		V valueToReturn=null;
		RBNode<Entry<K,V>> newNode=null; // node where the new entry is being inserted (if find(key)==null)
		// insert the new Entry (if find(key)==null)
		// or set the new value (if find(key)!=null)
		newNode.setColour(true); //Red
	    if (newNode.getParent()==null)
	    	newNode.setColour(false); //Black
	    else
	      remedyDoubleRed(newNode); // fix a double-red color violation 
		return valueToReturn;
	}

	//pre: !isRoot(posZ)
	private void remedyDoubleRed(RBNode<Entry<K, V>> posZ) {
		// TODO
		RBNode<Entry<K,V>> posV = (RB<K, V>.RBNode<Entry<K, V>>) posZ.getParent();
	    if (posV.isRed()) {
	    // we have a double red: posZ and posV
	    	// Case black uncle ou null: trinode restructuring
	    	// Case red uncle: recoloring
	  }
	}
	
	@Override
	public V remove(K key) {
		//TODO
		// Remove as BST remove
		// case red node: end
		// case black node with a red children: recoloring (set children black)
		// case black node without child: remedyDoubleBlack(node)
		return null;
	}
	 /** Remedies a double black violation at a given node caused by removal. */
	  protected void remedyDoubleBlack(RBNode<Entry<K,V>> posR) {
	    RBNode<Entry<K,V>> posX, posY, posZ;
	    //TODO
	    // Case sibling is black and has a red children: trinode restructuring
	    // Case sibling is black and has two black children: recoloring
	    // Case red sibling: adjustment + remedyDoubleBlack(posR)
	  }

}

