/**
 * 
 */
package com.android.game.view;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.game.main.MainActivity;

import cn.appmedia.adshelf.AdshelfManager;
import cn.appmedia.adshelf.ShelfView;

/**
 * @author user
 *
 */
public class ScoreView{

	
	static{
		AdshelfManager.setAid("8192b12c61ff16ba");
	}
	
	private MainActivity activity;
	private ShelfView shelf;

	public ScoreView(MainActivity activity) {
		this.activity = activity;
	}
	
	public void initlizeShelf(){
		if( testConnectivityManager() )
			shelf = new ShelfView( activity );
		else
			shelf = null;
	}
	
	public boolean setShelf(){
		if( testConnectivityManager() && shelf != null ){
			shelf.getShelf();
			return true;
		}
		return false;
	}
	public boolean testConnectivityManager(){
        ConnectivityManager connManager = (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        // ��ȡ��������״̬��NetWorkInfo����
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        // ��ȡ��ǰ�����������Ƿ����
        if (null == networkInfo){
        	return false;
        }else{
			boolean available = networkInfo.isAvailable();
			if (available){
				return true;
			}else{
				return false;
			}
       }
   }
}
