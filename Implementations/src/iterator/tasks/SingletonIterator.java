package iterator.tasks;

import iterator.I_Iterator;


/**
 * Created by zhivkogeorgiev on 7/21/18.
 */
public class SingletonIterator implements I_Iterator {
    private final Object _value;
    private boolean _done;

    public SingletonIterator(Object value) {
        assert value != null : "value can't be null";
        this._value = value;
    }

    public void first(){
        _done = false;
    }

    public void last(){
        _done = false;
    }

    public boolean isDone(){
        return _done;
    }

    public void next(){
        _done = true;
    }

    public void previous(){
        _done = true;
    }

    public Object current() throws IndexOutOfBoundsException{
        if(isDone()){
            throw new IndexOutOfBoundsException();
        }
        return _value;
    }
}
