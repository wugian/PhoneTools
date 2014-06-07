package com.penley.phonetool.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.penley.phonetool.R;
import com.penley.phonetool.adapter.FunctionGridAdapter;

public class MainActivity extends Activity implements OnItemClickListener {

	GridView gr;
	FunctionGridAdapter adapter;
	Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Log.d("DEBUG", arg1 + "," + arg2 + "," + arg3);
		Functions function = new Functions(this.getApplicationContext());
		switch (arg2) {
		case 0:
			function.reboot();
			break;
		default:
			break;
		}
	}
}
