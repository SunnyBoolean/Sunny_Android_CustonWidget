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
 * @Description: ��ƽ���Ź���ؼ�
 * @date:  2015��4��17��
 */
public class NGridView extends FrameLayout{
	/** �����Ļ���*/
	private Context mContext;
	/** ����Ĭ����3*3�Ź�����ʹ��ʱ��Ҫ��xml��������Ӧ������*/
	private int mDefaultGrid = 3;
    /** ����������Ŀ*/
	private int mRowNumber = mDefaultGrid;
	/** ����������Ŀ*/
	private int mColNumber = mDefaultGrid;
	/** �����ߵ���ɫ*/
    private int mGridSplitColor;	
    
    
	/** �ֻ���Ļ�Ŀ��*/
	private int mScreenWight;
	/** �ֻ���Ļ�ĸ߶�*/
	private int mScreenHeight;
	
	/** ����*/
	private Paint mPaint;
	
	public NGridView(Context context) {
		this(context, null);
		mContext = context;
	}
	public NGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.NGridView);
		//��ȡ����
		mColNumber = a.getInteger(R.styleable.NGridView_grid_col, mDefaultGrid);
		//��ȡ����
		mRowNumber = a.getInteger(R.styleable.NGridView_grid_raw, mDefaultGrid);
		//��ȡ�ָ��ߵ���ɫ
		mGridSplitColor = a.getInteger(R.styleable.NGridView_grid_split_color,0x808080);
		a.recycle();
		initPaint();
		initScreenParameter();
	}
	/**
	 * ��ʼ������
	 */
	private void initPaint(){
		mPaint = new Paint();
		//���������
		mPaint.setAntiAlias(true);
		//������ɫ
		mPaint.setColor(mGridSplitColor);
	}
	/**
	 * ��ʼ����Ļ�ߴ����
	 */
	private void initScreenParameter(){
		WindowManager wm = (WindowManager) mContext
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		//��ȡ��Ļ��
		mScreenHeight = outMetrics.heightPixels;
		//��ȡ��Ļ��
		mScreenWight = outMetrics.widthPixels;
	}
   
	
}
