package com.android.game.drawable.character;

import android.graphics.Canvas;

import com.android.game.animation.DisposableAnimation;
import com.android.game.animation.MyAnimation;
import com.android.game.constant.UIDefaultData;
import com.android.game.item.Location;

/*
MissileDrawableͶ�����ͼ����:
һ���ƶ�������ѭ������һ������Ŀ�궯����һ���ԣ�
*/

public class MissileDrawable implements CharacterDrawable{

	private String str_name;
	private MyAnimation ani_move, ani_focus;
	private int i_state;
	private boolean b_dead;
	
	public MissileDrawable( String name ){
		str_name = name;
		i_state = MOVE;
		b_dead = false;
		ani_move = new DisposableAnimation( UIDefaultData.container_animation.getAnimation( name + "_MOVE" ) );
		ani_focus = new DisposableAnimation( UIDefaultData.container_animation.getAnimation( name + "_FOCUS" ) );
	}
	
	public String getBasicType() {
		return "Character";
	}

	public String getConcreteType() {
		return "Missile";
	}

	public String getName() {
		return str_name;
	}

	public int getState() {
		return i_state;
	}

	public void setState(int state) {
		if( state == MOVE && i_state == ATTACK )
			return;
		i_state = state;
	}

	public boolean isDead() {
		return b_dead;
	}
	
	public void draw(Canvas canvas, Location location) {
		setState( location.getState() );
		int cx = (int)( location.getX() * UIDefaultData.f_y_scales );
		int cy = (int)( location.getY() * UIDefaultData.f_y_scales );
		switch( i_state ){
		case MOVE:
			if( ani_move.isEnd() )
				ani_move.start();
			ani_move.draw(canvas, cx, cy );
			break;
		case ATTACK:
			ani_focus.draw(canvas, cx, cy );
			//������ж����Ѳ����꣬���������b_dead��Ϊtrue������֮��ɾ��������Ϣ
			if( ani_focus.isEnd() )
				b_dead = true;
		}
	}

}
