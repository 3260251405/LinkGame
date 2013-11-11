/**
 * 
 */
package com.android.game.controller;

import java.util.Iterator;

import com.android.game.action.DefaultAction;
import com.android.game.constant.Constant;
import com.android.game.constant.GameInfo;
import com.android.game.constant.Message;
import com.android.game.item.Location;
import com.android.game.item.Soilder;
import com.android.game.modifier.DefaultModifier;
import com.android.game.modifier.DefaultModifierObject;
import com.android.game.modifier.ModifierObject;
import com.android.game.time.Timer;

/**
 * @author ����
 *
 * @���� ��Ϊ�ܿ����࣬����ʿ�����Է���Ϊ����
 * 
 * @ע�⣺ActionController���Լ���
 * 		�����߳����ڿ���ʿ����Modifier
 */
public class ActionController {
	
	private GameController controller;				//GameController�����ã���ȡʿ��������
	
	private Soilder soilder_target;					//����ʿ���Ĺ���Ŀ��
	private Soilder enemy_target;					//�з�ʿ���Ĺ���Ŀ��
	
	private DefaultAction action = new DefaultAction();
	
	
	public ActionController( GameController controller ){
		this.controller = controller;
		soilder_target = controller.e_castle;					//����ʿ���Ĺ���Ŀ��
		enemy_target = controller.castle;					//�з�ʿ���Ĺ���Ŀ��
	}
	
	//��Ϊ������ѭ��
	public void ActionMainLoop(){
		
		if( controller.getSoilders().isEmpty() ){
			enemy_target = controller.castle;
		}
		if( controller.getEnemies().isEmpty() ){
			soilder_target = controller.e_castle;
		}
		
		Iterator<Soilder> arrow = controller.getArrow().iterator();
		
		while( arrow.hasNext() ){
			Soilder temp = arrow.next();
			if( ( Constant.LOCATION.get( soilder_target.getID() ).getX() -
					Constant.ARROW_LOCATION.get( temp.getID() ).getX()  ) <= 
					( soilder_target.getAbilityScore("Range").getModifierValue() +
							temp.getAbilityScore("Range").getModifierValue() ) ){
				
				ModifierObject modifier = new DefaultModifierObject( 
						new DefaultModifier( Constant.getType("HP") , -temp.getAbilityScore("Attack").getModifierValue() ) , 3600000 , 1 );
				
				soilder_target.getAbilityScore("HP").addModifierObject(modifier);
				
				Constant.ARROW_LOCATION.get( temp.getID() ).setState( Constant.SOILDER_ACTION_DEATH );
				Constant.ARROW_LOCATION.remove(temp.getID());
				
				arrow.remove();
			}else{
				Location location = Constant.ARROW_LOCATION.get( temp.getID() );
				location.setX( location.getX() + temp.getAbilityScore("Speed").getModifierValue() );
			}
		}
		
		//�з�ʿ��
		Iterator<Soilder> enemy = controller.getEnemies().iterator();
		while( enemy.hasNext() ){
			Soilder temp = enemy.next();
			temp.onModify( Timer.getNowTime() );
			
			//�����ж�
			if( temp.getAbilityScore("HP").getModifierValue() <= 0 ){
				Constant.LOCATION.get(temp.getID()).setState( Constant.SOILDER_ACTION_DEATH );
				Constant.LOCATION.remove(temp.getID());
				Message.killEnemy = true;
				soilder_target = controller.e_castle;
				System.out.println(" enemy die , new soilder target  " + soilder_target.getName() );
				GameInfo.money += ( temp.getName() == "Monster_1" ) ? 10 : 5;
				enemy.remove();
				continue;
			}
			
			//����Ŀ��
			int temp_x = Constant.LOCATION.get(temp.getID()).getX();
			if( temp_x < Constant.LOCATION.get(soilder_target.getID()).getX() ){
				soilder_target = temp;
				System.out.println(" new soilder target  " + soilder_target.getName() );
			}
			
			//�ж�
			action.actionEntry(temp, enemy_target);
		}
		
		//����ʿ��
		Iterator<Soilder> soilder = controller.getSoilders().iterator();
		
		while( soilder.hasNext() ){
			Soilder temp = soilder.next();
			temp.onModify( Timer.getNowTime() );
			
			//�����ж�
			if( temp.getAbilityScore("HP").getModifierValue() <= 0 ){
				Constant.LOCATION.get(temp.getID()).setState( Constant.SOILDER_ACTION_DEATH );
				Constant.LOCATION.remove(temp.getID());
				enemy_target = controller.castle;
				System.out.println(" soilder die , new enemy target  " + enemy_target.getName() );
				soilder.remove();
				continue;
			}
			
			//����Ŀ��
			int temp_x = Constant.LOCATION.get(temp.getID()).getX();
			if( temp_x > Constant.LOCATION.get(enemy_target.getID()).getX() ){
				enemy_target = temp;
				System.out.println(" new enemy target  " + enemy_target.getName() );
			}
			
			//�ж� 
			action.actionEntry(temp, soilder_target);
		}
		
	}
}
