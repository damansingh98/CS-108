import java.util.Arrays;
interface LinearListADT<T> {

    /**
     * Inserts the specified element at the specified position in this list
     *
     * Note that you may have to shift elements to add a specific element at the specified location.
     * @param index
     * @param element
     * @return true if added successfully, false otherwise
     */
    boolean add(int index, T element);

    /**
     * Appends the specified element to the end of this list
     * @param element
     * @return true if added successfully, false otherwise
     */
    boolean add(T element);

    /**
     * Returns the element at the specified position in this list.
     * @param index
     * @return the element found, null otherwise
     */
    T get(int index);

    /**
     * Check if a specific element is inside the list
     * @param element
     * @return true if element is in the list, false otherwise.
     */
    boolean contains(T element);

    /**
     * Find the first location of a specific element
     * @param element
     * @return the first index matching the element if it is in the list, -1 otherwise.
     */
    int find(T element);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present
     *
     * Note that you may have to shift elements to fill in the slot where the deleted element was located.
     * @param element
     * @return the element been removed, null otherwise
     */
    T remove(T element);

    /**
     * Removes the element at the specified position in this list
     * @param index
     * @return the element been removed, null otherwise
     */
    T remove(int index);

    /**
     * Removes all of the elements from this list
     */
    void clear();

    /**
     * Returns the number of elements in this list.
     */
    int size();
}
public class LinearList<T> implements LinearListADT<T> {
    //instance variables
    private int size;
    private T[] array;
    private int MaxCap = 1000;

    //Default Constructor
    public LinearList() {
        // size and array initializations
        size = 0;
        array = (T[]) new Object[MaxCap];

    }

    //Double the capacity of the array (instance method)
    private void doubleCapacity() {
        // create an array to double the capacity
        int DoubleLength = 2 * array.length;
        T[] DoubleArray = (T[]) new Object[DoubleLength];
        for (int i = 0; i < size; i++) {
            DoubleArray[i] = array[i];

        }
        // assign the original array (array) with the new array(DoubleArray)
        array = DoubleArray;
    }

    //add(index, T element)
    @Override
    public boolean add(int index, T element) {
        //returns false if invalid index or element is being added
        if (index < 0 || index > size()) {
            throw  new IndexOutOfBoundsException("Invalid Index");
        }
        // checks if array length is full and doubles the capacity
        if (array.length == size) {
            doubleCapacity();

        }
        // shift to the right
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];

        }
        array[index] = element;
        size++;
        return true;
    }

    @Override
    public boolean add(T element) {
        // calls the add method with size method as an input to append the element
        return add(size(), element);
    }

    @Override
    public T get(int index) {
        // checks for index if not present or invalid returns
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if(find(array[index]) != -1){
            return array[index];
        }
        else {
            return null;
        }

        }

    @Override
    public boolean contains(T element) {
        // uses the find() method to locate the element if it is present returns true
        if (find(element) != -1) {
            return true;
        } else {
            return false; // otherwise false
        }
    }

    @Override
    public int find(T element) {
        // uses .equals() method to check the element
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1; // returns -1 if element is not found
    }

    @Override
    public T remove(T element) {
        if(size() == 0){
            throw new IndexOutOfBoundsException("Empty list");
        }
        //Locates the element first using the find method
        int position = find(element);
        // if element is present in the list. It then removes it
        if (position != -1) {
            remove(position);
            return element;

        } else {
            //returns null otherwise
            return null;
        }
    }

    @Override
    public T remove(int index) {
        // if list is empty
        if(size() == 0){
            throw new IndexOutOfBoundsException("Empty list");
        }
        // checks for invalid input
        // if invalid or negative inputs
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        T answer = array[index];
        // shift left
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        //decrements size
        size--;
        return answer;
    }

    //clears the whole array
    @Override
    public void clear() {
        size = 0;
    }

    // returns size of the array
    @Override
    public int size() {
        return size;
    }

    // overridden toString method
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}



