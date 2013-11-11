package com.android.game.animation;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.android.game.bitmap.MyBitmap;
import com.android.game.constant.UIDefaultData;

/*
MaskAnimation���ֶ���
һ�Ű�͸��ͼƬ����С����ʧ�����ڼ�����ȴЧ��
*/

public class MaskAnimation implements MyAnimation{
	
	private MyBitmap bmp;
	private String str_name;
	private int i_frame;        //֡��
	private int i_current;      //��ǰ֡
	private int i_interval;     //ÿ֡���ʱ�䣨����35ms��
	private int i_control;      //���ڿ��Ʋ���
	private int i_height;     //��ǰ��ʾ�߶�
	Rect rect_dst;
	Rect rect_src;
	
	public MaskAnimation( String name, int frame ){
		str_name = name;
		i_frame = frame;
		i_interval = 0;
		i_current = i_control = 0;
		bmp = UIDefaultData.container_bmp.getBitmap(name);
		i_height = 0;
		rect_src = new Rect();
		rect_dst = new Rect();
		rect_src.bottom = bmp.getHeight();
		rect_src.left = 0;
		rect_src.right = bmp.getWidth();
	}
	
	public MaskAnimation( MyAnimation ani ){
		str_name = ani.getName();
		i_frame = ani.getFrame();
		i_interval = ani.getInterval();
		bmp = UIDefaultData.container_bmp.getBitmap( str_name );
		i_current = i_control = 0;
		i_height = 0;
	}

	public String getName() {
		return str_name;
	}
	
	public String getType(){
		return "MaskAnimation";
	}
	
	public int getFrame() {
		return i_frame;
	}
	
	public void setInterval( int interval ){
		this.i_interval = interval;
	}

	public int getInterval() {
		return i_interval;
	}
	
	public int getHeight(){
		return bmp.getHeight();
	}
	
	public int getWidth(){
		return bmp.getWidth();
	}
	
	public void setColdingTime( int time ){
		i_interval = time / i_frame;
	}
	
	public boolean isEndAnCirculation() {
		return isEnd();
	}

	public boolean isEnd() {
		if( i_current == -1 )
			return true;
		return false;
	}
	
	public void nextFrame() {
		//���Ʋ��Ž���
		i_control += UIDefaultData.DRAW_INTERVAL;
		if( i_control >= i_interval ){
			i_current ++;
			i_height += ( bmp.getHeight() / i_frame );
			i_control -= i_interval;
		}
		//�ж��Ƿ񲥷���
		if( i_current >= i_frame || i_height >= bmp.getHeight() ){
			i_current = -1;
		}
	}
	
	public void start(){
		i_current = 0;
		i_control = 0;
		i_height = 0;
	}
	
	public void end(){
		i_current = -1;
	}
	
	public void draw(Canvas canvas, int cx, int cy ) {
		if( i_current < i_frame ){
			rect_dst.top = cy + i_height;
			rect_src.top = i_height;
			rect_dst.bottom = cy + bmp.getHeight();
			rect_dst.left = cx;
			rect_dst.right= cx + bmp.getWidth();			
			Paint paint = new Paint();
			paint.setAlpha( UIDefaultData.MASK_ALPHA );
			canvas.drawBitmap( bmp.getBitmap(), rect_src, rect_dst, paint );
			nextFrame();
		}
	}

}
