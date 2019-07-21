package com.jayktec.grafico;

//import java.io.File;

import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
//import com.badlogic.gdx.graphics.g2d.TextureAtlas;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MarcarSeleccionMenu extends Actor {
	private Texture texture;
	private Miniheroes juego;
	private float frameDuration;
	private float elapsedTime = 0;
	

	public MarcarSeleccionMenu(Miniheroes game) {
		juego = game;
		texture = juego.getManager().get("assets/Texturas/esfera_azul.png");
	}

	@Override
	public void draw(Batch batch, float alpha) {


		if(texture!=null)
		{
	        batch.draw(texture, getX(), getY(),getWidth(),getHeight());	
        }
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
}
