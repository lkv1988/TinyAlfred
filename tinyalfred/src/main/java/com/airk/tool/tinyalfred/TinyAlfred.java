package com.airk.tool.tinyalfred;

import android.app.Activity;
import android.util.Log;

/**
 * Created by kevin on 15/3/17.
 */
public class TinyAlfred {
    private static final String TAG = TinyAlfred.class.getSimpleName();

    public static final String SUFFIX = "$$Alfred";

    public static void process(Activity activity) {
        process(activity, activity);
    }

    public static void process(Object belong, Object root) {
        try {
            Class<?> clazz = Class.forName(belong.getClass().getName() + SUFFIX);
            Log.d(TAG, belong.getClass().getName());
            Alfred alfred = (Alfred) clazz.newInstance();
            alfred.handleViews(belong, root);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
