package com.android.game.item;

import java.util.Collection;

/**
 * 
 * @author ����
 *
 * @���� Ӣ�۶���
 */
public interface Hero extends Item{
	
	/**
	 * @���� ʹ��Ӣ�ۼ���
	 * @param ID
	 * ����ID
	 * @param target
	 * ����Ŀ������
	 */
	boolean useSkill( int ID , Collection<Soilder> target );
	
}
