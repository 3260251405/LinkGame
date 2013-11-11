package com.android.game.item;

import com.android.game.constant.Constant;

/**
 * 
 * @author ����
 *
 * @���� Ԥ����������
 * 
 * @implements Item
 */
public class DefaultItem implements Item{

	private String str_name;
	private int i_ID;
	private int i_type;
	
	/**
	 * 
	 * @param name ����
	 * @param ID ID
	 * @param x ���ͼ������
	 * @param y ���ͼ������
	 * @param alpha	͸���ȣ�ʿ����ǰ״̬�����ߡ����������ܶ�������
	 * @param type Item������
	 */
	public DefaultItem( String name , int ID , int x , int y , int alpha , int type ){
		this.str_name = name;
		this.i_ID = ID;
		Location location = new Location( name , x , y , Constant.SOILDER_ACTION_MOVE );
		if( type == 3 ){
			Constant.ARROW_LOCATION.put(ID, location);
			Constant.arrow_list.add( location );
		}else if( type == 4 ){
			
		}else{
			Constant.LOCATION.put( ID , location );
			Constant.soilder_list.add( location );
		}
		this.i_type = type;
	}

	public String getName() {
		return str_name;
	}

	public int getID() {
		return i_ID;
	}
	
	public int getType() {
		return i_type;
	}

	public void setType(int type) {
		this.i_type = type;
	}

}
