/*  MERTCAN TAKIL 05140000643
    SERKAY YÜKSEL 05140000686
    SAFA ORHAN 05140000627*/
package telefonrehberi;


public class DoublyLinkedList
{
    private class TwoWayNode
    {
        private Bilgi data;
        private TwoWayNode previous;
        private TwoWayNode next;

        public TwoWayNode( )
        {
             data = null;
             next = null;
             previous = null;
        }

        public TwoWayNode(Bilgi newItem, TwoWayNode previousNode, TwoWayNode nextNode)
        {
            data = newItem;
            next = nextNode;
            previous = previousNode;
        }
     }//End of TwoWayNode inner class

    public class DoublyLinkedIterator
    {
	// We do not need a previous node when using a doubly linked list
	private TwoWayNode position = null;

	public DoublyLinkedIterator()
	{       
                position = head;
	}
	public void restart()
	{
		position = head;
	}
        public DoublyLinkedIterator reverse()
	{
		position = tail;
                return this;
	}
	public Bilgi next()
	{
		if (position == null)
			throw new IllegalStateException();
		Bilgi toReturn = position.data;
		position = position.next;
		return toReturn;
	}
        public Bilgi previous()
	{
		if (position == null)
			throw new IllegalStateException();
		Bilgi toReturn = position.data;
		position = position.previous;
		return toReturn;
	}
	public boolean hasNext()
	{
		return (position != null);
	}
	public Bilgi peek()
	{
		if (position == null)
			                 throw new IllegalStateException();
		return position.data;
	}
	public void insertHere(Bilgi newData)
	{
            if(position != null) {
                if(position != head) {
                    TwoWayNode temp = new TwoWayNode(newData, position.previous, position);
                    position.previous.next = temp;
                    position.previous = temp;
                    position = temp;
                    size++;
                    return;
                }
                TwoWayNode temp = new TwoWayNode(newData, null, head);
                head.previous = temp;
                head = temp;
                position = head;
                size++;
                return;
            }
            if(tail != null) {
                TwoWayNode temp =new TwoWayNode(newData, tail, null);
                tail.next = temp;
                tail = temp;
                position = temp;
                size++;
                return;
            }
            head = tail = new TwoWayNode(newData, tail, null);
            position = head;
            size++;
            return;
	}
	public void delete()
	{
            if(position != null){
                if(head != tail) {
                    if(position == head) {
                        head = head.next;
                        head.previous = null;
                        position = head;
                        size--;
                        return;
                    }
                    if(position == tail) {
                        tail = tail.previous;
                        tail.next = null;
                        position = tail;
                        size--;
                        return;
                    }
                    position.previous.next = position.next;
                    position.next.previous = position.previous;
                    position = position.next;
                    size--;
                    return;
                }
                if(position == head) {
                    head = tail = null;
                    position = null;
                    size--;
                }
            }          
	}
    }	// DoublyLinkedIterator
    private TwoWayNode head;
    private TwoWayNode tail;
    private int size;

    public DoublyLinkedIterator iterator()
    {
	return new DoublyLinkedIterator();
    }

    public DoublyLinkedList( )
    {
        head = null;
        tail=null;
        size=0;
    }

    /**
     Returns the number of nodes in the list.
    */
    public int size( )
    {
      return size;
    }


    public void outputList( )
    {
        TwoWayNode position = head;
        while (position != null)
        {
            System.out.println(position.data.toString() );
            position = position.next;
        }
    }

    public boolean isEmpty( )
    {
        return (head == null);
    }

    public void clear( )
    {
        head = null;
        tail=null;
    }

   /* <
       Other methods would normally be defined here,
        such as an equals, clone, find, or contains methods.
       They have been left off to simplify the example.
      >
   */
}

