package dataStructures;

import dataStructures.BST.BSTNode;

public class BSTOrderIterator<K,V> implements Iterator<Entry<K,V>> {
	/**
	 * Notas:
	 * infixo Esq Raiz Dir
	 * sufixo Esq Dir raiz
	 * prefxo Raiz Esq Dir
	 * niveis Raiz>filhosRaiz>netosRaiz>...
	 */
	
	
	
	
	public BSTOrderIterator(BSTNode<Entry<K, V>> root) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Entry<K,V> next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rewind() {
		// TODO Auto-generated method stub
		
	}

}
