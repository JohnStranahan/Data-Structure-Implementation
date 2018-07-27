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

public class ListArrayBasedPlus<T> extends ListArrayBased<T> {

	@Override
	public void add(int index, Object item) throws ListIndexOutOfBoundsException {
		// TODO Auto-generated method stub

		if (numItems == items.length) {
			resizeList();
		}

		if (index >= 0 && index <= numItems) {
			// make room for new element by shifting all items at
			// positions >= index toward the end of the
			// list (no shift if index == numItems+1)
			for (int pos = numItems - 1; pos >= index; pos--) // textbook code modified to eliminate logic error causing
																// ArrayIndexOutOfBoundsException
			{
				items[pos] = items[pos + 1];
			} // end for
				// insert new item
			items[index] = (T) item;
			numItems++;
		} else {
			// index out of range
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on add");
		} // end if

	}

	private void resizeList() {

		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[items.length * 2];
		for (int i = 0; i < numItems; i++) {
			temp[i] = items[i];
		}
		items = temp;

	}

	public void reverseList() {

		for (int start = 0, end = numItems - 1; start <= end; start++, end--) {
			T aux = items[start];
			items[start] = items[end];
			items[end] = aux;
		}

	}

	public String toString() {

		String actualList = "";

		for (int i = 0; i < numItems; i++) {
			actualList += items[i] + " ";
		}

		return actualList;
	}

}

