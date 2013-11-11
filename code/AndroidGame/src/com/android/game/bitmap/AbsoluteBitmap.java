package com.android.game.bitmap;

/*
AbsoluteBitmap���������Ͳ�͸��λͼ��
����cx,cy��������ֻ���Ļ�ģ�����Ҫ���ݹ����̶Ƚ��л���
*/


import com.android.game.constant.UIDefaultData;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class AbsoluteBitmap implements MyBitmap{
	private Bitmap bmp;
	private MyBitmapFactory factory;
	
	public AbsoluteBitmap( int id ){
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
		//Խ���ж�
		if( cx + bmp.getWidth() >= 0 && cx < UIDefaultData.i_x_screen && cy >= 0 && cy < UIDefaultData.i_y_screen ){
			canvas.drawBitmap(bmp, cx, cy, null);
		}
	}
}
