package lists;

import iterator.ArrayIterator;
import iterator.I_Iterator;

/**
 * Created by zhivkogeorgiev on 7/15/18.
 */
public class ArrayList implements IList {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private final int _initialCapacity;
    private Object[] _array;
    private int _size;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        assert initialCapacity > 0 : "initialCapacity bust be > 0";
        this._initialCapacity = initialCapacity;
        clear();
    }

    //////////////////////////////////////////////////
    // task
    public ArrayList(Object[] array) {
        assert array != null : "array can't be null";
        this._initialCapacity = array.length;
        clear();
        System.arraycopy(array, 0, _array, 0, _initialCapacity);
        _size = array.length;
    }
    //////////////////////////////////////////////////

    public void clear() {
        _array = new Object[_initialCapacity];
        _size = 0;
    }

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "value can't be null";

        if (index < 0 || index > _size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(_size + 1);
        System.arraycopy(_array, index, _array, index + 1, _size - index);
        _array[index] = value;
        ++_size;
    }

    private void ensureCapacity(int capacity) {
        assert capacity > 0 : "capacity must be > 0";

        if (_array.length < capacity) {
            Object[] copy = new Object[capacity + capacity / 2];
            System.arraycopy(_array, 0, copy, 0, _size);
            _array = copy;
        }
    }

    public void add(Object value) {
        insert(_size, value);
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        return _array[index];
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "value can't be null";
        checkOutOfBounds(index);
        Object oldValue = _array[index];
        _array[index] = value;
        return oldValue;
    }

    private void checkOutOfBounds(int index) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= _size;
    }

    public int indexOf(Object value) {
        assert value != null : "value can't be null";
        int result = -1;
        for (int i = 0; i < _array.length; i++) {
            if (_array[i].equals(value)) {
                result = i;
                break;
            }
        }
        return result;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Object value = _array[index];
        System.arraycopy(_array, index + 1, _array, index, _size - index + 1);
        _array[--_size] = null;
        return value;
    }

    public boolean delete(Object value) {
        boolean hasValue = contains(value);
        if (hasValue) {
            delete(indexOf(value));
        }
        return hasValue;
    }

    public I_Iterator iterator() {
        return new ArrayIterator(_array, 0, _size - 1, _size);
    }

    public int size() {
        return _size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(6);
        System.out.println(arrayList.get(1));
    }
}
