package com.penley.phonetool.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.penley.phonetool.R;

public class FunctionGridAdapter extends BaseAdapter {
	// 自定义适配器
	// 上下文对象
	private Context context;
	// 图片数组
	private Integer[] imgs = { R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher };

	// 图片描述
	String[] describes;

	public FunctionGridAdapter(Context context) {
		this.context = context;
		Resources res = context.getResources();
		describes = res.getStringArray(R.array.function_describe);
		for (String s : describes)
			System.out.println(s);
		for (int s : imgs)
			System.out.println(s);
	}

	public int getCount() {
		return 7;
	}

	public Object getItem(int item) {
		return item;
	}

	public long getItemId(int id) {
		return id;
	}

	// 创建View方法
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView icon = null;
		TextView describe = null;

		convertView = LayoutInflater.from(context).inflate(R.layout.i_function,
				null);
		icon = (ImageView) convertView.findViewById(R.id.functon_icon_iv);
		describe = (TextView) convertView
				.findViewById(R.id.function_describe_tv);

		// DEBUG.d(imgs[position] + "," + describe[position]);
		icon.setImageResource(imgs[position]);// 为ImageView设置图片资源
		describe.setText(describes[position]);
		return convertView;
	}

	static class ViewHolder {
		ImageView icon;
		TextView describe;
	}

}
