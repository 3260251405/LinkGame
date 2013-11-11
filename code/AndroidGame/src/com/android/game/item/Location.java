package com.android.game.item;

public class Location {
	
	private String str_name;    //����
	private int i_x;             //����ڴ��ͼ�ĺ�����
	private int i_y;             //����ڴ��ͼ��������
	private int i_state;      //״̬
	private int i_index;       //��ʾ��
	
	public Location( String name, int cx, int cy, int state ){
		str_name = name;
		i_x = cx;
		i_y = cy;
		i_state = state;
		i_index = -1;
	}
	
	public String getName(){
		return str_name;
	}
	
	public int getIndex(){
		return i_index;
	}
	
	public int getX(){
		return i_x;
	}
	
	public int getY(){
		return i_y;
	}
	
	public int getState(){
		return i_state;
	}
	
	public void setX( int x ){
		this.i_x = x;
	}
	
	public void setY( int y ){
		this.i_y = y;
	}
	
	public void setState( int state ){
		i_state = state;
	}
	
	public void setIndex( int i ){
		i_index = i;
	}

}
