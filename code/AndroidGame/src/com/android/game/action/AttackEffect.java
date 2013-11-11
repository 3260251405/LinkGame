package com.android.game.action;

import com.android.game.constant.Constant;
import com.android.game.item.Soilder;
import com.android.game.modifier.DefaultModifier;
import com.android.game.modifier.DefaultModifierObject;
import com.android.game.modifier.ModifierObject;
import com.android.game.skill.SoilderSkill;
import com.android.game.time.Timer;

/**
 * 
 * @author ����
 *
 * @���� ������Ϊ�࣬����ʿ���Ĺ�������
 */
public class AttackEffect implements ActionEffect{

	public void takeAction(Soilder user, Soilder target) {
		
		if( ! user.getATKListener().onModify( Timer.getNowTime() ) ){
			Constant.LOCATION.get( user.getID() ).setState( Constant.SOILDER_ACTION_MOVE );
			return;
		}
		Constant.LOCATION.get( user.getID() ).setState( Constant.SOILDER_ACTION_ATTACK );
		if( user.getName() == "Archer" ){
			user.getATKListener().start( Timer.getNowTime() );
			return;
		}

		int result;													//���ռ�����
		SoilderSkill skill = user.getSkill();
		SoilderSkill e_skill = target.getSkill();
		
		if( e_skill != null && target.getName() == "Archer" && Constant.LOCATION.get( target.getID() ).getX() > 150 ){
			ModifierObject modifier_speed = new DefaultModifierObject( 
					new DefaultModifier( Constant.getType("Speed") , 
							(int)e_skill.useSkill( Constant.SOILDER_SKILL_MOVE ) ) , 1000 , 1 );
			target.getAbilityScore("Speed").addModifierObject(modifier_speed);
			Constant.LOCATION.get( target.getID() ).setState( Constant.SOILDER_ACTION_MOVE );
			return;
		}
		
		float value_user = 0;
		if( skill != null ){
			value_user = skill.useSkill( Constant.SOILDER_SKILL_ATTACK ) ;				//����user�Ĺ����༼��
		}
		float value_target = 0;
		if( e_skill != null ){
			value_target = e_skill.useSkill( Constant.SOILDER_SKILL_DEFENCE );			//����target�ķ����༼��
		}
		
		//���������Ч���ж�
		if( user.getName() == "HeavyRider" && value_user > 0 ){
			ModifierObject modifier_speed = new DefaultModifierObject( 
					new DefaultModifier( Constant.getType("Speed") , -8 ) , 1000 , 1 );
			target.getAbilityScore("Speed").addModifierObject(modifier_speed);
			Constant.LOCATION.get(user.getID()).setState( Constant.SOILDER_ACTION_SKILL );
			Constant.LOCATION.get( target.getID() ).setState( Constant.SOILDER_ACTION_MOVE );
		}
		
		//���ù���ֵ
		if( value_user > 3 ){
			value_user += user.getAbilityScore("Attack").getModifierValue() + 5 - (int)Math.random() * 10 ;
			Constant.LOCATION.get(user.getID()).setState( Constant.SOILDER_ACTION_SKILL );
		}else if( value_user > 0 ){
			value_user += ( value_user * ( user.getAbilityScore("Attack").getModifierValue() + 5 - (int)Math.random() * 10 ));
			Constant.LOCATION.get(user.getID()).setState( Constant.SOILDER_ACTION_SKILL );
		}else{
			value_user = user.getAbilityScore("Attack").getModifierValue();
		}
		
		//���÷���ֵ
		if( value_target > 3 ){
			value_target += target.getAbilityScore("Defence").getModifierValue() + 5 - (int)Math.random() * 10;
			Constant.LOCATION.get(user.getID()).setState( Constant.SOILDER_ACTION_SKILL );
		}else if( value_target > 0 ){
			value_target += ( value_target * ( target.getAbilityScore("Defence").getModifierValue() + 5 - (int)Math.random() * 10 ));
			Constant.LOCATION.get(user.getID()).setState( Constant.SOILDER_ACTION_SKILL );
		}else{
			value_target = target.getAbilityScore("Defence").getModifierValue();
		}
		
		if( ( value_user - value_target ) < 1 ){
			result = 1;
		}else{
			result = (int)( value_user - value_target );
		}
		//�������
		ModifierObject modifier = new DefaultModifierObject( 
				new DefaultModifier( Constant.getType("HP") , -result ) , 3600000 , 1 );
		target.getAbilityScore("HP").addModifierObject(modifier);
		
		user.getATKListener().start( Timer.getNowTime() );
	}
}