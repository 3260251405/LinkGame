package com.android.game.action;

import com.android.game.item.Soilder;


/**
 * 
 * @author ����
 *
 * @����  ʿ���ж��Ļ���ӿ�
 */
public interface Action {
	
	/**
	 * @���� ��Ϊ��ڣ�����ʵ����Ϊǰ�ĸ��ֲ���
	 * @param user
	 * ��Ϊ������
	 * @param target
	 * ��ΪĿ��
	 */
	void actionEntry( Soilder user , Soilder target );
	
	/**
	 * @���� ��Ϊʵʩ����
	 */
	void takeAction();
	
}
