package com.android.game.modifier;

/**
 * 
 * @author ����
 *
 * @���� �������� Modifier �Ķ���
 * 
 * @extends ModifierObjectContainer
 */
public interface Modifiable extends ModifierObjectContainer{
	
	/**
	 * @���� ��ȡδ������ֵ
	 * @return
	 * 	int baseValue
	 */
	int getBaseValue();
	
	/**
	 * @���� ���û���ֵ
	 */
	void setBaseValue( int value );
	
	/**
	 * @���� ��ȡ�������ֵ
	 * @return
	 * 	int modifierValue
	 */
	int getModifierValue();
	
	/**
	 * @���� ��������ֵ
	 */
	void calculate();
}
