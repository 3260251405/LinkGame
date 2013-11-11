package com.android.game.drawable.character;

import android.graphics.Canvas;

import com.android.game.animation.DisappearAnimation;
import com.android.game.animation.DisposableAnimation;
import com.android.game.animation.MyAnimation;
import com.android.game.constant.Constant;
import com.android.game.constant.UIDefaultData;
import com.android.game.item.Location;

/*
DefaultCharacterDrawable������ɫ��ͼ����
һ���ƶ�������ѭ������һ�׹���������һ���ԣ���һ�׼��ܶ�����һ���ԣ��� һ������������һ���ԣ�
*/

public class DefaultCharacterDrawable implements CharacterDrawable{
	
	private String str_name;
	private MyAnimation ani_move, ani_attack, ani_skill, ani_death;
	private int i_state;
	private boolean b_dead;
	
	public DefaultCharacterDrawable( String name ){
		str_name = name;
		i_state = MOVE;
		b_dead = false;
		ani_move = new DisposableAnimation( UIDefaultData.container_animation.getAnimation( name + "_MOVE" ) );
		ani_attack = new DisposableAnimation( UIDefaultData.container_animation.getAnimation( name + "_ATTACK" ) );
		ani_skill = new DisposableAnimation( UIDefaultData.container_animation.getAnimation( name + "_SKILL" ) );
		ani_death = new DisappearAnimation( UIDefaultData.container_animation.getAnimation( name + "_DEATH" ) );
	}

	public String getBasicType() {
		return "Character";
	}

	public String getConcreteType() {
		return "DefaultCharacter";
	}

	public String getName() {
		return str_name;
	}

	public int getState() {
		return i_state;
	}

	public void setState(int state) {
		if( state == DEATH )
			i_state = state;
		if( state != i_state ){
			//���һ�ζ���ѭ��δ�����꣬���л���ͼ״̬
			//������ﴦ������״̬�����л�״̬
			if( i_state == DEATH )
				return;
			if( i_state == ATTACK && ! ani_attack.isEnd() )
				return;
			if( i_state == SKILL && ! ani_skill.isEnd() )
				return;
			if( i_state == MOVE && ! ani_move.isEndAnCirculation() )
				return;
			i_state = state;
		}
	}
	
	public boolean isDead(){
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
			if( ani_attack.isEnd() )
				ani_attack.start();
			ani_attack.draw(canvas, cx, cy );
			if( ani_attack.isEnd() ){
				if( str_name == "Archer" ){
					location.setState( Constant.SOILDER_ACTION_ATTACKOVER );
				}else{
					location.setState(MOVE);
				}
				i_state = MOVE;
			}
			break;
		case SKILL:
			if( ani_skill.isEnd() )
				ani_skill.start();
			ani_skill.draw(canvas, cx, cy );
			if( ani_skill.isEnd() ){
				i_state = MOVE;
				location.setState(MOVE);
			}
			break;
		case DEATH:
			ani_death.draw(canvas, cx, cy );
			//������������Ѳ����꣬���������b_dead��Ϊtrue������֮��ɾ��������Ϣ
			if( ani_death.isEnd() ){
				b_dead = true;
			}
			break;
		}
	}

}
