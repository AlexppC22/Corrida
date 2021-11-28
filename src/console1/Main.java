package console1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main 
{
	static JFrame f = new JFrame();
	static Corrida _corrida = new Corrida();
	static boolean running = true;
	public static void main(String[] args)
	{
		try {
			_corrida.SetupCorrida(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DrawWindow();
		UpdateFrames();
	}
	
	public static void UpdateFrames()
	{
		long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        
		while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                Tick();
                delta--;
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
            }
        }
	}
	
	public static void Tick()
	{
		_corrida.UpdateCorrida();
		f.repaint(0,0,800,600);
	}
	
	public static void DrawWindow()
	{
		try {
			BufferedImage myPicture = ImageIO.read(new File("images/linha-chegada.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setBounds(750,0,50,600);
			f.add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			BufferedImage myPicture = ImageIO.read(new File("images/fundo-corrida.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setBounds(0,0,800,600);
			f.add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		f.setSize(800,600);
		f.setLayout(null);
		f.setVisible(true);
	}
}
