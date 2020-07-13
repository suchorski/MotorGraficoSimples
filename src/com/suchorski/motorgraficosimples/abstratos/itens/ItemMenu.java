package com.suchorski.motorgraficosimples.abstratos.itens;

import java.awt.Font;

public abstract class ItemMenu extends Item {
	
	private boolean selecionado;
	private Font fonte;
	
	public ItemMenu(Font fonte, int x, int y, int comprimento, int altura) {
		super(x, y, comprimento, altura);
		this.fonte = fonte;
	}
	
	public ItemMenu(Font fonte, int comprimento, int altura) {
		this(fonte, 0, 0, comprimento, altura);
	}
	
	public boolean isSelecionado() {
		return selecionado;
	}
	
	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}
	
	public Font getFonte() {
		return fonte;
	}
	
	public void setFonte(Font fonte) {
		this.fonte = fonte;
	}
	
}
