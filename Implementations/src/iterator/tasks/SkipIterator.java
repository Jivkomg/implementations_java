package iterator.tasks;

import iterator.I_Iterator;
import iterator.IteratorOutOfBoundsException;

/**
 * Created by zhivkogeorgiev on 7/14/18.
 */
public class SkipIterator implements I_Iterator {
    private  final I_Iterator i_iterator;
    private final int _skip;

    public SkipIterator(I_Iterator iterator, int skip){
        assert iterator != null : "iterator can't be null";
        assert skip > 0 : "skip must be positive";

        this.i_iterator = iterator;
        this._skip = skip;
    }

    public void first(){
        i_iterator.first();
        skipForward();
    }
    public void next(){
        i_iterator.next();
        skipForward();
    }
    public void last(){
        i_iterator.last();
        skipBackwards();
    }
    public void previous(){
        i_iterator.previous();
        skipBackwards();
    }

    public boolean isDone(){
        return i_iterator.isDone();
    }
    public Object current() throws IteratorOutOfBoundsException{
        return i_iterator.current();
    }

    private void skipForward() {
        for(int i = 0; i < _skip && !i_iterator.isDone(); i_iterator.next());
    }
    private void skipBackwards() {
        for(int i = 0; i < _skip && !i_iterator.isDone(); i_iterator.previous());
    }

}
