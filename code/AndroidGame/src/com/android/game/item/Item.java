package com.android.game.item;

/**
 *
 * @author ����
 *
 * @���� ������
 */
public interface Item {
	
	/**
	 * @���� ��ȡ����
	 * @return
	 *  name
	 */
	String getName();
	
	/**
	 * @���� ��ȡID
	 * @return
	 *  ID
	 */
	int getID();
	
	/**
	 * @���� ��ȡCharacter������
	 * @return
	 * 	int type
	 */
	int getType();
	
	/**
	 * @���� ���� Character ������
	 * 
	 * @param type
	 * 	���õ�����
	 */
	void setType( int type );
}
