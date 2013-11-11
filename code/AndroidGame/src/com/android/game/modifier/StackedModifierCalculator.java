package com.android.game.modifier;

import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * @author ����
 *
 * @���� ���� Modifier �ĵ���ֵ
 * 
 * @implements ModifierCalculator
 */
public class StackedModifierCalculator implements ModifierCalculator{

	public int calculateModifier(Collection<ModifierObject> modifiers) {
		int value = 0;
		Iterator<ModifierObject> iterator = modifiers.iterator();
		
		while( iterator.hasNext() ){
			Modifier modifier = ( Modifier )iterator.next().getModifier();
			value += modifier.getModifier();
		}
		return value;
	}

}
