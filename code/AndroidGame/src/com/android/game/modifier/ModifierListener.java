package com.android.game.modifier;

/**
 * 
 * @author ����
 *
 * @���� ʵ�ֶ�Modifier�ļ���
 */
public interface ModifierListener {
	
	/**
	 * @���� listen in Modifier or skill CDtime
	 * @param nowTime
	 * 		current time
	 * @return
	 * 		return true when time is over
	 * 		or return false
	 */
	boolean onModify( long nowTime );
	
	/**
	 * @���� begin listening
	 * @param nowTime
	 * 
	 */
	void start( long nowTime );
	
	/**
	 * @function set the limitTime for the listener
	 * @param limitTime
	 */
	void setLimitTime( long limitTime );
	
}
