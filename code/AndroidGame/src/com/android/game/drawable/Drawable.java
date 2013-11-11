package com.android.game.drawable;

import com.android.game.item.Location;

import android.graphics.Canvas;

/*
������ͼԪ���ӿ�
*/

public interface Drawable {
	
	public String getBasicType();
	
	public String getConcreteType();
	
	public String getName();
	
	public void draw( Canvas canvas, Location location );
	
}
