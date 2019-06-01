package lists;

import iterator.I_Iterator;

/**
 * Created by zhivkogeorgiev on 7/17/18.
 */
public final class ValueIterator implements I_Iterator{
    //this line to be removed
    private final Element _headAndTail = new Element(null);
    //
    private Element _current = _headAndTail;

    public void first(){
        _current = _headAndTail.getNext();
    }
    public void last(){
        _current = _headAndTail.getPrevious();
    }
    public boolean isDone(){
        return _current == _headAndTail;
    }
    public void next(){
        _current = _current.getNext();
    }
    public void previous(){
        _current = _current.getPrevious();
    }
    public Object current() throws IndexOutOfBoundsException{
        if(isDone()){
            throw new IndexOutOfBoundsException();
        }
        return _current.getValue();
    }


}
