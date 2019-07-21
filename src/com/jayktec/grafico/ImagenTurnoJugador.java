package com.jayktec.grafico;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.Color;

public class ImagenTurnoJugador extends Actor {

	private Texture texture;
	private Miniheroes juego;
	private float frameDuration;
	private float elapsedTime = 0;
	

	public ImagenTurnoJugador(Miniheroes game) {
		juego = game;
		texture = juego.getManager().get("assets/Texturas/turnoJugadorBlanco.png");
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


	public void setTurnoBlancoCandado(Color colorOponente)
	{
		if (colorOponente == Color.WHITE)
		{
			setPosition(20,480);

		} else {

			setPosition(20,30);
		}

		texture = juego.getManager().get("assets/Texturas/candadoCerrado.png");
		
	}

	public void setTurnoNegroCandado(Color colorOponente)
	{
		if (colorOponente == Color.BLACK)
		{
			setPosition(20,480);

		} else {

			setPosition(20,30);
		}

		texture = juego.getManager().get("assets/Texturas/candadoCerrado.png");
	}


	public void setTurnoBlanco(Color colorOponente)
	{
//System.out.println("****** setTurnoBlanco");
		if (colorOponente == Color.WHITE)
		{
			setPosition(20,480);

		} else {

			setPosition(20,30);
		}

		texture = juego.getManager().get("assets/Texturas/turnoJugadorBlanco.png");
		
	}
	
	public void setTurnoNegro(Color colorOponente)
	{
//System.out.println("****** setTurnoNegro");
		if (colorOponente == Color.BLACK)
		{
			setPosition(20,480);

		} else {

			setPosition(20,30);
		}

		texture = juego.getManager().get("assets/Texturas/turnoJugadorNegro.png");
	}
}
