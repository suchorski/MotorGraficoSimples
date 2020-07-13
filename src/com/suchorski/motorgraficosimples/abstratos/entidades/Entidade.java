package com.suchorski.motorgraficosimples.abstratos.entidades;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entidade extends Rectangle {
	
	public Entidade(int x, int y, int comprimento, int altura) {
		super(x, y, comprimento, altura);
	}
	
	public void desenha(Graphics g) {
		return;
	}

}
