package com.android.game.modifier;

import java.util.Collection;

/**
 * 
 * @author ����
 *
 * @���� ����Modifier������
 * 
 * @param 
 * 	ModifierCalculator calculator<br>
 * ���� Modifier �ļ�����
 * 
 * @param String name
 * 		Modifier������
 */
public interface ModifierType {
	
	/**
	 * @���� ��ȡ Modifier ������
	 * @return
	 * 		String name
	 */
	String getName();
	
	/**
	 * @���� ��ȡ ModifierCalculator
	 * @return
	 */
	ModifierCalculator getCalculator();
	
	/**
	 * @���� ���� Modifier ��ֵ
	 * @param moidifiers
	 * 		Modifier �ļ���
	 * @return
	 * 		int value
	 */
	int calculateModifiers( Collection<ModifierObject> modifiers );
}
