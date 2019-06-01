package iterator.tasks;

import iterator.IPredicate;

/**
 * Created by zhivkogeorgiev on 7/15/18.
 */
public class AndPredicate implements IPredicate {
    private final IPredicate _left;
    private final IPredicate _right;

    public AndPredicate(IPredicate left, IPredicate right){
        assert left != null : "left can't be null";
        assert right != null : "right can't be null";
        this._left = left;
        this._right = right;
    }
    public boolean evaluate(Object object){
        return _left.evaluate(object) && _right.evaluate(object);
    }

}
