 
public class Driver {

	public static void main(String[] args) {

	
		Queue<Integer> intQ = new Queue<Integer>();
		Queue<String> strQ = new Queue<String>();
		
		// Integer 
		System.out.println(intQ.last());
		System.out.println(intQ.top());
		Integer []arr = {1,2,3,4,5,6,7,8,9,};
		Queue<Integer> fromarry = new Queue<Integer>(arr);
		
		fromarry.printQueue();
		intQ.enqueueVip(9);
		intQ.enqueue(1);
		intQ.enqueue(3);
		intQ.enqueue(30);
		intQ.enqueue(6);
		intQ.enqueue(12);
		intQ.enqueue(30);
		intQ.enqueue(55);
		intQ.enqueue(100);
		intQ.enqueue(120);
		intQ.enqueue(30);
		intQ.enqueue(130);
		intQ.printQueue();
		intQ.dequeue();
		intQ.dequeue();
		intQ.dequeue();
		intQ.dequeue();
		intQ.dequeue();
		intQ.printQueue();
		System.out.println(intQ.last());
		System.out.println(intQ.top());
		Queue<Integer> temp = intQ.clone();
		temp.reversedQueue().printQueue();
		temp.enqueueVip(9);
		temp.printQueue();
		temp.cutUpHalf().printQueue();
		temp.printQueue();
		temp.appendQueues(intQ.appendQueues(intQ.reversedQueue().appendQueues(temp))).printQueue();

		
		//String
		System.out.println(strQ.last());
		System.out.println(strQ.top());
		strQ.enqueue("David");
		strQ.enqueue("Moshe");
		strQ.enqueue("Haiim");
		strQ.enqueue("Eli");
		strQ.enqueue("Smadar");
		strQ.enqueue("Smadar");
		strQ.enqueue("Smadar");
		System.out.println(strQ.last());
		System.out.println(strQ.top());
		strQ.enqueue("Smadar");
		strQ.enqueue("Israel");
		strQ.enqueue("Lior");
		strQ.enqueue("Vered");
		strQ.enqueue("Smadar");
		System.out.println(strQ.last());
		System.out.println(strQ.top());
		strQ.enqueue("Hodaya");
		strQ.printQueue();
		strQ.dequeue();
		strQ.enqueue("Vered");
		Queue<String> temp2 = strQ.clone();
		temp2.printQueue();
		strQ.reversedQueue().printQueue();
		strQ.enqueueVip("Menashe");
		strQ.printQueue();
		strQ.cutUpHalf().printQueue();
		strQ.printQueue();
		
		strQ.appendQueues(strQ.reversedQueue()).printQueue();
	
		//char
		
		Character []charArr1 = {'!','r','e','V','o'};
		Character []charArr2 = {'s','i'};
		Character []charArr3 = {'a','v','A','j'};
		
		Queue<Character> charQ1 = new Queue<Character>(charArr1);
		Queue<Character> charQ2 = new Queue<Character>(charArr2);
		Queue<Character> charQ3 = new Queue<Character>(charArr3);
		
		System.out.println(charQ1.toString()+charQ2.toString()+charQ3.toString());
		charQ1.appendQueues(charQ2.appendQueues(charQ3)).printQueue();
		charQ1.appendQueues(charQ2.appendQueues(charQ3)).reversedQueue().printQueue();
		
			
	}

}
