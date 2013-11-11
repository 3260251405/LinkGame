package com.android.game.animation;

import com.android.game.bitmap.MyBitmap;
import com.android.game.constant.UIDefaultData;

import android.graphics.Canvas;
import android.graphics.Rect;

public class ClickedAnimation implements MyAnimation{
	
	private MyBitmap bmp;
	private String str_name;
	private int i_state = 0;         //��ǰ״̬
	private int i_frame = 3;        //֡��
	private int i_current = 0;      //��ǰ֡
	private int i_interval = 35;     //ÿ֡���ʱ�䣨����35ms��
	private int i_control = 0;      //���ڿ��Ʋ���
	private int i_scale = 0;     //��ǰ���ű���
	private Rect rect_dst = new Rect();
	
	public ClickedAnimation( String name ){
		str_name = name;
		bmp = UIDefaultData.container_bmp.getBitmap(name);
	}
	
	public ClickedAnimation( MyAnimation ani ){
		str_name = ani.getName();
		i_frame = 3;
		i_interval = 35;
		bmp = UIDefaultData.container_bmp.getBitmap( str_name );
		i_current = i_control = 0;
	}

	public String getName() {
		return str_name;
	}
	
	public String getType(){
		return "ClickedAnimation";
	}
	
	public int getFrame() {
		return i_frame;
	}
	
	public int getHeight(){
		return bmp.getHeight();
	}
	
	public int getWidth(){
		return bmp.getWidth();
	}

	public void setInterval( int interval ){
		this.i_interval = interval;
	}
	
	public int getInterval() {
		return i_interval;
	}
	
	public boolean isEndAnCirculation() {
		if( i_state == 1 )
			return true;
		return false;
	}

	public boolean isEnd() {
		if( i_state == -1 )
			return true;
		return false;
	}
	
	public void nextFrame() {
		//���Ʋ��Ž���
		i_control += UIDefaultData.DRAW_INTERVAL;
		if( i_control >= i_interval ){
			i_control -= i_interval;
			i_current ++;
			if( i_state == 2 ){
				enlarge();
			}
			else if( i_state == 0 || i_state == 1 ){
				shrink();
			}
			
		}
	}
	
	public void enlarge(){
		//�Ŵ���̽�������������������
		if( i_current >= i_frame || i_scale == 0 ){
			i_current = 0;
			i_state = -1;
			i_scale = 0;
			return;
		}
		//��СҪ��С����ֵ
		int temp = (int)( bmp.getWidth() * 0.03 );
		if( temp == 0 )
			temp = 1;
		i_scale -= temp;
		if( i_scale < 0 )
			i_scale = 0;
	}
	
	public void shrink(){
		if( i_state == 0 )
			i_state = 1;
		//��С�����������򱣳���СͼƬ״̬
		if( i_current >= i_frame ){
			i_current = i_frame - 1;
			return;
		}
		//����Ҫ��С����ֵ
		else{
			int temp = (int)( bmp.getWidth() * 0.03 );
			if( temp == 0 )
				temp = 1;
			i_scale += temp;
		}
	}
	
	public void start(){
		i_current = 0;
		i_control = 0;
		i_scale = 0;
		i_state = 0;
	}
	
	public void restore(){
		i_current = 0;
		i_state = 2;
	}
	
	public void end(){
		i_current = 4;
		i_state = -1;
	}
	
	public void draw(Canvas canvas, int cx, int cy ) {
		if( i_current < i_frame ){
			rect_dst.top = cy + i_scale;
			rect_dst.bottom = cy + bmp.getHeight() - i_scale;
			rect_dst.left = cx + i_scale;
			rect_dst.right = cx + bmp.getWidth() - i_scale;			
			canvas.drawBitmap( bmp.getBitmap(), null, rect_dst, null );
			nextFrame();
		}
	}

}
