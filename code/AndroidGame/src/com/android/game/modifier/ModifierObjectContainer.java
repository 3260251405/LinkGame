package com.android.game.modifier;

import java.util.Collection;

/**
 * 
 * @author ����
 *
 * @���� ���� ModifierObject ������
 * 
 * @param
 * 	
 */
public interface ModifierObjectContainer {
	
	/**
	 * ���һ��ModifierObject
	 * @param modifierObject
	 */
	void addModifierObject( ModifierObject modifierObject );
	
	/**
	 * �Ƴ�һ��ModifierObject
	 * @param modifierObject
	 */
	void removeModifierObject( ModifierObject modifierObject );
	
	/**
	 * ��ȡModifierObject�ļ���
	 * @return
	 * 		Collection
	 */
	Collection<?> getModifierObjects();
	
	/**
	 * ModifierListener�����ӿ�
	 * @param nowTime
	 * 	��ǰʱ��
	 */
	void onModify( long nowTime );
	
}