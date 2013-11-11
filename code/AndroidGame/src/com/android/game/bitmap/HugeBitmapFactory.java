package com.android.game.bitmap;

/*
HugeBitmapFactory����λͼ����ģʽ:
��Գ���ͼƬdecodeʱout of momery������д���
���߷ֱ��ʴ�ͼ�ֳ�������Сͼ���ٴ���һ�ŵͷֱ��ʣ�ARGB_4444���Ĵ���λͼ��
��Сͼ�������ڴ�ͼ��
*/

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;

public class HugeBitmapFactory implements MyBitmapFactory{

	private Bitmap bmp;
	
	public Bitmap createBitmap(int id) {
		ArrayList<Bitmap> list_bmp = new ArrayList<Bitmap>();
		MyBitmapFactory factory = new DefaultBitmapFactory();
		//����Сͼ
		int width = 0;
		for( int i = 0; i < 3; i ++ ){
			list_bmp.add( factory.createBitmap( id + i ) );
			width += list_bmp.get(i).getWidth();
		}
		int height = list_bmp.get(0).getHeight();
		
		//����һ�Ŵ�ͼ,��Сͼ����������ͼ��
		bmp = Bitmap.createBitmap( width, height, Config.ARGB_8888 );
		Canvas canvas = new Canvas( bmp );
		int temp = 0;
		for( int i = 0; i < 3; i ++ ){
			canvas.drawBitmap( list_bmp.get(i), temp, 0, null );
			temp += list_bmp.get(i).getWidth();
		}
		return bmp;
	}

}
