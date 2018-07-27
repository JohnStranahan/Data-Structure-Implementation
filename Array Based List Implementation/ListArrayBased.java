package List;



/*
* Purpose: Data Structure and Algorithms Lab 2 Problem 3
* Status: Complete and thoroughly tested
* Last update: 09/18/17
* Submitted:  09/19/17
* Comment: test suite and sample run attached
* @author: John Stranahan
* @version: 2017.09.18
*/
  
public class ListArrayBased<T> implements ListInterface<T>
{


    
    protected T[] items;  // an array of list items
    protected static int numItems;  // number of items in list

    
    /*
     * 
     */
    @SuppressWarnings("unchecked")
	public ListArrayBased()
    {
        items = (T[]) new Object[3];
        numItems = 0;
    }  // end default constructor

   
	public boolean isEmpty()
    {
        return (numItems == 0);
    } // end isEmpty

  
	public int size()
    {
        return numItems;
    }  // end size


    
	
	public void add(int index, Object item)
    throws  ListIndexOutOfBoundsException
    {
        if (numItems == items.length) //THROW IT OUT //logic ERROR
        {
            throw new ListException("ListException on add");
        }  // end if
        
        if (index >= 0 && index <= numItems)
        {
            // make room for new element by shifting all items at
            // positions >= index toward the end of the
            // list (no shift if index == numItems+1)
            for (int pos = numItems-1; pos >= index; pos--)  //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
            {
                items[pos] = items[pos+1];
            } // end for
            // insert new item
            items[index] = (T) item;
            numItems++;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on add");
        }  // end if
    } //end add


	public T get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return (T) items[index];
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on get");
        }  // end if
    } // end get

 
	public void remove(int index) //memory leak make spot null
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
       {
            // delete item by shifting all items at
            // positions > index toward the beginning of the list
            // (no shift if index == size)
            for (int pos = index+1; pos < numItems; pos++) //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException

            {
                items[pos-1] = items[pos];
                
            }  // end for
            numItems--;
            items[numItems] = null;
            
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
        }  // end if
        
        
        
    } //end remove
    
    @SuppressWarnings("unchecked")

	public void removeAll()
    {
        // Creates a new array; marks old array for
        // garbage collection.
        items = (T[]) new Object[3];  //allocates a new array of 
        numItems = 0;    //sends to garbage collector
    } // end removeAll

    public String toString() {

		String actualList = "";

		for (int i = 0; i < numItems; i++) {
			actualList += items[i] + " ";
		}

		return actualList;
	}
 
}
