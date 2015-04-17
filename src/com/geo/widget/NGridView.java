/**
 * 
 */
package com.geo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.geo.ui.R;

/**
 * @author:  liwei
 * @Description: 扁平化九宫格控件
 * @date:  2015年4月17日
 */
public class NGridView extends FrameLayout{
	/** 上下文环境*/
	private Context mContext;
	/** 容器默认是3*3九宫格，在使用时需要在xml中设置相应的属性*/
	private int mDefaultGrid = 3;
    /** 容器的行数目*/
	private int mRowNumber = mDefaultGrid;
	/** 容器的列数目*/
	private int mColNumber = mDefaultGrid;
	/** 格子线的颜色*/
    private int mGridSplitColor;	
    
    
	/** 手机屏幕的宽度*/
	private int mScreenWight;
	/** 手机屏幕的高度*/
	private int mScreenHeight;
	
	/** 画笔*/
	private Paint mPaint;
	
	public NGridView(Context context) {
		this(context, null);
		mContext = context;
	}
	public NGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.NGridView);
		//获取列数
		mColNumber = a.getInteger(R.styleable.NGridView_grid_col, mDefaultGrid);
		//获取行数
		mRowNumber = a.getInteger(R.styleable.NGridView_grid_raw, mDefaultGrid);
		//获取分割线的颜色
		mGridSplitColor = a.getInteger(R.styleable.NGridView_grid_split_color,0x808080);
		a.recycle();
		initPaint();
		initScreenParameter();
	}
	/**
	 * 初始化画笔
	 */
	private void initPaint(){
		mPaint = new Paint();
		//开启抗锯齿
		mPaint.setAntiAlias(true);
		//设置颜色
		mPaint.setColor(mGridSplitColor);
	}
	/**
	 * 初始化屏幕尺寸参数
	 */
	private void initScreenParameter(){
		WindowManager wm = (WindowManager) mContext
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		//获取屏幕高
		mScreenHeight = outMetrics.heightPixels;
		//获取屏幕宽
		mScreenWight = outMetrics.widthPixels;
	}
   
	
}
