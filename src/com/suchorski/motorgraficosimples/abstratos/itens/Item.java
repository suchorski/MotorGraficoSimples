package com.suchorski.motorgraficosimples.abstratos.itens;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Item extends Rectangle {
	
	public Item(int x, int y, int comprimento, int altura) {
		super(x, y, comprimento, altura);
	}
	
	public Item(int comprimento, int altura) {
		this(0, 0, comprimento, altura);
	}
	
	public void desenha(Graphics g) {
		return;
	}

}
