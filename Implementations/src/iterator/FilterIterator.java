package iterator;

import java.util.function.Predicate;

/**
 * Created by zhivkogeorgiev on 7/14/18.
 */
public class FilterIterator implements I_Iterator {
    private final I_Iterator _iterator;
    private final IPredicate _predicate;

    public FilterIterator(I_Iterator iterator, IPredicate predicate) {
        assert iterator != null : "iterator can't be null";
        assert predicate != null : "predicate can't be null";

        this._iterator = iterator;
        this._predicate = predicate;
    }

    public boolean isDone() {
        return _iterator.isDone();
    }

    public Object current() throws IteratorOutOfBoundsException {
        return _iterator.current();
    }

    public void next() {
        _iterator.next();
        filterForward();
    }

    public void first() {
        _iterator.first();
        filterForward();
    }

    private void filterForward() {
        while (!isDone() && !_predicate.evaluate(_iterator.current())) {
            _iterator.next();
        }
    }

    public void previous() {
        _iterator.previous();
        filterBackwards();
    }

    public void last() {
        _iterator.last();
        filterBackwards();
    }

    private void filterBackwards() {
        while (!isDone() && !_predicate.evaluate(_iterator.current())){
            _iterator.previous();
        }
    }

}
