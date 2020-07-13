package com.suchorski.motorgraficosimples.entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import com.suchorski.motorgraficosimples.abstratos.entidades.Entidade;
import com.suchorski.motorgraficosimples.principal.MotorGrafico;

public class EntidadeAnimada extends Entidade {
	
	private List<Image> imagens;
	private double periodo;
	private int imagem;
	private double contador;
	private MotorGrafico motorGrafico;
	
	public EntidadeAnimada(List<Image> imagens, double periodo, MotorGrafico motorGrafico, int x, int y, int comprimento, int altura) {
		super(x, y, comprimento, altura);
		this.imagens = imagens;
		this.periodo = periodo;
		this.imagem = 0;
		this.contador = 0;
		this.motorGrafico = motorGrafico;
	}
	
	public List<Image> getImagens() {
		return imagens;
	}
	
	public void setImagens(List<Image> imagens) {
		this.imagens = imagens;
	}
	
	public double getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(double periodo) {
		this.periodo = periodo;
	}
	
	public int getImagem() {
		return imagem;
	}
	
	public void setImagem(int imagem) {
		this.imagem = imagem;
	}
	
	public double getContador() {
		return contador;
	}
	
	public void setContador(double contador) {
		this.contador = contador;
	}
	
	public MotorGrafico getMotorGrafico() {
		return motorGrafico;
	}
	
	public void setMotorGrafico(MotorGrafico motorGrafico) {
		this.motorGrafico = motorGrafico;
	}
	
	@Override
	public void desenha(Graphics g) {
		super.desenha(g);
		g.drawImage(imagens.get(imagem), x, y, width, height, null);
		contador += 1000 / motorGrafico.getFps();
		while (contador > periodo) {
			imagem = ++imagem % imagens.size();
			contador -= periodo;
		}
	}

}
