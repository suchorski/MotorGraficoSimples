package com.suchorski.motorgraficosimples.abstratos.imagens;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.suchorski.motorgraficosimples.principal.MotorGrafico;

public abstract class Tela {
	
	private MotorGrafico motorGrafico;
	
	public Tela(MotorGrafico motorGrafico) {
		this.motorGrafico = motorGrafico;
	}
	
	public MotorGrafico getMotorGrafico() {
		return motorGrafico;
	}
	
	public void mudarTela(Tela tela) {
		motorGrafico.setTela(tela);
	}
	
	public void atualiza() {
		return;
	}
	
	public void desenha(Graphics g) {
		return;
	}
	
	public void teclaPressionada(KeyEvent e) {
		return;
	}
	
	public void teclaSolta(KeyEvent e) {
		return;
	}

}
