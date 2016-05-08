package hu.cewi.client.user.ui;

import android.text.TextUtils;

/**
 * Created by Bence on 2016.05.08..
 */
public class Validator {

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
