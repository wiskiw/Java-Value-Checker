package by.wiskiw.fieldsvalidator.demo.validation.inputfetcher;

import android.widget.TextView;

/**
 * todo comments
 *
 * @author Andrey Yablonsky on 20.02.2020
 */
public class TextViewFetcher implements InputValueFetcher<TextView, CharSequence> {

    @Override
    public CharSequence fetch(TextView field) {
        return field.getText();
    }
}
