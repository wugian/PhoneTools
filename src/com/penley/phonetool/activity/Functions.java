package com.penley.phonetool.activity;

import android.content.Context;

import com.penley.phonetool.utils.DEBUG;
import com.penley.phonetool.utils.Shell;

public class Functions {
	private Context context;

	public Functions(Context context) {
		this.context = context;
	}

	public void reboot() {
		// { "su", "-c", "reboot"};
		String[] cmd = new String[] { "su", "-c", "reboot" };
		Shell shell = new Shell();
		String s = shell.sendShellCommand(cmd);
		DEBUG.d(s);
		DEBUG.toast(context, s);
	}
}
