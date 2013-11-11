package com.android.game.item;

import java.util.Collection;

import com.android.game.constant.DefaultDataPool;
import com.android.game.skill.HeroSkill;
import com.android.game.time.Timer;

/**
 * 
 * @author user
 *
 * @���� Ӣ��ʵ����
 */
public class DefaultHero extends DefaultItem implements Hero {

	public DefaultHero(String name, int ID, int x, int y, int alpha, int type) {
		super(name, ID, x, y, alpha, type);
	}

	public boolean useSkill(int ID, Collection<Soilder> target) {
		HeroSkill skill = DefaultDataPool.HERO_SKILL.get(ID);
		if( skill.onCDListener( Timer.getNowTime() )){
			skill.takeAction(target);
			return true;
		}else{
			return false;
		}
		
	}

}
