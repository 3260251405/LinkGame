package com.android.game.skill;

/**
 * 
 * @author ����
 *
 * @���� ���ܽӿ�,���弼�ܵĻ���ӿ�
 */
public interface Skill {
	
	/**
	 * @���� ��ȡ��������
	 * @return
	 * 	name
	 */
	String getName();
	
	/**
	 * @���� ��ȡ������������
	 * @return
	 *  belong
	 */
	String getBelong();
	
	/**
	 * @���� ��ȡ��������
	 * @return
	 * Ӣ�ۼ��ܣ�1 �⻷����   2 �ų�����<br>
	 * ʿ�����ܣ�1 ������ 2 ������ 3�ƶ���
	 */
	int getType();
	
	
}
