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
		
		/**
	 	  * Postcondition: element is initialized
	 	  */
		private Node (Object elem) {
			this.element = elem;
		}
		
		/**
	 	  * Postcondition: next node in Set is returned
	 	  * @return next Node
	 	  */
		private Node getNextNode(){
			return next;
		}
		
		/**
	 	  * Postcondition: pointer to next Node (next) in Set is changed
	 	  */
		private void setNextNode(Node next){
			this.next = next;
		}
		
		
		/**
	 	  * Postcondition: element of node is returned
	 	  * @return element
	 	  */
		private Object getElement(){
			return element;
		}
	}
	
	class BauernIterator implements MyIterator{
		private Node p=head; // current iterator position
				
		/**
	 	  * Precondition: iterator must contain further element ( check by hasNext() )
	 	  * Postcondition: next Element of iterator is delivered
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
	 	  * Postcondition: checks if iterator contains further elements
	 	  * @return true if further elements in Iterator, otherwise false
	 	  */
		public boolean hasNext() { 
			return p != null;
		}
	}
	
	/** 
	  * Postcondition: an iterator over a set of elements is returned
	  */
	@MethodInformation(author="Wolfgang", date="07.12.2012", description="returns a new Iterator over Set")
	public BauernIterator iterator() {
		return new BauernIterator();
	}
	
	
	/**
	  * Precondition: only inserts element, if not already existing in Set
	  * Postcondition: element is inserted in Set
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
	  * Postcondition: checks if IDENTIC element is in Set
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
	
	/**
	  * Precondition: element must exist in Set to delete it
	  * Postcondition: element is deleted from Set
	  * @return true if IDENTIC element is in Set, otherwise false
	  */
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
		
	/**
	  * Precondition: traktor must exist in Set to change it
	  * Precondition: maschine must be a different machine as the current equipped of the tractor
	  * Postcondition: equipped machine on traktor is changed to maschine
	  * @return true if IDENTIC traktor is in Set and maschine is changed, otherwise false
	  */
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