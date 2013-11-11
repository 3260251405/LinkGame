package com.android.game.drawable.button;

import android.graphics.Rect;

import com.android.game.drawable.Drawable;

/*
ButtonDrawable������ͼ����
��������״̬��ÿ��״̬��Ӧ��ͬ�Ļ�ͼ����
����λ�ù̶�����DraggableButtonDrawable�⣬draw(����)�е�Location��Ч
*/

public interface ButtonDrawable extends Drawable{
	
	public static final int NORMAL = 0;                  //����״̬
	public static final int CLICKED = 1;                   //���״̬
	public static final int DRAGGED = 2;                //��ҷ״̬
	public static final int COLDING = 3;                  //��ȴ״̬
	public static final int LOCKED = 4;                    //����״̬

	public int getState();
	
	public void setState( int state );
	
	public Rect getRect();
	
}
