package com.android.game.bitmap;

/*
DefaultBitmapFactoryĬ�ϵ�λͼ����ģʽ
������ԭͼ��С����Ļ�ֱ��ʶ�ԭͼ��������
*/


import com.android.game.constant.UIDefaultData;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

public class DefaultBitmapFactory implements MyBitmapFactory{

	public Bitmap createBitmap(int id) {
		//����ԭͼ
		Bitmap bmp_origination = BitmapFactory.decodeResource( UIDefaultData.res, id);
		int width = bmp_origination.getWidth();
		int height = bmp_origination.getHeight();
		
		//��÷�������
		Matrix matrix = new Matrix();
		matrix.postScale( UIDefaultData.f_scales,  UIDefaultData.f_scales);
		
		//����ͼƬ
		Bitmap bmp = Bitmap.createBitmap(bmp_origination, 0, 0, width, height, matrix, true);
		
		return bmp;
	}

}
