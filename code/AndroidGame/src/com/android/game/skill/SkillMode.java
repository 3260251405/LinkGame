package com.android.game.skill;

import com.android.game.modifier.ModifierObject;

/**
 * 
 * @author ����
 *
 * @���� Ӣ�ۼ���Ч��ģ��
 */
public interface SkillMode {
	
	/**
	 * @���� ��ȡ����ֵ
	 * @return
	 * ModifierObject
	 */
	ModifierObject getModifier();
	
	/**
	 * @���� ��ȡ
	 * @return
	 */
	float getValue();
	
	/**
	 * @���� ��ȡ����Ч���Ĺ���
	 * @return
	 */
	String getBelong();
	
	/**
	 * @function get the type of SkillMode
	 * @return
	 */
	String getType();
	
	/**
	 * @function get the target type of the skillmode
	 * @return
	 * target type 
	 */
	int getTarget();
}
