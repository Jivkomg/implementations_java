package lists;


import iterator.I_Iterator;

/**
 * Created by zhivkogeorgiev on 7/16/18.
 */
public class LinkedList implements IList {
    private final Element _headAndTail = new Element(null);
    private int _size;

    public LinkedList() {
        clear();
    }

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "value can't be null";
        if (index < 0 || index > _size) {
            throw new IndexOutOfBoundsException();
        }
        Element element = new Element(value);
        element.attachBefore(getElement(index));
        ++_size;
    }

    public Element getElement(int index) {
        Element element = _headAndTail.getNext();
        for (int i = index; i > 0; --i) {
            element = element.getNext();
        }
        return element;
    }

    public void add(Object value) {
        insert(_size, value);
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        return getElement(index).getValue();
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "value can't be null";
        checkOutOfBounds(index);
        Element element = getElement(index);
        Object oldValue = element.getValue();
        element.setValue(value);
        return oldValue;
    }

    public int indexOf(Object value) {
        assert value != null : "value can't be null";
        int index = 0;
        for (Element e = _headAndTail.getNext();
             e != _headAndTail;
             e = e.getNext()) {
            index++;
            if (value.equals(e.getValue())) {
                return index;
            }
        }
        return -1;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Element element = getElement(index);
        element.detach();
        --_size;
        return element.getValue();
    }

    public boolean delete(Object value) {
        assert value != null : "value can't be null";
        for (Element e = _headAndTail.getNext();
             e != _headAndTail;
             e = e.getNext()) {
            if (value.equals(e.getValue())) {
                e.detach();
                _size--;
                return true;
            }
        }
        return false;
    }

    public I_Iterator iterator() {
        return new ValueIterator();
    }

    public int size() {
        return _size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        _headAndTail.setPrevious(_headAndTail);
        _headAndTail.setNext(_headAndTail);
        _size = 0;

    }

    private void checkOutOfBounds(int index) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= _size;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList.indexOf(2));
        System.out.println(linkedList.contains(4));
        System.out.println(linkedList.delete(2));
    }
}
