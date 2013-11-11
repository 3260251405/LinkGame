package com.android.game.bitmap;

/*
MyBitmap����ͼƬ�ӿ�
�Բ�ͬ���͵�ͼƬʹ�ò�ͬ�����ɺͻ�ͼ���ԣ������з�װ
 */

import android.graphics.Bitmap;
import android.graphics.Canvas;

public interface MyBitmap {
	
	public int getWidth();
	
	public int getHeight();
	
	public Bitmap getBitmap();
	
	public void draw( Canvas canvas, int cx, int cy, int alpha );
	
}
