package com.android.game.drawable.character;

import com.android.game.drawable.Drawable;

/*
CharacterDrawable��Ϸ��ɫ��ͼ����
��������״̬��ÿ��״̬��Ӧһ�ֶ���
*/

public interface CharacterDrawable extends Drawable{

	public static final int MOVE = 0;           //�ƶ�״̬
	public static final int ATTACK = 1;         //����״̬
	public static final int SKILL = 2;             //����ʹ����
	public static final int DEATH = 3;          //����״̬
	
	public int getState();
	
	public void setState( int state );
	
	public boolean isDead();
	
}
