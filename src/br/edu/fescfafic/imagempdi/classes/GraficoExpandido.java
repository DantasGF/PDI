/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.imagempdi.classes;

import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Gutemberg
 */
public class GraficoExpandido extends JFrame {
    
    public GraficoExpandido(){
        setTitle("Histogram - Gráfico: Com Expansão");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        setResizable(false);
    }
    
    public void graficoExpandido(BufferedImage img){
        DefaultCategoryDataset barra = new DefaultCategoryDataset();
        double[] histogram = new Imagem().histogram(img);
        for(int i = 0; i < histogram.length; i++){
            barra.setValue(histogram[i] * (img.getWidth() * img.getHeight()), ""+i, "");
        }
        JFreeChart grafico = ChartFactory.createBarChart("Histogram - Com expansão", "Pixels", "Quantidade de pixels", barra, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }
    
}
