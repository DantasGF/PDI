
import br.edu.fescfafic.imagempdi.classes.Imagem;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gutemberg
 */
public class TestaSuavizacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedImage img = ImageIO.read(new File("/home/gutemberg/Área de Trabalho/gato.jpg"));
            Imagem i = new Imagem();
            img = i.mediaSuavizacao(img);
            ImageIO.write(img, "jpg", new File("/home/gutemberg/Área de Trabalho/teste.jpg"));
        } catch (IOException ex) {
            System.err.println("Erro: " + ex);
        }
    }
    
}
