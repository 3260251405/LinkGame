package com.android.game.skill;


/**
 * 
 * @author ����
 *
 * @���� ʿ������
 */
public interface SoilderSkill extends Skill{
	
	/**
	 * @���� ʿ��ʹ�ü���
	 * 
	 * @param type
	 * Ӧ��ʹ�õļ������ͣ������Ͳ�ƥ�䷵��0
	 * @return
	 * ��������ֵ
	 */
	float useSkill( int type );
	
	/**
	 * @���� ��������
	 * @param usable
	 */
	void setUsable( boolean usable );
	/**
	 * @���� �жϵ�ǰ�����Ƿ����
	 * @return
	 */
	boolean usable();
	
	/**
	 * @���� ��ȡ���ܳ���ʱ��
	 * @return
	 */
	int getTime();
	
}
