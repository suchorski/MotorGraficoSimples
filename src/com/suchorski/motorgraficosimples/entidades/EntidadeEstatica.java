package com.suchorski.motorgraficosimples.entidades;

import java.awt.Graphics;
import java.awt.Image;

import com.suchorski.motorgraficosimples.abstratos.entidades.Entidade;

public class EntidadeEstatica extends Entidade {
	
	private Image imagem;
	
	public EntidadeEstatica(Image imagem, int x, int y, int comprimento, int altura) {
		super(x, y, comprimento, altura);
		this.imagem = imagem;
	}
	
	public Image getImagem() {
		return imagem;
	}
	
	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}
	
	@Override
	public void desenha(Graphics g) {
		super.desenha(g);
		g.drawImage(imagem, x, y, width, height, null);
	}

}
