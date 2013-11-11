package com.android.game.modifier;

/**
 * 
 * @author ����
 *
 * @���� ����ֵ�ķ�װ
 * 
 * @include
 * 		int value  <br>
 * 		ModifierType type
 */
public interface Modifier {
	
	/**
	 * @���� ��ȡ Modifier ��ֵ
	 * @return
	 * 		int value
	 */
	int getModifier();
	
	/**
	 * @���� ��ȡ Modifier ������
	 * @return
	 * 	ModifierType type
	 */
	ModifierType getModifierType();
	
	/**
	 * @���� �ж� Modifier �Ƿ�������
	 * @return
	 * 	boolean value >= 0 
	 */
	boolean isBonus();
}
