package com.android.game.modifier;

/**
 * 
 * @author ����
 * 
 * @���� ��װModifier�Ͷ�Ӧ��ModifierListener<br>
 * 		��ʵ�ֶ�Ӧ�ӿ�
 */
public interface ModifierObject {
	
	/**
	 * ��ȡ Object �� Modifier
	 * @return
	 * 	Modifier
	 */
	Modifier getModifier();
	
	/**
	 * @���� ��ȡModifier������
	 * @return
	 * 	ModifierType
	 */
	ModifierType getModifierType();
	
	/**
	 * ��ȡ Object �� Listener
	 * @return
	 * 	ModifierListener
	 */
	ModifierListener getListener();
	
	/**
	 * ModifierListener �ļ����ӿ�
	 * @param nowTime
	 * 	��ǰʱ��
	 * @return
	 * 		boolean 
	 */
	boolean onModify( long nowTime );
}