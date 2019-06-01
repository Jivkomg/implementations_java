package iterator;

/**
 * Created by zhivkogeorgiev on 7/14/18.
 */
public interface I_Iterator {
    public void first();

    public void last();

    public boolean isDone();

    public void next();

    public void previous();

    public Object current() throws IteratorOutOfBoundsException;
}
