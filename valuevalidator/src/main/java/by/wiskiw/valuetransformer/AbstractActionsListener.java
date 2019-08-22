package by.wiskiw.valuetransformer;

/**
 * @author Andrey Yablonsky
 */
public abstract class AbstractActionsListener<T> implements ActionsExecutor.Listener<T> {

    @Override
    public void onSuccess(T value) {

    }

    @Override
    public void onError(ChainActionException convertException) {

    }
}
