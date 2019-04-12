package by.wiskiw.valuevalidator.operation.check;

import android.content.Context;
import by.wiskiw.valuevalidator.CheckOperation;

/**
 * todo
 *
 * @author Andrey Yablonsky
 */
public class CheckInRange extends CheckOperation<Integer> {

    private int minValue;
    private int maxValue;

    public CheckInRange(String defaultFailedMessage, int minValue, int maxValue) {
        super(defaultFailedMessage);

        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public CheckInRange(Context context, int messageRes, int minValue, int maxValue) {
        super(context, messageRes);

        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public boolean isValueCorrect(Integer value) {
        return minValue <= value && value <= maxValue;
    }
}
