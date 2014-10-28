package com.stef.loan;

import java.math.BigDecimal;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

public class MyTab extends TabActivity {

	private TabHost myTabhost;
	private Menu myMenu;
	private static int myMenuSettingTag = 0;

	private EditText lvvv1;
	private EditText zev1;
	private Spinner nxv1;
	private Spinner lvv1;
	private Button sub1;
	private Button cancel1;

	private EditText lvvvj1;
	private EditText zevj1;
	private Spinner nxvj1;
	private Button subj1;
	private Button cancelj1;

	private Spinner nxvx1;
	private EditText zevx1;
	private EditText lvvvx1;
	private EditText zevx2;
	private Spinner lvvx2;
	private EditText lvvvx2;
	private Button subx1;
	private Button cancelx1;

	private TextView am10;
	private TextView am20;
	private TextView am11;
	private TextView am21;
	private TextView am12;
	private TextView am22;
	private TextView am13;
	private TextView am23;
	private TextView am14;
	private TextView am24;

	private static final String[] nx = { "1", "2", "3", "4", "5", "10", "15",
			"20", "25", "30" };
	private static final String[] lv = { "最新基准利率7折", "最新基准利率7.5折", "最新基准利率8折",
			"最新基准利率8.5折", "最新基准利率9折", "最新基准利率9.5折", "最新基准利率", "最新基准利率1.1倍",
			"最新基准利率1.2倍", "最新基准利率1.3倍" };

	String mykey = "echokey"; // key
	String defaultValue = null; // 默认的 value，当获取不到在线参数时，会返回该值

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		myTabhost = this.getTabHost();// 从TabActivity上面获取放置Tab的TabHost
		LayoutInflater.from(this).inflate(R.layout.main,
				myTabhost.getTabContentView(), true);
		// from(this)从这个TabActivity获取LayoutInflater
		// R.layout.main 存放Tab布局
		// 通过TabHost获得存放Tab标签页内容的FrameLayout
		// 是否将inflate 拴系到根布局元素上
		myTabhost.setBackgroundColor(Color.argb(100, 236, 236, 236));
		// 设置一下TabHost的颜色

		myTabhost.addTab(myTabhost.newTabSpec("T1")// 制造一个新的标签TT
				.setIndicator("商业贷款")
				// 设置一下显示的标题为KK，设置一下标签图标为ajjc
				.setContent(R.id.widget_layout_sy));
		// 设置一下该标签页的布局内容为R.id.widget_layout_red，这是FrameLayout中的一个子Layout

		myTabhost.addTab(myTabhost.newTabSpec("T2")// 制造一个新的标签TT
				.setIndicator("公积金贷款")
				// 设置一下显示的标题为KK，设置一下标签图标为ajjc
				.setContent(R.id.widget_layout_gjj));

		myTabhost.addTab(myTabhost.newTabSpec("T3")// 制造一个新的标签TT
				.setIndicator("混合贷款")
				// 设置一下显示的标题为KK，设置一下标签图标为ajjc
				.setContent(R.id.widget_layout_mix));

		sy();

