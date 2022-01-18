public class List<T> {
	private Node<T> first; // class List attribute

	public List() {
		this.first = null;
	} // class List constructor

	public Node<T> getFirst() {
		return this.first;
	} // getFirst

	public boolean isEmpty() {
		return this.first == null;
	} // isEmpty

	public Node<T> insert(Node<T> pos, T x) {
		Node<T> q = new Node<T>(x); // creating new node
		if (pos == null) {
			q.setNext(this.first);
			this.first = q; // first element in the list
		} else {
			q.setNext(pos.getNext());
			pos.setNext(q);
		}
		return q;
	} // insert
	public Node<T> remove(Node<T> pos) {
		if (this.first == pos) {
			this.first = pos.getNext(); // remove first node
			return this.first;
		} else {
			Node<T> prev = this.first;
			while (prev.getNext() != pos) // searching pos reference
				prev = prev.getNext();
			prev.setNext(pos.getNext());
			return prev.getNext();
		}
	} // remove
	@Override
	public String toString() {
		Node<T> pos = this.first;
		String res = "";
		while (pos != null) {
			res += pos.getData().toString();
			pos = pos.getNext();
		}
		return res;
	}

}