package com.android.game.modifier;

import com.android.game.time.Timer;

/**
 * 
 * @author ����
 *
 * @���� Ԥ����ModifierObject
 */
public class DefaultModifierObject implements ModifierObject{
	
	private Modifier modifier;
	private ModifierListener listener;
	/**
	 * @���� ����һ��ModifierObject
	 * @param modifier
	 * 		����Modifier
	 * @param limitTime
	 * 		ModifierListener��ʱ��
	 * @param type
	 * ����������
	 */
	public DefaultModifierObject( Modifier modifier , long limitTime , int type ){
		this.modifier = new DefaultModifier( modifier );
		this.listener = new DefaultModifierListener( limitTime , type );
		listener.start(Timer.getNowTime());
	}
	
	public Modifier getModifier() {
		return modifier;
	}

	public ModifierType getModifierType() {
		return modifier.getModifierType();
	}

	public ModifierListener getListener() {
		// TODO Auto-generated method stub
		return listener;
	}

	public boolean onModify(long nowTime) {
		return listener.onModify(nowTime);
	}
	
}	
