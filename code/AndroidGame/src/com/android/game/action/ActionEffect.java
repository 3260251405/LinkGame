package com.android.game.action;

import com.android.game.item.Soilder;


/**
 * 
 * @author user
 *
 * @���� ��ͬ��Ϊ�Ķ���ʵ�ֽӿ�
 */
public interface ActionEffect {
	
	/**
	 * @���� �ж����������Ƶ�ǰ��ΪЧ��
	 * @param user
	 * ��Ϊ������
	 * @param target
	 * ��Ϊ������
	 */
	void takeAction( Soilder user , Soilder target );
	
}
