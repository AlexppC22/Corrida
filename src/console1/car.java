package console1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel; 

public class car 
{	
	JLabel picLabel;
	int currentYPos;
	int currentXPos;
	public car(int yPos, JFrame f)
	{
		CarDraw(yPos, f);
	}
	
	public void CarDraw(int yPos, JFrame f)
	{
		try {
			BufferedImage myPicture = ImageIO.read(new File("images/carro.png"));
			picLabel = new JLabel(new ImageIcon(myPicture));
			currentYPos = yPos;
			currentXPos = 0;
			picLabel.setBounds(currentXPos, currentYPos, 150, 75); 
			f.add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void CarUpdate()
	{
		currentXPos += 1;
		picLabel.setBounds(currentXPos, currentYPos, 150, 75);
	}
}
