/**
 * 
 */
package com.android.game.view;

import com.android.game.constant.Constant;
import com.android.game.constant.UIDefaultData;
import com.android.game.drawable.button.ButtonDrawable;
import com.android.game.item.Location;
import com.android.game.main.MainActivity;
import com.android.game.main.MainActivity.WHICHVIEW;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @author user
 */
public class StartView extends SurfaceView implements SurfaceHolder.Callback{

	private MainActivity activity;
	private SurfaceHolder holder;
	private StartViewThread thread;
	private boolean b_hit = false;
	private ButtonDrawable button_hit = null;
	private Location loc_hit = null;
	
	public StartView(MainActivity activity) {
		super(activity);
		this.activity = activity;
		holder = this.getHolder();
		holder.addCallback( this );			
	}
	
	public void initView(){
		UIDefaultData.drawable_buttons.initStartViewButton();
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		thread = new StartViewThread();	
		thread.setWordFlag(true);
		thread.start();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		thread.setWordFlag(false);
		thread.setFlag(false);
	}
	
	public void destroyStartViewThread(){
		thread.setFlag(false);
	}
		
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		ButtonDrawable button;
		switch( event.getAction() ){
		case MotionEvent.ACTION_DOWN:
			for( int i = 0; i < Constant.skill_button.size(); i ++ ){
				Location loc = Constant.skill_button.get(i);
				button = (ButtonDrawable)UIDefaultData.drawable_buttons.getDrawable( loc.getName() );
				if( button.getRect().contains( (int)event.getX(), (int)event.getY() ) ){
					button_hit = button;
					loc_hit = loc;
					loc_hit.setState( ButtonDrawable.CLICKED );
					b_hit = true;
				}
			}
			break;
			
		case MotionEvent.ACTION_UP:
			System.out.println( "ACTION_UP" );
			if( b_hit && button_hit.getRect().contains( (int)event.getX(), (int)event.getY() ) ){
				System.out.println( "set NORMAL" );
				button_hit.setState( ButtonDrawable.NORMAL );
				String name = button_hit.getName();
				button_hit = null;
				loc_hit.setState( ButtonDrawable.NORMAL );
				loc_hit = null;
				onClicked( name );
			}
			else if( b_hit ){
				button_hit.setState( ButtonDrawable.NORMAL );
				button_hit = null;
				loc_hit.setState( ButtonDrawable.NORMAL );
				loc_hit = null;
			}
			b_hit = false;
			break;
			
		}
		return true;
	}

	public void onClicked( String name ){
		if( name == "Start_BUTTON" ){
			System.out.println( "click start button" );
			activity.current = WHICHVIEW.HERO_SELECT_VIEW;
			activity.sendMessage( 2 );
			thread.setFlag(false);
		}
		else if( name == "Score_BUTTON" ){
			activity.current = WHICHVIEW.SCORE_VIEW;
			activity.sendMessage( 5 );
			System.out.println( "click score button" );
		}
		else if( name == "Exit_BUTTON" ){
			System.out.println( "click exit button" );
			activity.exitGame();
		}
		else{
			activity.current = WHICHVIEW.HELP_VIEW;
			activity.sendMessage( 4 );
			System.out.println( "click help button" );
		}
	}

	public class StartViewThread extends Thread{
		
		private boolean b_flag = true;
		private boolean b_work = false;
		private Canvas canvas;
		
		public StartViewThread(){
			super();
		}
		
		public void setFlag( boolean flag ){
			b_flag = flag;
		}
		
		public void setWordFlag( boolean work ){
			b_work = work;
		}
		
		public void draw(){
			canvas = holder.lockCanvas(null);
			try{
				//��ͼ����
				if( canvas != null ){
					UIDefaultData.container_bmp.getBitmap("StartBackground" ).draw(canvas, 0, 0, 255 );
					for( int i = 0; i < Constant.skill_button.size(); i ++ ){
						Location loc = Constant.skill_button.get(i);
						UIDefaultData.drawable_buttons.getDrawable( loc.getName() ).draw(canvas, loc);
					}
				}
			}
			finally{
				//������������ͼ����
				if( canvas != null )
					holder.unlockCanvasAndPost(canvas);
			}
		}
		
		public void run(){
			while( b_flag ){
				if( b_work ){
					long begin_time = System.currentTimeMillis();
					draw();
					long end_time = System.currentTimeMillis();	
					//����֡��
					if( end_time - begin_time < UIDefaultData.DRAW_INTERVAL )
						try{
							Thread.sleep( UIDefaultData.DRAW_INTERVAL - ( end_time - begin_time ) );
						}
						catch( InterruptedException e ){
							e.printStackTrace();
						}
				}
			}
		}
		
	}

}
