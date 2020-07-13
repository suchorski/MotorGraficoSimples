package com.suchorski.motorgraficosimples.principal;

import java.util.TimerTask;

public class Atualizador extends TimerTask {
	
	private MotorGrafico motorGrafico;
	
	protected Atualizador(MotorGrafico motorGrafico) {
		this.motorGrafico = motorGrafico;
	}

	@Override
	public void run() {
		motorGrafico.atualiza();
		motorGrafico.repaint();
	}

}
