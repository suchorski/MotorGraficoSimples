package com.suchorski.motorgraficosimples.principal;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Optional;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.suchorski.motorgraficosimples.abstratos.imagens.Tela;

public class MotorGrafico extends JFrame implements KeyListener {
	
	class Grafico extends JPanel {
		
		private Optional<Tela> tela = Optional.empty();
		
		public Grafico(int comprimento, int altura) {
			setPreferredSize(new Dimension(comprimento, altura));
		}
		
		public Tela getTela() {
			return tela.orElse(null);
		}
		
		public void setTela(Tela tela) {
			this.tela = Optional.of(tela);
		}
		
		public void atualiza() {
			tela.ifPresent(t -> t.atualiza());
		}
		
		@Override
		public void paint(Graphics g) {
			tela.ifPresent(t -> {
				t.desenha(g);
			});
		}
		
		public void teclaPressionada(KeyEvent e) {
			tela.ifPresent(t -> t.teclaPressionada(e));
		}

		public void teclaSolta(KeyEvent e) {
			tela.ifPresent(t -> t.teclaSolta(e));
		}
		
	}
	
	private Grafico grafico;
	private int comprimento;
	private int altura;
	private int fps;
	private Timer atualizador;
	
	public MotorGrafico(String nomeDoJogo, int comprimento, int altura, int fps) {
		super(nomeDoJogo);
		grafico = new Grafico(comprimento, altura);
		this.comprimento = comprimento;
		this.altura = altura;
		this.fps = fps;
		setResizable(false);
		this.add(grafico);
		this.pack();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		addKeyListener(this);
		atualizador = new Timer();
		atualizador.scheduleAtFixedRate(new Atualizador(this), 0, 1000 / this.fps);
	}
	
	public Tela getTela() {
		return grafico.getTela();
	}
	
	public void setTela(Tela tela) {
		grafico.setTela(tela);
	}
	
	public int getComprimento() {
		return comprimento;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public int getFps() {
		return fps;
	}
	
	public void setFps(int fps) {
		this.fps = fps;
		atualizador.cancel();
		atualizador = new Timer();
		atualizador.scheduleAtFixedRate(new Atualizador(this), 0, 1000 / fps);
	}
	
	public void atualiza() {
		grafico.atualiza();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		return;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		grafico.teclaPressionada(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		grafico.teclaSolta(e);
	}
	
	public void iniciar() {
		setVisible(true);
	}

}
