package iterator;

import java.util.Iterator;

/**
 * Created by zhivkogeorgiev on 7/14/18.
 */
public class ArrayIterator implements I_Iterator{
    private final Object[] _array;
    private final int _start;
    private final int _end;
    private int _current = -1;

    // constructors
    // partial iteration
    public ArrayIterator(Object[] array, int start, int end, int length){
        assert array != null : "array can't be null";
        assert start >=0 : "start can't be null";
        assert start < array.length : "start can't be > array.length";
        assert length >= 0 : "length can't be < 0 ";

        this._array = array;
        this._start = start;
        this._end = start + length - 1;
        assert _end < array.length : "start + length can't be > array.length";
    }

    // whole array iteration
    public ArrayIterator(Object[] array){
        assert array != null : "array can't be null";
        this._array = array;
        this._start = 0;
        this._end = array.length - 1;
    }
    //methods
    public void first(){
        _current = _start;
    }
    public void last(){
        _current = _end;
    }
    public void next(){
        ++_current;
    }
    public void previous(){
        --_current;
    }
    public boolean isDone(){
        return _current < _start || _current > _end;
    }
    public Object current() throws IteratorOutOfBoundsException{
        if(isDone()){
            throw new IteratorOutOfBoundsException();
        }
        return _array[_current];
    }


}
