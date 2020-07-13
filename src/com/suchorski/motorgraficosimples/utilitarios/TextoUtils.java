package com.suchorski.motorgraficosimples.utilitarios;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

public class TextoUtils {
	
	public static void escreverTextoCentralizado(Graphics g, String texto, Rectangle enquadramento, Font fonte) {
		FontMetrics fontMetrics = g.getFontMetrics(fonte);
	    int x = enquadramento.x + (enquadramento.width - fontMetrics.stringWidth(texto)) / 2;
	    int y = enquadramento.y + ((enquadramento.height - fontMetrics.getHeight()) / 2) + fontMetrics.getAscent();
	    g.setFont(fonte);
	    g.drawString(texto, x, y);
	}

}
