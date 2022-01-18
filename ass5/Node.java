public class Node<T> {

	private T data;
	private Node<T> nextNode;
	public Node(T data) {
		this.data = data;
	} // class Node<T> constructor1
	public Node(T data, Node<T> nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	} // class Node<T> constructor2
	public void setData(T data) {
		this.data = data;
	}
	public T getData() {
		return this.data;
	}
	public void setNext(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	public Node<T> getNext() {
		return this.nextNode;
	}

	public String toString() {
		return this.data.toString();
	}
}