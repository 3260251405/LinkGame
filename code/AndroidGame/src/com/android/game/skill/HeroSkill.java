package com.android.game.skill;

import java.util.Collection;

import com.android.game.item.Soilder;

/**
 * 
 * @author ����
 *
 * @���� Ӣ�ۼ��ܽӿ�
 */
public interface HeroSkill extends Skill{
	
	/**
	 * @���� ��ȡCDʱ��
	 * @return
	 * CDtime
	 */
	int getCDtime();
	
	/**
	 * @���� ��ȡ���ܷ�Χ
	 * @return
	 */
	int getRange();
	
	/**
	 * @���� ��������CD
	 * @param nowTime
	 */
	boolean onCDListener( long nowTime );
	
	int getTargetType();
	/**
	 * use the skill
	 * @param target
	 */
	void takeAction( Collection<Soilder> target );
	
}
