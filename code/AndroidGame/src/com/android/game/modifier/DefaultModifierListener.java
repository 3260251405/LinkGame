package com.android.game.modifier;

/**
 * 
 * @author ����
 *
 * @���� Ԥ����Modifier������
 * 
 * @implements ModifierListenr
 */
public class DefaultModifierListener implements ModifierListener{

	private long limitTime;
	private long startTime;
	private boolean onListener = false;
	private int type;
	
	/**
	 * ���캯��
	 * @param limitTime
	 * 	��ǰʱ��/��ǰʣ�����
	 * @param type
	 * 	1 ����ʱ���ʱ �� 2 ����������ʱ
	 */
	public DefaultModifierListener( long limitTime , int type ){
		this.limitTime = limitTime;
		this.type = type;
	}

	public boolean onModify( long nowTime ) {
		if( this.onListener ){
			if( limitTime == -1 )
				return false;
			if( type == 1 ){
				if( ( nowTime - startTime ) >= limitTime ){
					return true;
				}else
					return false;
			}else{
				if( limitTime <= 0 ){
					return true;
				}else{
					limitTime --;
					return false;
				}
			}
		}
		return false;
	}

	public void start(long nowTime) {
		this.startTime = nowTime;
		this.onListener = true;
	}

	public void setLimitTime(long limitTime) {
		this.limitTime = limitTime;
	}

}
