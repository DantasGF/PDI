package br.edu.fescfafic.imagempdi.classes;

import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Gutemberg
 */
public class GraficoSemExpansao extends JFrame {
    
    public GraficoSemExpansao(){
        setTitle("Histogram - Gráfico: Sem expansão");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        setResizable(false);
    }
    
    public void grafico(BufferedImage img){
        DefaultCategoryDataset barra = new DefaultCategoryDataset();
        double[] histogram = new Imagem().histogram(img);
        for(int i = 0; i < histogram.length; i++){
            barra.setValue(histogram[i] * (img.getWidth() * img.getHeight()), ""+i, "");
        }
        JFreeChart grafico = ChartFactory.createBarChart("Histogram - Sem expansão", "Pixels", "Quantidade de pixels", barra, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }
}
