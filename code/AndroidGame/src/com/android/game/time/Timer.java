package com.android.game.time;

/**
 * 
 * @author user
 *
 * @���� ʱ���࣬���ڼ��㲢��ȡ��ǰʱ��
 */
public class Timer {
	
	private static long startTime;
	
	public static long getNowTime(){
		long nowTime = System.currentTimeMillis() - startTime;
		return nowTime;
	}
}
