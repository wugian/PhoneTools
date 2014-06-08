package com.penley.phonetool.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.penley.phonetool.R;
import com.penley.phonetool.adapter.FunctionGridAdapter;
import com.penley.phonetool.utils.BasicFunction;
import com.penley.phonetool.utils.DEBUG;

public class MainActivity extends Activity implements OnItemClickListener {

	GridView gr;
	FunctionGridAdapter adapter;
	Context context = this;
	private boolean ligntOn = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// no title bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// no action bar
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.a_main);
		gr = (GridView) findViewById(R.id.gridView1);
		adapter = new FunctionGridAdapter(context);
		gr.setAdapter(adapter);
		gr.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int arg2, long arg3) {
		Log.d("DEBUG", view + "," + arg2 + "," + arg3);
		BasicFunction function = new BasicFunction(this.getApplicationContext());
		switch (arg2) {
		case 0:
			function.reboot();
			break;
		case 1:
			if (!ligntOn) {
				DEBUG.d("true");
				function.openLight();
			} else {
				DEBUG.d("false");
				function.closeLight();
			}
			ligntOn = !ligntOn;
			break;
		case 2:
			function.shutDown();
		default:
			break;
		}
	}
}
