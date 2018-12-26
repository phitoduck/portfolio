/*
 * Bullet
 * 
 * Fired by the player. Managed by the Controller class.
 */

package com.game.src.main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.game.src.main.Game;
import com.game.src.main.Physics;
import com.game.src.main.Textures;

public class Bullet extends EntityFriendly {
	
	public static final int BULLET_VELOCITY = 15;
	public static final int BULLET_SIZE = 32;
	
	// to delete when off screen
	private boolean onScreen; 
	
	private Game game;
	
	public Bullet(double x, double y, Textures tex, Game game) {
		super(x, y); // maxHealth = -1 because it is irrelevant
		
		// get image
		this.spriteImg = tex.getBulletImg();
		this.displayImg = spriteImg;
		
		this.onScreen = true;
		this.game = game;
	    
	}
	
	// updates bullet
	@Override
	public void tick() {
		super.tick();
		
		if (this.onScreen)
			y -= BULLET_VELOCITY;
		
		// is it on the screen?
		if (!Game.isOnScreen((int) x, (int) y)) {
			this.onScreen = false;
		}
		
	}
	
}