		myTabhost.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
			public void onTabChanged(String tagString) {
				Log.v("bbb", tagString);
				if (tagString.equals("T1")) {
					myMenuSettingTag = 1;
					sy();
				}
				if (tagString.equals("T2")) {
					myMenuSettingTag = 2;
					gjj();
				}
				if (tagString.equals("T3")) {
					myMenuSettingTag = 3;
					mix();
				}
				if (myMenu != null) {
					onCreateOptionsMenu(myMenu);
				}
			}
		});
	}

	public void mix() {
		init();
		clear();
		nxvx1 = (Spinner) findViewById(R.id.nxvx1);
		zevx1 = (EditText) findViewById(R.id.zevx1);
		lvvvx1 = (EditText) findViewById(R.id.lvvvx1);
		zevx2 = (EditText) findViewById(R.id.zevx2);
		lvvx2 = (Spinner) findViewById(R.id.lvvx2);
		lvvvx2 = (EditText) findViewById(R.id.lvvvx2);
		subx1 = (Button) findViewById(R.id.subx1);
		cancelx1 = (Button) findViewById(R.id.cancelx1);

		// 将可选内容与ArrayAdapter连接起来
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, nx);
		// 设置下拉列表的风格
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 将adapter 添加到spinner中
		nxvx1.setAdapter(adapter);
		nxvx1.setSelection(7, true);
		// 设置默认值
		nxvx1.setVisibility(View.VISIBLE);
		// 添加事件Spinner事件监听
		nxvx1.setOnItemSelectedListener(new SpinnerSelectedListener1(lvvvx1));

		// 将可选内容与ArrayAdapter连接起来
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, lv);
		// 设置下拉列表的风格
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 将adapter 添加到spinner中
		lvvx2.setAdapter(adapter1);
		lvvx2.setSelection(6, true);
		// 设置默认值
		lvvx2.setVisibility(View.VISIBLE);
		// 添加事件Spinner事件监听
		lvvx2.setOnItemSelectedListener(new SpinnerSelectedListener(lvvvx2));

		this.subx1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Editable value = zevx1.getText();
				if (value.toString() == null || value.toString().length() <= 0) {
					new AlertDialog.Builder(MyTab.this).setTitle("提示")
							.setMessage("公积金贷款总额不能为空")
							.setPositiveButton("OK", null).show();
					return;
				}

				Editable value1 = zevx2.getText();
				if (value1.toString() == null
						|| value1.toString().length() <= 0) {
					new AlertDialog.Builder(MyTab.this).setTitle("提示")
							.setMessage("商业贷款总额不能为空")
							.setPositiveButton("OK", null).show();
					return;
				}

				Editable value2 = lvvvx1.getText();
				if (value2.toString() == null
						|| value2.toString().length() <= 0) {
					new AlertDialog.Builder(MyTab.this).setTitle("提示")
							.setMessage("公积金利率不能为空")
							.setPositiveButton("OK", null).show();
					return;
				}

				Editable value3 = lvvvx2.getText();
				if (value3.toString() == null
						|| value3.toString().length() <= 0) {
					new AlertDialog.Builder(MyTab.this).setTitle("提示")
							.setMessage("商贷利率不能为空")
							.setPositiveButton("OK", null).show();
					return;
				}

				double nx = Double.parseDouble(nxvx1.getSelectedItem()
						.toString()) * 12;
				double ze = Double.parseDouble(value.toString());
				double rate = Double.parseDouble(lvvvx1.getText().toString()) / 100;
				double ze1 = Double.parseDouble(value1.toString());
				double rate1 = Double.parseDouble(lvvvx2.getText().toString()) / 100;

				cal(ze, nx, rate, ze1, rate1);

			}

		});

		this.cancelx1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				zevx1.setText("");
				zevx2.setText("");
				nxvx1.setSelection(7, true);
				lvvx2.setSelection(6, true);
			}
		});
	}

	public void gjj() {
		init();
		clear();
		zevj1 = (EditText) findViewById(R.id.zevj1);
		nxvj1 = (Spinner) findViewById(R.id.nxvj1);
		lvvvj1 = (EditText) findViewById(R.id.lvvvj1);
		subj1 = (Button) findViewById(R.id.subj1);
		cancelj1 = (Button) findViewById(R.id.cancelj1);
		// 将可选内容与ArrayAdapter连接起来
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, nx);
		// 设置下拉列表的风格
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 将adapter 添加到spinner中
		nxvj1.setAdapter(adapter);
		nxvj1.setSelection(7, true);
		// 设置默认值
		nxvj1.setVisibility(View.VISIBLE);
		// 添加事件Spinner事件监听
		nxvj1.setOnItemSelectedListener(new SpinnerSelectedListener1(lvvvj1));

		this.subj1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Editable value = zevj1.getText();
				if (value.toString() == null || value.toString().length() <= 0) {
					new AlertDialog.Builder(MyTab.this).setTitle("提示")
							.setMessage("贷款总额不能为空")
							.setPositiveButton("OK", null).show();
					return;
				}
				Editable value1 = lvvvj1.getText();
				if (value1.toString() == null
						|| value1.toString().length() <= 0) {
					new AlertDialog.Builder(MyTab.this).setTitle("提示")
							.setMessage("利率不能为空").setPositiveButton("OK", null)
							.show();
					return;
				}

				double ze = Double.parseDouble(value.toString());
				double nx = Double.parseDouble(nxvj1.getSelectedItem()
						.toString()) * 12;
				double rate = Double.parseDouble(lvvvj1.getText().toString()) / 100;

				cal(ze, nx, rate);

			}

		});

		this.cancelj1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				zevj1.setText("");
				nxvj1.setSelection(7, true);
			}
		});
	}

	public void sy() {
		init();
		clear();
		zev1 = (EditText) findViewById(R.id.zev1);
		nxv1 = (Spinner) findViewById(R.id.nxv1);
		lvv1 = (Spinner) findViewById(R.id.lvv1);
		lvvv1 = (EditText) findViewById(R.id.lvvv1);
		sub1 = (Button) findViewById(R.id.sub1);
		cancel1 = (Button) findViewById(R.id.cancel1);
		// 将可选内容与ArrayAdapter连接起来
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, nx);
		// 设置下拉列表的风格
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 将adapter 添加到spinner中
		nxv1.setAdapter(adapter);
		nxv1.setSelection(7, true);
		// 设置默认值
		nxv1.setVisibility(View.VISIBLE);

		// 将可选内容与ArrayAdapter连接起来
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, lv);
		// 设置下拉列表的风格
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 将adapter 添加到spinner中
		lvv1.setAdapter(adapter1);
		lvv1.setSelection(6, true);
		// 设置默认值
		lvv1.setVisibility(View.VISIBLE);
		// 添加事件Spinner事件监听
		lvv1.setOnItemSelectedListener(new SpinnerSelectedListener(lvvv1));

		this.sub1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Editable value = zev1.getText();
				if (value.toString() == null || value.toString().length() <= 0) {
					new AlertDialog.Builder(MyTab.this).setTitle("提示")
							.setMessage("贷款总额不能为空")
							.setPositiveButton("OK", null).show();
					return;
				}
				Editable value1 = lvvv1.getText();
				if (value1.toString() == null
						|| value1.toString().length() <= 0) {
					new AlertDialog.Builder(MyTab.this).setTitle("提示")
							.setMessage("利率不能为空").setPositiveButton("OK", null)
							.show();
					return;
				}

				double ze = Double.parseDouble(value.toString());
				double nx = Double.parseDouble(nxv1.getSelectedItem()
						.toString()) * 12;
				double rate = Double.parseDouble(lvvv1.getText().toString()) / 100;

				cal(ze, nx, rate);

			}

		});

		this.cancel1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				zev1.setText("");
				nxv1.setSelection(7, true);
				lvv1.setSelection(6, true);
			}
		});
	}

	public void cal(double ze, double nx, double rate) {
		double zem = (ze * rate / 12 * Math.pow((1 + rate / 12), nx))
				/ (Math.pow((1 + rate / 12), nx) - 1);
		double amount = zem * nx;
		double rateAmount = amount - ze;

		BigDecimal zemvalue = new BigDecimal(zem);
		double zemval = zemvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
				.doubleValue();

		BigDecimal amountvalue = new BigDecimal(amount);
		double amountval = amountvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
				.doubleValue();

		BigDecimal rateAmountvalue = new BigDecimal(rateAmount);
		double rateAmountval = rateAmountvalue.setScale(2,
				BigDecimal.ROUND_HALF_UP).doubleValue();

		double benjinm = ze / nx;
		double lixim = ze * (rate / 12);
		double diff = benjinm * (rate / 12);
		double huankuanm = benjinm + lixim;
		double zuihoukuan = diff + benjinm;
		double av = (huankuanm + zuihoukuan) / 2;
		double zong = av * nx;
		double zongli = zong - ze;

		BigDecimal huankuanmvalue = new BigDecimal(huankuanm);
		double huankuanmval = huankuanmvalue.setScale(2,
				BigDecimal.ROUND_HALF_UP).doubleValue();

		BigDecimal diffvalue = new BigDecimal(diff);
		double diffmval = diffvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
				.doubleValue();

		BigDecimal zongvalue = new BigDecimal(zong);
		double zongval = zongvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
				.doubleValue();

		BigDecimal zonglivalue = new BigDecimal(zongli);
		double zonglival = zonglivalue.setScale(2, BigDecimal.ROUND_HALF_UP)
				.doubleValue();

		am10.setText(ze + "元");
		am20.setText(ze + "元");

		am11.setText(nx + "月");
		am21.setText(nx + "月");

		am12.setText(zemval + "元");
		am22.setText("首月" + huankuanmval + ",月减" + diffmval);

		am13.setText(rateAmountval + "元");
		am23.setText(zonglival + "元");

		am14.setText(amountval + "元");
		am24.setText(zongval + "元");
	}

	public void cal(double ze, double nx, double rate, double ze1, double rate1) {
		double zem = (ze * rate / 12 * Math.pow((1 + rate / 12), nx))
				/ (Math.pow((1 + rate / 12), nx) - 1);
		double amount = zem * nx;
		double rateAmount = amount - ze;

		double zem1 = (ze1 * rate1 / 12 * Math.pow((1 + rate1 / 12), nx))
				/ (Math.pow((1 + rate1 / 12), nx) - 1);
		double amount1 = zem1 * nx;
		double rateAmount1 = amount1 - ze1;

		BigDecimal zemvalue = new BigDecimal(zem + zem1);
		double zemval = zemvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
				.doubleValue();

		BigDecimal amountvalue = new BigDecimal(amount + amount1);
		double amountval = amountvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
				.doubleValue();

		BigDecimal rateAmountvalue = new BigDecimal(rateAmount + rateAmount1);
		double rateAmountval = rateAmountvalue.setScale(2,
				BigDecimal.ROUND_HALF_UP).doubleValue();

		double benjinm = ze / nx;
		double lixim = ze * (rate / 12);
		double diff = benjinm * (rate / 12);
		double huankuanm = benjinm + lixim;
		double zuihoukuan = diff + benjinm;
		double av = (huankuanm + zuihoukuan) / 2;
		double zong = av * nx;
		double zongli = zong - ze;

		double benjinm1 = ze1 / nx;
		double lixim1 = ze1 * (rate1 / 12);
		double diff1 = benjinm1 * (rate1 / 12);
		double huankuanm1 = benjinm1 + lixim1;
		double zuihoukuan1 = diff1 + benjinm1;
		double av1 = (huankuanm1 + zuihoukuan1) / 2;
		double zong1 = av1 * nx;
		double zongli1 = zong1 - ze1;

		BigDecimal huankuanmvalue = new BigDecimal(huankuanm + huankuanm1);
		double huankuanmval = huankuanmvalue.setScale(2,
				BigDecimal.ROUND_HALF_UP).doubleValue();

		BigDecimal diffvalue = new BigDecimal(diff + diff1);
		double diffmval = diffvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
				.doubleValue();

		BigDecimal zongvalue = new BigDecimal(zong + zong1);
		double zongval = zongvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
				.doubleValue();

		BigDecimal zonglivalue = new BigDecimal(zongli + zongli1);
		double zonglival = zonglivalue.setScale(2, BigDecimal.ROUND_HALF_UP)
				.doubleValue();

		am10.setText((ze + ze1) + "元");
		am20.setText((ze + ze1) + "元");

		am11.setText(nx + "月");
		am21.setText(nx + "月");

		am12.setText(zemval + "元");
		am22.setText("首月" + huankuanmval + ",月减" + diffmval);

		am13.setText(rateAmountval + "元");
		am23.setText(zonglival + "元");

		am14.setText(amountval + "元");
		am24.setText(zongval + "元");
	}

	public void init() {
		am10 = (TextView) findViewById(R.id.am10);
		am20 = (TextView) findViewById(R.id.am20);
		am11 = (TextView) findViewById(R.id.am11);
		am21 = (TextView) findViewById(R.id.am21);
		am12 = (TextView) findViewById(R.id.am12);
		am22 = (TextView) findViewById(R.id.am22);
		am13 = (TextView) findViewById(R.id.am13);
		am23 = (TextView) findViewById(R.id.am23);
		am14 = (TextView) findViewById(R.id.am14);
		am24 = (TextView) findViewById(R.id.am24);
	}

	public void clear() {
		am10.setText(0 + "元");
		am20.setText(0 + "元");

		am11.setText(0 + "月");
		am21.setText(0 + "月");

		am12.setText(0 + "元");
		am22.setText(0 + "元");

		am13.setText(0 + "元");
		am23.setText(0 + "元");

		am14.setText(0 + "元");
		am24.setText(0 + "元");
	}

	public double getlvv1(int a) {
		double value = 6.55f;
		switch (a) {
		case 0:
			value = 6.55 * 0.7;
			return value;
		case 1:
			value = 6.55 * 0.75;
			return value;
		case 2:
			value = 6.55 * 0.8;
			return value;
		case 3:
			value = 6.55 * 0.85;
			return value;
		case 4:
			value = 6.55 * 0.9;
			return value;
		case 5:
			value = 6.55 * 0.95;
			return value;
		case 6:
			value = 6.55 * 1;
			return value;
		case 7:
			value = 6.55 * 1.1;
			return value;
		case 8:
			value = 6.55 * 1.2;
			return value;
		case 9:
			value = 6.55 * 1.3;
			return value;
		default:
			return value;
		}

	}

	class SpinnerSelectedListener implements OnItemSelectedListener {

		EditText et;

		public SpinnerSelectedListener(EditText et) {
			this.et = et;
		}

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			et.setText(new BigDecimal(getlvv1(position)).setScale(2,
					BigDecimal.ROUND_HALF_DOWN).toString());
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
		}

	}

	class SpinnerSelectedListener1 implements OnItemSelectedListener {

		EditText et;

		public SpinnerSelectedListener1(EditText et) {
			this.et = et;
		}

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			if (position <= 4)
				et.setText(String.format("%.02f", 4.0));
			else
				et.setText(String.format("%.02f", 4.5));
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
		}

	}

	static final int ABOUT = Menu.FIRST;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, ABOUT, 0, "关于");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case ABOUT:
			Intent intent = new Intent(this, About.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}