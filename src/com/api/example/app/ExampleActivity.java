package com.api.example.app;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabWidget;
import android.widget.TextView;

import com.api.R;
import com.api.TabHostActivity;

/**
 * <p>整个流程就像使用ListView自定BaseAdapter一样</p>
 * 
 * <p>如果要自定义TabHostActivity的Theme，并且不想要头部阴影
 * 一定要添加这个android:windowContentOverlay = null</p>
 * 
 * <p>如果想在别的项目里面使用TabHostActivity
 * 可以项目的属性里面找到Android，然后在Library部分添加这个项目(Api)
 * <a href="http://www.cnblogs.com/qianxudetianxia/archive/2011/05/01/2030232.html">如何添加</a></p>
 * */
public class ExampleActivity extends TabHostActivity {

	List<TabItem> mItems;
	private LayoutInflater mLayoutInflater;
	
	/**在初始化TabWidget前调用
	 * 和TabWidget有关的必须在这里初始化*/
	@Override
	protected void prepare() {
		TabItem home = new TabItem(
				"首页",									// title
				R.drawable.icon_home,					// icon
				R.drawable.example_tab_item_bg,			// background
				new Intent(this, Tab1Activity.class));	// intent
		
		TabItem info = new TabItem(
				"资料",
				R.drawable.icon_selfinfo,
				R.drawable.example_tab_item_bg,
				new Intent(this, Tab2Activity.class));
		
		TabItem msg = new TabItem(
				"信息",
				R.drawable.icon_meassage,
				R.drawable.example_tab_item_bg,
				new Intent(this, Tab3Activity.class));
		
		TabItem square = new TabItem(
				"广场",
				R.drawable.icon_square,
				R.drawable.example_tab_item_bg,
				new Intent(this, Tab4Activity.class));
		
		TabItem more = new TabItem(
				"更多",
				R.drawable.icon_more,
				R.drawable.example_tab_item_bg,
				new Intent(this, Tab5Activity.class));
		
		mItems = new ArrayList<TabItem>();
		mItems.add(home);
		mItems.add(info);
		mItems.add(msg);
		mItems.add(square);
		mItems.add(more);

		// 设置分割线
		TabWidget tabWidget = getTabWidget();
		tabWidget.setDividerDrawable(R.drawable.tab_divider);
		
		mLayoutInflater = getLayoutInflater();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setCurrentTab(0);
	}
	
	/**tab的title，icon，边距设定等等*/
	@Override
	protected void setTabItemTextView(TextView textView, int position) {
		textView.setPadding(3, 3, 3, 3);
		textView.setText(mItems.get(position).getTitle());
		textView.setBackgroundResource(mItems.get(position).getBg());
		textView.setCompoundDrawablesWithIntrinsicBounds(0, mItems.get(position).getIcon(), 0, 0);
		
	}
	
	/**tab唯一的id*/
	@Override
	protected String getTabItemId(int position) {
		return mItems.get(position).getTitle();	// 我们使用title来作为id，你也可以自定
	}

	/**点击tab时触发的事件*/
	@Override
	protected Intent getTabItemIntent(int position) {
		return mItems.get(position).getIntent();
	}

	@Override
	protected int getTabItemCount() {
		return mItems.size();
	}
	
	/**自定义头部文件*/
	@Override
	protected View getTop() {
		return mLayoutInflater.inflate(R.layout.example_top, null);
	}

}
