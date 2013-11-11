package com.android.game.ability;

/**
 * 
 * @author ����
 *
 * @���� Ԥ��������
 */
public class DefaultAbility implements Ability{

	private String name;
	
	public DefaultAbility( String name ){
		this.name = name;
	}
	
	public DefaultAbility( Ability ability ){
		this.name = ability.getName();
	}
	public String toString(){
		return name;
	}
	public String getName() {
		return name;
	}

}
