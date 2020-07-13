package com.suchorski.motorgraficosimples.abstratos.agrupadores;

import java.awt.Graphics;
import java.util.List;

import com.suchorski.motorgraficosimples.abstratos.itens.ItemMenu;

public class AgrupadorItemMenu {
	
	private List<ItemMenu> itens;
	private boolean infinito;
	private int indiceSelecionado;
	
	public AgrupadorItemMenu(List<ItemMenu> itens, boolean infinito) {
		this.itens = itens;
		this.infinito = infinito;
		indiceSelecionado = 0;
		for (ItemMenu i : itens) {
			if (i.isSelecionado()) {
				break;
			}
			++indiceSelecionado;
		}
		indiceSelecionado = indiceSelecionado >= itens.size() ? 0 : indiceSelecionado;
		itens.parallelStream().forEach(i -> i.setSelecionado(false));
		itens.get(indiceSelecionado).setSelecionado(true);
	}
	
	public List<ItemMenu> getItens() {
		return itens;
	}
	
	public void setItens(List<ItemMenu> itens) {
		this.itens = itens;
	}
	
	public boolean isInfinito() {
		return infinito;
	}
	
	public void setInfinito(boolean infinito) {
		this.infinito = infinito;
	}
	
	public int getIndiceSelecionado() {
		return indiceSelecionado;
	}
	
	public void setIndiceSelecionado(int indiceSelecionado) {
		if (indiceSelecionado >= 0 && indiceSelecionado < itens.size()) {
			this.indiceSelecionado = indiceSelecionado;
		}
	}
	
	public void proximo() {
		itens.get(indiceSelecionado).setSelecionado(false);
		if (infinito) {
			indiceSelecionado = (++indiceSelecionado) % itens.size();
		} else {
			if ((indiceSelecionado + 1) < itens.size()) {
				++indiceSelecionado;
			}
		}
		itens.get(indiceSelecionado).setSelecionado(true);
	}
	
	public void anterior() {
		itens.get(indiceSelecionado).setSelecionado(false);
		if (infinito) {
			--indiceSelecionado;
			if (indiceSelecionado < 0) {
				indiceSelecionado = itens.size() - 1;
			}
		} else {
			if (indiceSelecionado > 0) {
				--indiceSelecionado;
			}
		}
		itens.get(indiceSelecionado).setSelecionado(true);
	}
	
	public void desenha(Graphics g) {
		for (ItemMenu i : itens) {
			i.desenha(g);
		}
	}
	
}
