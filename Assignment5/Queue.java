
public class Queue<T> {

	private List<T> queue;

	public Queue() { //constructor for new queue
		queue = new List<T>();
	}

	public Queue(List<T> q) { //constructor equals value
		queue = q;
	}

	public Queue(T arr[]) { //constructor get arr values to new queue
		queue = new List<T>();
		for (int i = arr.length - 1; i >= 0; i--) {
			queue.insert(null, arr[i]);
		}
	}

	public void enqueue(T value) { // do not insert same value!!! , get new value to queue
		if (queue.isEmpty()) {
			queue.insert(null, value);
			return;
		}
		Node<T> last = queue.getFirst();
		for (Node<T> p = queue.getFirst(); p != null; p = p.getNext()) {
			if (p.getData().equals(value)) {
				return;
			}
			last = p;
		}
		queue.insert(last, value);
	}

	public T dequeue() { //get out value from the queue
		if (queue.isEmpty()) {
			return null;
		}
		Node<T> first = queue.getFirst();
		queue.remove(first);
		return first.getData();
	}

	public boolean isEmpty() { //check if queue is empty
		return queue.isEmpty();
	}

	public T top() { //return the first value of the queue
		if (queue.isEmpty()) {
			return null;
		}
		return queue.getFirst().getData();
	}

	public String toString() { // making the queue to string [a.s.d.f.]
		String ans = "[";
		for (Node<T> p = queue.getFirst(); p != null; p = p.getNext()) {
			ans += p + ".";
		}
		ans += "]";
		return ans;
	}

	public T last() { //returning the last value in queue
		if (queue.isEmpty()) {
			return null;
		}
		Node<T> last = queue.getFirst();
		for (Node<T> p = queue.getFirst(); p != null; p = p.getNext()) {
			last = p;
		}
		return last.getData();
	}

	public int size() { //return the size of queue
		int count = 0;
		for (Node<T> p = queue.getFirst(); p != null; p = p.getNext()) {
			count++;
		}
		return count;

	}

	public void printQueue() {
		System.out.println(toString());
	}

	public Queue<T> clone() { //copy the queue to new queue
		if (queue.isEmpty()) {
			return null;
		}
		List<T> newList = new List<T>();
		Node<T> last = null;
		for (Node<T> p = queue.getFirst(); p != null; p = p.getNext()) {
			Node<T> loc = newList.insert(last, p.getData());
			last = loc;
		}
		return new Queue<T>(newList);
	}

	public Queue<T> cutUpHalf() { // return new queue with the upper half value of old queue, and remove them.
		if (queue.isEmpty()) {
			return null;
		}
		Queue<T> queueTemp = new Queue<T>(queue);
		List<T> upList = new List<T>();
		Node<T> upPos = null;
		Node<T> p = queue.getFirst();
		for( int i =0;i <= (queueTemp.size()/2);i++) {
			upPos = upList.insert(upPos, p.getData());
			p = queue.remove(p);
		}
		Queue<T> upHalf = new Queue<T>(upList);
		return upHalf;
	}

	public Queue<T> appendQueues(Queue<T> other) { //combine 2 queues.
		if (queue == null || queue.isEmpty()) {
			return other.clone();
		}
		if (other == null || other.isEmpty()) {
			return this.clone();
		}
		Queue<T> newQueue1 = this.clone();
		Queue<T> newQueue2 = other.clone();
		Node<T> last = null;
		for (Node<T> p = newQueue1.queue.getFirst(); p != null; p = p.getNext()) {
			last = p;
		}
		last.setNext(newQueue2.queue.getFirst());
		return newQueue1;
		
	}

	public Queue<T> reversedQueue() { //up-side-down the queue
		if (queue.isEmpty()) {
			return null;
		}
		List<T> newList = new List<T>();
		for (Node<T> p = queue.getFirst(); p != null; p = p.getNext()) {
			newList.insert(null, p.getData());
		}
		return new Queue<T>(newList);
	}

	public void enqueueVip(T value) { // will insert as the second one!
		if (queue.isEmpty()) {
			queue.insert(null, value);
			return;
		}
		queue.insert(queue.getFirst(), value);
	}
}
