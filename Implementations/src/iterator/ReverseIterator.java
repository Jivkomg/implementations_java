package iterator;

import java.util.Iterator;

/**
 * Created by zhivkogeorgiev on 7/14/18.
 */
public class ReverseIterator implements I_Iterator {
    private final I_Iterator _iterator;

    //constructor
    public ReverseIterator(I_Iterator iterator) {
        assert iterator != null : "iterator can't be null";
        this._iterator = iterator;
    }
    // methods
    public boolean isDone() {
        return _iterator.isDone();
    }

    public Object current() throws IteratorOutOfBoundsException {
        return _iterator.current();
    }

    public void first() {
        _iterator.last();
    }

    public void last() {
        _iterator.first();
    }

    public void next() {
        _iterator.previous();
    }

    public void previous() {
        _iterator.next();
    }

}
