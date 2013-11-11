package com.android.game.constant;

import java.util.List;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.android.game.R;
import com.android.game.animation.MyAnimationContainer;
import com.android.game.bitmap.MyBitmapContainer;
import com.android.game.drawable.BitmapDrawableContainer;
import com.android.game.drawable.button.ButtonDrawableContainer;
import com.android.game.item.Location;

public class UIDefaultData {
	
	public static int i_scroll_bound;                            //�����߽�
	public static int i_x_scroll;                                    //�����̶�,����ǰ������ʼ������
	public static int i_x_screen;                                  //��Ļ���
	public static int i_y_screen;                                  //��Ļ�߶�
	public static float f_scales;                                   //ͼƬ��������
	public static float f_x_scales;                               //�������޸�ֵ
	public static float f_y_scales;                               //�������޸�ֵ
	public static float f_speed;                                       //�����ٶ�
	public static Resources res;
	
	public static MyBitmapContainer container_bmp;                                 //�洢����λͼ��Դ
	public static MyAnimationContainer container_animation;                   //�洢���ж�����Դ 
	public static BitmapDrawableContainer drawable_bmps;                     //�洢����ֱ�ӻ��Ƶ�ͼƬ
	public static ButtonDrawableContainer drawable_buttons;                  //�洢���а�����ͼԪ��
	public static List<Location> skill_ani_loc;
	
	public static final int DRAW_INTERVAL = 35;       //��ͼʱ����
	public static final int MOVE_ANIMATION_INTERVAL = 150;          //�ƶ�����ʱ����
	public static final int MOVE_ANIMATION_FRAME = 4;
	public static final int ATTACK_ANIMATION_INTERVAL = 150;        //��������ʱ����
	public static final int ATTACK_ANIMATION_FRAME = 2;
	public static final int DEATH_ANIMATION_INTERVAL = 200;         //��������ʱ����
	public static final int DEATH_ANIMATION_FRAME = 5;                 //��������֡��
	public static final int MASK_ALPHA = 200;         //����ͼƬ͸����
	
	public static void initUIDefaultData(){
    	//��ʼ��ͼƬ��Դ
    	container_bmp = new MyBitmapContainer();
    	container_bmp.initBitmapContainer();
    	//��ʼ��������Դ
    	container_animation = new MyAnimationContainer();
    	container_animation.initAnimationContainer();
    	//��ʼ����ͼԪ��
    	drawable_bmps = new BitmapDrawableContainer();
    	drawable_buttons = new ButtonDrawableContainer();
    	//��ʼ�������������
    	i_scroll_bound = container_bmp.getBitmap("BACKGROUND").getWidth() - i_x_screen;
    	i_x_scroll = 0;
    	f_speed = 0;
	}
	
	public static void initScales(){
		Bitmap test = BitmapFactory.decodeResource( res, R.drawable.ic_launcher );
    	float temp = 0;
    	switch( test.getHeight() ){
    	case 48:    case 32:
    		temp = (float)i_y_screen / 320;
    		break;
    	case 72:
    		temp = (float)i_y_screen / 480;
    		break;
    	case 96:
    		temp = (float)i_y_screen / 640;
    		break;
    	}
    	f_scales = temp;
    	f_x_scales = (float)i_x_screen / 960;
    	f_y_scales = (float)i_y_screen / 640;
    	System.out.println( f_x_scales + " " + f_x_scales );
	}
	
}
