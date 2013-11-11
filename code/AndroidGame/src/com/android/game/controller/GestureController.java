package com.android.game.controller;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.android.game.constant.Constant;
import com.android.game.constant.UIDefaultData;
import com.android.game.drawable.button.ButtonDrawable;
import com.android.game.item.Location;

public class GestureController {
	
	private boolean b_hit = false;              //�Ƿ�������Ч����
	private Location location_hit = null;
	private GestureDetector listener;
	private ButtonDrawable button_hit = null;
	
	public GestureController( Context context ){
		listener = new GestureDetector( context, new GestureListener() );
	}
	
	public boolean onTouchEvent( MotionEvent e ){
		if( e.getAction() == MotionEvent.ACTION_UP )
			onTouchUp(e);
		else if( e.getAction() == MotionEvent.ACTION_MOVE ){
			System.out.println( "ACTION_MOVE" );
			if( b_hit )
				dragButton( (int)e.getX(), (int)e.getY() );
		}
		return listener.onTouchEvent(e);
	}
	
	public void onTouchUp( MotionEvent e ){
		if( b_hit && button_hit.getRect().contains( (int)e.getX(), (int)e.getY() ) && button_hit.getConcreteType() != "DraggableButton" ){
			//���Ϊ�˵�������״̬��Ϊ����״̬
			System.out.println( "Vailed up" );
			if( location_hit.getName().startsWith("Menu") ){
				location_hit.setState( ButtonDrawable.NORMAL );
				//TODO
			}
			//���Ϊ���ܺ�ʿ������������Ϊ��ȴ״̬
			else if( button_hit.getState() != ButtonDrawable.COLDING ){
				if( location_hit.getName().startsWith("hero") ){
					Constant.current_button = location_hit;
					System.out.println( "start to use skill" );
				}
				else
					Constant.current_soilder = location_hit;
				location_hit.setState( ButtonDrawable.COLDING );
			}
		}
		else if( b_hit && button_hit.getState() != ButtonDrawable.COLDING ){
			System.out.println("up when hit button : " + button_hit.getConcreteType() );
			if( button_hit.getConcreteType() == "DraggableButton" ){
				System.out.println( "draggable button up" );
				location_hit.setX( (int)( ( e.getX() + UIDefaultData.i_x_scroll ) / UIDefaultData.f_y_scales ) );
				location_hit.setY( (int)( e.getY() / UIDefaultData.f_y_scales ));
				location_hit.setState( ButtonDrawable.COLDING );
				System.out.println( "set location : e.x = " + e.getX() + ", x = " + location_hit.getX() );
				Constant.current_button = location_hit;
			}
			else if( location_hit.getState() != ButtonDrawable.COLDING )
				location_hit.setState( ButtonDrawable.NORMAL );
		}
		b_hit = false;
		button_hit = null;
	}
	
	public boolean isHit( int cx, int cy ){
		System.out.println( "isHit" );
		ButtonDrawable button;
		//�Ƿ�������
		for( int i = 0; i < Constant.skill_button.size(); i++ ){
			button = (ButtonDrawable)UIDefaultData.drawable_buttons.getDrawable( 
					Constant.skill_button.get(i).getName() );
			if( button.getRect().contains( cx, cy ) ){
				b_hit = true;
				button_hit = button;
				location_hit = Constant.skill_button.get(i);
				System.out.println( "hit button " + location_hit.getName() );
				return true;
			}
		}
		//ѭ������δ���У���ԭ����
		b_hit = false;
		location_hit = null; 
		button_hit = null;
		return false;
	}
	
	//����
	public static void scrollScreen( float distanceX ){
		int scroll = UIDefaultData.i_x_scroll;
		scroll += distanceX;
		//Խ���ж�
		if( scroll < 0 ){
			scroll = 0;
		}		
		else if( scroll > UIDefaultData.i_scroll_bound ){
			scroll = UIDefaultData.i_scroll_bound;
		}
		UIDefaultData.i_x_scroll = scroll;
		if( UIDefaultData.f_speed != 0 ){
			UIDefaultData.f_speed -= UIDefaultData.f_speed / 5;
			if( UIDefaultData.f_speed < 3 && UIDefaultData.f_speed > -3 )
				UIDefaultData.f_speed = 0;
		}
	}
	
	//�϶����ܰ�����ȷ�������ͷ�����
	public void dragButton( int cx, int cy ){
		if( button_hit.getConcreteType() != "DraggableButton" )
			return;
		location_hit.setState(ButtonDrawable.DRAGGED);
		location_hit.setX(cx);
		location_hit.setY(cy);
	}
	
	public class GestureListener implements GestureDetector.OnGestureListener{

		public boolean onDown(MotionEvent e) {
			System.out.println("onDown");
			UIDefaultData.f_speed = 0;
			if( !isHit( (int)e.getX(), (int)e.getY() ) )
				return false;
			else{
				location_hit.setState( ButtonDrawable.CLICKED );
				return true;
			}
		}

		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			System.out.println( "velocity_x: " + velocityX );
			UIDefaultData.f_speed = velocityX / -60;
			return false;
		}

		public void onLongPress(MotionEvent e) {
			System.out.println("onLongPress" );
		}

		public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
				float distanceY) {
			System.out.println( "onScroll : " );
			if( !b_hit )
				scrollScreen( distanceX );
			return true;
		}

		public void onShowPress(MotionEvent e) {
			System.out.println("onShowPress");
		}

		public boolean onSingleTapUp( MotionEvent e ) {
			return true;
		}
		
	}

}
