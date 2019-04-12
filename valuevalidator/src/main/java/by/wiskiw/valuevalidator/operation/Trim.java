package by.wiskiw.valuevalidator.operation;

import by.wiskiw.valuevalidator.Operation;

/**
 * @author Andrey Yablonsky
 */
public class Trim extends Operation<String, String> {

    public Trim() {
        super("");
    }

    @Override
    public String run(String input) {
        return input.trim();
    }
}
