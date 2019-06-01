package lists;

/**
 * Created by zhivkogeorgiev on 7/16/18.
 */
public final class Element {
    private Object _value;
    private Element _previous;
    private Element _next;


    public Element(Object value) {
        setValue(value);
    }

    public void setValue(Object value) {
        this._value = value;
    }

    public Object getValue() {
        return _value;
    }

    public Element getPrevious() {
        return _previous;
    }

    public void setPrevious(Element previous) {
        this._previous = previous;
    }

    public Element getNext() {
        return _next;
    }

    public void setNext(Element next) {
        this._next = next;
    }

    public void attachBefore(Element next) {
        Element previous = next.getPrevious();

        setNext(next);
        setPrevious(previous);

        next.setPrevious(this);
        previous.setNext(this);
    }

    public void detach(){
        _previous.setNext(_next);
        _next.setPrevious(_previous);
    }
}
