package com.android.game.ability;

import com.android.game.modifier.Modifiable;

/**
 * 
 * @author ����
 *
 * @���� ��������ֵ
 */
public interface AbilityScore extends Modifiable{
	
	/**
	 * @���� ��ȡ����
	 * @return
	 * 	Ability
	 */
	Ability getAbility();
	
	/**
	 * @���� ��ȡ����ֵ
	 * @return
	 * 	int AbilityScore;
	 */
	int getAbilityScore();
}
