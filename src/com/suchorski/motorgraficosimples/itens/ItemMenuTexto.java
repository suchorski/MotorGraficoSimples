package com.suchorski.motorgraficosimples.itens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.suchorski.motorgraficosimples.abstratos.itens.ItemMenu;
import com.suchorski.motorgraficosimples.utilitarios.TextoUtils;

public class ItemMenuTexto extends ItemMenu {
	
	private String texto;
	
	public ItemMenuTexto(Font fonte, String texto, int x, int y, int comprimento, int altura) {
		super(fonte, x, y, comprimento, altura);
		this.texto = texto;
		setSelecionado(false);
	}

	public ItemMenuTexto(Font fonte, String texto, int comprimento, int altura) {
		this(fonte, texto , 0, 0, comprimento, altura);
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public void desenha(Graphics g) {
		super.desenha(g);
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		if (isSelecionado()) {
			g.drawRect(x, y, width - 1, height - 1);
		}
		TextoUtils.escreverTextoCentralizado(g, texto, this, getFonte());
	}

}
