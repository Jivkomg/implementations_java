package iterator.tasks;

import iterator.I_Iterator;
import iterator.IteratorOutOfBoundsException;

/**
 * Created by zhivkogeorgiev on 7/15/18.
 */
public class EmptyIterator implements I_Iterator{
    public boolean isDone() {
        return true;
    }

    public Object current() throws IteratorOutOfBoundsException {
        throw new IteratorOutOfBoundsException();
    }

    public void first() {
        //Empty
    }

    public void last() {
        //Empty
    }

    public void next() {
        //Empty
    }

    public void previous() {
        //Empty
    }

}
