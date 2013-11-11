package com.android.game.ability;

import java.util.Collection;
import java.util.Map;

/**
 * 
 * @author ����
 * 
 * @���� ����AbilityScore������
 */
public interface AbilityScoreContainer {
	
	/**
	 * @���� �������ƻ�ȡ����ֵ
	 * @param name
	 * 	����������
	 * @return
	 * 	AbilityScore
	 */
	AbilityScore getAbilityScore( String name );
	
	/**
	 * @���� ����Ability��ȡ����ֵ
	 * @param ability
	 * 	����
	 * @return
	 * AbilityScore
	 */
	AbilityScore getAbilityScore( Ability ability );
	
	/**
	 * @���� ��ȡ AbilityScore ������
	 * @return
	 */
	Collection<AbilityScore> getAbilityScores();
	
	/**
	 * @���� �ж��Ƿ�ӵ��ĳ������
	 * @param ability
	 * 	�����������
	 * @return
	 * 	�Ƿ�ӵ�и�������
	 */
	boolean hasAbility( Ability ability );
	
	/**
	 * @���� ��ȡ����ֵ������
	 * @return
	 * 	Map<Ability , AbilityScore>
	 */
	Map<String , AbilityScore> getAbilityContainer();
	
	/**
	 * @���� ���ü�������
	 * @param nowTime
	 */
	void onModify( long nowTime );
}
