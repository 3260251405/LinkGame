package com.android.game.modifier;

import java.util.Collection;

/**
 * 
 * @author ����
 *
 * @���� ���� Modifier �ļ�����
 */
public interface ModifierCalculator {
	
	/**
	 * @���� ���� Modifier 
	 * @param modifiers
	 * 		Modifier�ļ���
	 * @return
	 */
	int calculateModifier( Collection<ModifierObject> modifiers );
}
