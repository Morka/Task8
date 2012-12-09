/**
* @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
*/

/**
 * Set is a set of instances
 **/
public class Set {
	
	private Node head;  // first node of list
	private Node tail;  // last node of list
			
	
	class Node{
		private Object element; // element in node
		private Node next = null; // next node in list
		
		private Node (Object elem) {
			this.element = elem;
		}
		
		private Node getNextNode(){
			return next;
		}
		
		private void setNextNode(Node next){
			this.next = next;
		}
		
		
		private Object getElement(){
			return element;
		}
	}
	
	class BauernIterator implements MyIterator{
		private Node p=head; // current iterator position
				
		/**
	 	  * gets next Element of iterator
	 	  * Precondition: iterator must contain further element ( check by hasNext() )
	 	  * @return element from current iterator position
	 	  */
		public Object next() {      // get next list element
			if (p == null){
				return null;
			}
			Object element = p.getElement();	
			p = p.getNextNode();
				
			return element;
		}
		
		/**
	 	  * checks if iterator contains further elements
	 	  * 
	 	  * @return true if further elements in Iterator, otherwise false
	 	  */
		public boolean hasNext() { 
			return p != null;
		}
	}
	
	/** 
	  * returns an iterator over a set of elements
	  */
	@MethodInformation(author="Wolfgang", date="07.12.2012", description="returns a new Iterator over Set")
	public BauernIterator iterator() {
		return new BauernIterator();
	}
	
	
	/**
	  * inserts element in Set
	  * Precondition: element kommt nur ins Set, wenn noch kein gleiches element im Set vorhanden ist
	  * @param element to insert in Set
	  */
	@MethodInformation(author="Wolfgang", date="07.12.2012", description="inserts element in Set")
	public void insert(Object element) {
		if(!contains(element)) {
			
			if (head == null)
				tail = head = new Node(element);
			else {
				tail.setNextNode(new Node(element));
				tail = tail.getNextNode();
			}
		}
	}		
	
	/**
	  * checks if IDENTIC element is in Set
	  * 
	  * @return true if IDENTIC element is in Set, otherwise false
	  */
	@MethodInformation(author="Wolfgang", date="07.12.2012", description="checks if Set contain specific element")
	private boolean contains(Object element) {
		Node p = head;
		
		while(p != null) {
			if(p.getElement().equals(element))
				return true;
			p = p.getNextNode();;
		}
		
		return false;
	}
	
	@MethodInformation(author="Wolfgang", date="07.12.2012", description="deletes element from Set")
	public boolean delete(Object element) {
		Node p = head;
		Node prev = head;
						
		while(p != null) {
			if(p.getElement() == element) {
				
				if(p == head)
					head = p.getNextNode();
				
				if(p == tail)
					tail = prev;
				
				return true;
			}
				
			prev = p;
			p = p.getNextNode();;
		}
		
		return false;
	}
		
	@MethodInformation(author="Wolfgang", date="07.12.2012", description="changes machine in specific tractor")
	public boolean change(Traktor traktor, Maschine maschine) {
		Node p = head;
		
		while(p != null) {
			if(p.getElement() == traktor) {
				((Traktor) ((Node) p).getElement()).change(maschine);
				return true;
			}
			
			p = p.getNextNode();;
		}
		
		return false;
	}
}