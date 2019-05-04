/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fescfafic.imagempdi.classes;

import java.awt.Color;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Gutemberg
 */
public class Imagem {
    
    private double[][][] yiqMatriz;
    private double[][][] rgbMatriz;
    
    public Imagem(){
        
    }
    
    public String escolherImagem(){
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showOpenDialog(null);
        if(i == 0){
            File f = file.getSelectedFile();
            return f.getPath();
        }
        else if(i == 1){
            return null;
        }
        return null;
    }
    
    public BufferedImage abrirImagem(BufferedImage img){
        try {
            img = ImageIO.read(new File(escolherImagem()));
            return img;
        } catch (IOException ex) {
            System.err.println("Erro: " + ex);
        }
        return null;
    }
    
    public void exibirRgb(BufferedImage img){
        Color cor = new Color(img.getRGB(0, 0));
        System.out.println("Vermelho: " + cor.getRed() + 
                " Verde: " + cor.getGreen() + " Azul: " + cor.getBlue());
    }
    
    public int quantidadePixels(BufferedImage img){
        return img.getWidth() * img.getHeight();
    }
    
    public void salvarImagem(BufferedImage img){
        JFileChooser salvar = new JFileChooser();
        salvar.setFileFilter(new FileNameExtensionFilter(".jpg", "jpg"));
        salvar.setAcceptAllFileFilterUsed(false);
        int res = salvar.showSaveDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            try {
                String caminho = String.valueOf(salvar.getSelectedFile());
                ImageIO.write(img, "jpg", 
                        new File(caminho + salvar.getFileFilter()
                        .getDescription()));
                JOptionPane.showMessageDialog(null,
                        "Imagem salva com sucesso!");
            } catch (IOException ex) {
                System.err.println("Erro: " + ex);
            }
        }else{
            JOptionPane.showMessageDialog(null,
                    "Não foi possível salvar a imagem!");
        }
    }
    
    public BufferedImage pintarPrimeiroPixel(BufferedImage img){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        Color cor = new Color(255, 255, 255);
        img1.setRGB(0, 0, cor.getRGB());
        return img1;
    }

    public BufferedImage grayscaleRed(BufferedImage img){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                int red = new Color(img.getRGB(x, y)).getRed();
                Color escalaRed = new Color(red, red, red);
                img1.setRGB(x, y, escalaRed.getRGB());
            }
        }
        return img1;
    }
    
    public BufferedImage grayscaleGreen(BufferedImage img){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                int green = new Color(img.getRGB(x, y)).getGreen();
                Color escalaGreen = new Color(green, green, green);
                img1.setRGB(x, y, escalaGreen.getRGB());
            }
        }
        return img1;
    }
    
    public BufferedImage grayscaleBlue(BufferedImage img){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                int blue = new Color(img.getRGB(x, y)).getBlue();
                Color escalaBlue = new Color(blue, blue, blue);
                img1.setRGB(x, y, escalaBlue.getRGB());
            }
        }
        return img1;
    }
    
    public BufferedImage grayscaleMedia(BufferedImage img){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                int red = new Color(img.getRGB(x, y)).getRed();
                int green = new Color(img.getRGB(x, y)).getGreen();
                int blue = new Color(img.getRGB(x, y)).getBlue();
                int media = (red + green + blue) / 3;
                Color escalaMedia = new Color(media, media, media);
                img1.setRGB(x, y, escalaMedia.getRGB());
            }
        }
        return img1;
    }
    
    public BufferedImage bandaCorRed(BufferedImage img){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                int red = new Color(img.getRGB(x, y)).getRed();
                Color cor = new Color(red, 0, 0);
                img1.setRGB(x, y, cor.getRGB());
            }
        }
        return img1;
    }
    
    public BufferedImage bandaCorGreen(BufferedImage img){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                int green = new Color(img.getRGB(x, y)).getGreen();
                Color cor = new Color(0, green, 0);
                img1.setRGB(x, y, cor.getRGB());
            }
        }
        return img1;
    }
    
    public BufferedImage bandaCorBlue(BufferedImage img){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                int blue = new Color(img.getRGB(x, y)).getBlue();
                Color cor = new Color(0, 0, blue);
                img1.setRGB(x, y, cor.getRGB());
            }
        }
        return img1;
    }
    
    public BufferedImage limiarizar(BufferedImage img, int threshold){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        img = grayscaleMedia(img);
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                int red = new Color(img.getRGB(x, y)).getRed();
                if(red > threshold){
                    Color branco = new Color(255, 255, 255);
                    img1.setRGB(x, y, branco.getRGB());
                }
                else if(red < threshold){
                    Color preto = new Color(0, 0, 0);
                    img1.setRGB(x, y, preto.getRGB());
                }
            }
        }
        return img1;
    }
    
    public BufferedImage negativoRGB(BufferedImage img){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                Color cor = new Color(img.getRGB(x, y));
                Color negativo = new Color(255 - cor.getRed(),
                        255 - cor.getGreen(), 255 - cor.getBlue());
                img1.setRGB(x, y, negativo.getRGB());
            }
        }
        return img1;
    }
    
    public BufferedImage negativoY(BufferedImage img){
        BufferedImage rgb;
        
        double[][][] yiq = rgb2Yiq(img);

        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                yiq[x][y][0] = 255 - new Color(img.getRGB(x, y)).getRed();
            }
        }
        rgb = yiq2Rgb(yiq, img);
        return rgb;
    }
    
    public double[][][] rgb2Yiq(BufferedImage img){
        yiqMatriz = new double[img.getWidth()][img.getHeight()][3];
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                int red = new Color(img.getRGB(x, y)).getRed();
                int green = new Color(img.getRGB(x, y)).getGreen();
                int blue = new Color(img.getRGB(x, y)).getBlue();
                yiqMatriz[x][y][0] = 0.299 * red + 0.587 * green + 0.114 * blue;
                yiqMatriz[x][y][1] = 0.569 * red - 0.274 * green - 0.322 * blue;
                yiqMatriz[x][y][2] = 0.211 * red - 0.523 * green + 0.312 * blue;
            }
        }
        return yiqMatriz;
    }
    
    public BufferedImage yiq2Rgb(double[][][] matrizYiq, BufferedImage img){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        
        for(int p = 0; p < matrizYiq.length; p++){
            for(int m = 0; m < matrizYiq[p].length; m++){
                double red = 1.000 * matrizYiq[p][m][0] + 0.956 * 
                        matrizYiq[p][m][1] + 0.621 * matrizYiq[p][m][2];
                double green = 1.000 * matrizYiq[p][m][0] - 0.272 * 
                        matrizYiq[p][m][1] - 0.647 * matrizYiq[p][m][2];
                double blue = 1.000 * matrizYiq[p][m][0] - 1.106 * 
                        matrizYiq[p][m][1] + 1.703 * matrizYiq[p][m][2];
                
                if(red > 255){
                    red = 255;
                }
                if(red < 0){
                    red = 0;
                }
                
                if(green > 255){
                    green = 255;
                }
                if(green < 0){
                    green = 0;
                }
                
                if(blue > 255){
                    blue = 255;
                }
                if(blue < 0){
                    blue = 0;
                }
                
                int cor = new Color((int) red, 
                        (int) green, (int) blue).getRGB();
                
                img1.setRGB(p, m, cor);
            }
        }
        return img1;
    }
    
    public BufferedImage aditivoRGB(BufferedImage img, int brilho){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                Color c = new Color(img.getRGB(x, y));
                int red = brilho + c.getRed();
                int green = brilho + c.getGreen();
                int blue = brilho + c.getBlue();
                
                if(red > 255){
                    red = 255;
                }
                
                if(green > 255){
                    green = 255;
                }
                
                if(blue > 255){
                    blue = 255;
                }

                Color cor = new Color(red, green, blue);
                img1.setRGB(x, y, cor.getRGB());
            }
        }
        return img1;
    }
    
    public BufferedImage aditivoY(BufferedImage img, int brilho){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        double[][][] rgb = rgb2Yiq(img);
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                rgb[x][y][0] = brilho + rgb[x][y][0];
            }
        }
        img1 = yiq2Rgb(rgb, img);
        return img1;
    }
    
    public BufferedImage multiRGB(BufferedImage img, double brilho){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                Color c = new Color(img.getRGB(x, y));
                double red = brilho * c.getRed();
                double green = brilho * c.getGreen();
                double blue = brilho * c.getBlue();
                
                if(red > 255){
                    red = 255;
                }
                
                if(green > 255){
                    green = 255;
                }
                
                if(blue > 255){
                    blue = 255;
                }
                
                Color cor = new Color((int)red, (int)green, (int)blue);
                img1.setRGB(x, y, cor.getRGB());
            }
        }
        return img1;
    }
    
    public BufferedImage multiY(BufferedImage img, double brilho){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        double[][][] rgb = rgb2Yiq(img);
        double Y = 0;
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                Y = brilho * rgb[x][y][0];
                if(Y > 255){
                    Y = 255;
                }
                rgb[x][y][0] = Y;
            }
        }
        img1 = yiq2Rgb(rgb, img);
        return img1;
    }
    
    public BufferedImage mediaSuavizacao(BufferedImage img, int tamJanela){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        img = grayscaleMedia(img);
        int area = (tamJanela / 2);
        for(int x = area; x < img.getWidth() - area; x++){
            for(int y = area; y < img.getHeight() - area; y++){
                int media = 0;
                for(int x1 = x - area; x1 <= x + area; x1++){
                    for(int y1 = y - area; y1 <= y + area; y1++){
                        media += new Color((img.getRGB(x1, y1))).getRed();
                    }
                }
                media = (int) (media / (Math.pow(tamJanela, 2)));
                Color cor = new Color(media, media, media);
                img1.setRGB(x, y, cor.getRGB());
            }
        }
        return img1;
    }
    
    public BufferedImage medianaSuavizacao(BufferedImage img, int tamJanela){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        
        int[] pixels = new int[tamJanela * tamJanela];
        
        img = grayscaleMedia(img);
        int area = (tamJanela / 2);
        
        for(int x = area; x < img.getWidth() - area; x++){
            for(int y = area; y < img.getHeight() - area; y++){
                
                int i = 0;
                
                for(int x1 = x - area; x1 <= x + area; x1++){
                    for(int y1 = y - area; y1 <= y + area; y1++){
                        int cor = new Color(img.getRGB(x1, y1)).getRed();
                        if(i < pixels.length){
                            pixels[i] = cor;
                            i++;
                        }
                    }
                }
                Arrays.sort(pixels);
                int mediana = (int) pixels[(tamJanela * tamJanela) / 2];
                Color cor = new Color(mediana, mediana, mediana);
                img1.setRGB(x, y, cor.getRGB());
            }
        }
        return img1;
    }
    
    public BufferedImage modaSuavizacao(BufferedImage img, int tamJanela){
        BufferedImage img1 = new BufferedImage(img.getWidth(),
                img.getHeight(), 1);
        img = grayscaleMedia(img);
        int area = (tamJanela / 2);
        
        int[] pixels = new int[tamJanela * tamJanela];
        
        
        for(int x = area; x < img.getWidth() - area; x++){
            for(int y = area; y < img.getHeight() - area; y++){
                int i = 0;
                for(int x1 = x - area; x1 <= x + area; x1++){
                    for(int y1 = y - area; y1 <= y + area; y1++){
                        int moda = 0;
                        if(i < pixels.length){
                            pixels[i] = new Color(img.getRGB(x1, y1)).getRed();
                            i++;
                            
                        }
                    }
                }
//                media = (int) (media / (Math.pow(tamJanela, 2)));
//                Color cor = new Color(media, media, media);
//                img1.setRGB(x, y, cor.getRGB());
            }
        }
        Arrays.sort(pixels);
        System.out.println(Arrays.toString(pixels));
        return img1;
    }
}
