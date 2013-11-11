package com.android.game.bitmap;

/*
RelativeBitmap��������Ͳ�͸��λͼ:
����cx,cy������ڴ��ͼ�ģ�ʵ�ʻ�ͼʱ����л���
*/


import com.android.game.constant.UIDefaultData;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class RelativeBitmap implements MyBitmap{

	private Bitmap bmp;
	private MyBitmapFactory factory;
	
	public RelativeBitmap( int id ){
		factory = new DefaultBitmapFactory();
		bmp = factory.createBitmap(id);
	}

	public int getWidth() {
		return bmp.getWidth();
	}

	public int getHeight() {
		return bmp.getHeight();
	}
	
	public Bitmap getBitmap(){
		return bmp;
	}

	public void draw(Canvas canvas, int cx, int cy, int alpha) {
		int x = cx - UIDefaultData.i_x_scroll;         //ʵ����Ļ��ʾ����
		//Խ���ж�
		if( x + bmp.getWidth() >= 0 && x <= UIDefaultData.i_x_screen + 50 && cy >= 0 && cy <= UIDefaultData.i_y_screen ){
			canvas.drawBitmap(bmp, x, cy - bmp.getHeight(), null);
		}
	}

}
