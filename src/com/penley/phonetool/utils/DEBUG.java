package com.penley.phonetool.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class DEBUG {
	private static boolean debug = true;

	public static void d(String msg) {
		if (debug)
			Log.d("DEBUG", msg);
	}

	public static void toast(Context context, String msg) {
		if (debug)
			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
}
