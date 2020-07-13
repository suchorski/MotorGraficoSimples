package com.suchorski.motorgraficosimples.utilitarios;

import java.awt.Rectangle;

public class CentralizadorUtils {
	
	public static void centralizarHorizontalmente(int inicio, int comprimento, Rectangle... itens) {
		for (Rectangle r : itens) {
			r.setLocation((comprimento - r.width) / 2 + inicio, r.y);
		}
	}
	
	public static void centralizarHorizontalmente(int comprimento, Rectangle... itens) {
		centralizarHorizontalmente(0, comprimento, itens);
	}

	public static void centralizarHorizontalmente(Rectangle area, Rectangle... itens) {
		centralizarHorizontalmente(area.x, area.width, itens);
	}
	
	public static void centralizarVerticalmente(int inicio, int altura, Rectangle... itens) {
		for (Rectangle r : itens) {
			r.setLocation(r.x, (altura - r.height) / 2 + inicio);
		}
		
	}
	
	public static void centralizarVerticalmente(int altura, Rectangle... itens) {
		centralizarVerticalmente(0, altura, itens);
	}

	public static void centralizarVerticalmente(Rectangle area, Rectangle... itens) {
		centralizarVerticalmente(area.y, area.height, itens);
	}
	
	public static void centralizar(Rectangle area, Rectangle... itens) {
		for (Rectangle r : itens) {
			centralizarHorizontalmente(area, r);
			centralizarVerticalmente(area, r);
		}
	}
	
	public static void layoutHorizontal(Rectangle area, Rectangle... itens) {
		int divisao = area.width;
		for (Rectangle r : itens) {
			divisao -= r.width;
		}
		divisao /= itens.length + 1;
		int posicao = area.x + divisao;
		for (Rectangle r : itens) {
			r.setLocation(posicao, r.y);
			posicao += divisao + r.width;
		}
		centralizarVerticalmente(area, itens);
	}

	public static void layoutVertical(Rectangle area, Rectangle... itens) {
		int divisao = area.height;
		for (Rectangle r : itens) {
			divisao -= r.height;
		}
		divisao /= itens.length + 1;
		int posicao = area.y + divisao;
		for (Rectangle r : itens) {
			r.setLocation(r.x, posicao);
			posicao += divisao + r.height;
		}
		centralizarHorizontalmente(area, itens);
	}

}
