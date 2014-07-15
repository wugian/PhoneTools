package com.penley.phonetool.utils;

import java.lang.reflect.Method;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.IBinder;
import android.os.IHardwareService;

public class BasicFunction {
	private Context context;
	private Camera camera = null;
	private Parameters parameters = null;

	public BasicFunction(Context context) {
		this.context = context;
	}

	public void reboot() {
		String[] cmd = new String[] { "su", "-c", "reboot" };
		Shell shell = new Shell();
		// String s =
		shell.sendShellCommand(cmd);
		// DEBUG.d(s);
		// DEBUG.toast(context, s);
	}

	public void openLight() {
		openLightOn();
		// setFlashlightEnabled(true);
	}

	public void closeLight() {
		closeLightOff();
		// setFlashlightEnabled(false);
	}

	/**
	 * 设置闪光灯的开启和关闭
	 * 
	 * @param isEnable
	 * @author linc
	 * @date 2012-3-18
	 */
	private void setFlashlightEnabled(boolean isEnable) {
		try {
			Method method = Class.forName("android.os.ServiceManager")
					.getMethod("getService", String.class);
			IBinder binder = (IBinder) method.invoke(null,
					new Object[] { "hardware" });

			IHardwareService localhardwareservice = IHardwareService.Stub
					.asInterface(binder);
			localhardwareservice.setFlashlightEnabled(isEnable);
			DEBUG.d("set enable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void openLightOn() {
		if (null == camera) {
			camera = Camera.open();
		}

		Camera.Parameters parameters = camera.getParameters();
		parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
		camera.setParameters(parameters);
		camera.autoFocus(new Camera.AutoFocusCallback() {
			public void onAutoFocus(boolean success, Camera camera) {
			}
		});
		camera.startPreview();
	}

	private void closeLightOff() {
		if (camera != null) {
			camera.stopPreview();
			camera.release();
			camera = null;
		}
	}

	public void shutDown() {
		// "su", "-c",
		// if just shutdown ,this app will be closed;if su -c shutdown this
		// system will be shutdown
		String[] cmd = new String[] { "su", "-c", "shutdown" };
		Shell shell = new Shell();
		shell.sendShellCommand(cmd); 
	}
	public void openLight()   //打开闪光灯
    {
        if(camera!=null)
        {
             Parameters parameter=camera.getParameters();  
             parameter.setFlashMode(Parameters.FLASH_MODE_TORCH); 
             camera.setParameters(parameter);
        }
    }
    
    public void closeLight()  //关闭闪光灯
    {
        if(camera!=null)
        {
             Parameters parameter=camera.getParameters();  
             parameter.setFlashMode(Parameters.FLASH_MODE_OFF); 
             camera.setParameters(parameter);
        }
    }
}
