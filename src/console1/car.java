package console1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel; 

public class car extends Thread
{	
	JLabel picLabel;
	JFrame f;
	
	public Boolean canRun = true;
	public Corrida _corrida;
	
	int carID;
	private String carImageName;
	private String carName;
	
	public int initialSpd;
	public int currentSpd;
	public int aceleration;
	int maxDistace;
	
	int currentYPos;
	int currentXPos;
	public int xMovement;
	
	public car(int yPos, JFrame f, int carID, Corrida race, int maxDistance)
	{
		this.carID = carID;
		this._corrida = race;
		this.maxDistace = maxDistance;
		CarDraw(yPos, f);
	}
	
	public void CarDraw(int yPos, JFrame f)
	{
		try {
			this.f = f;
			carImageName = "images/carro-0" + carID + ".png";
			carName = "Carro " + carID;
			BufferedImage myPicture = ImageIO.read(new File(carImageName));
			picLabel = new JLabel(new ImageIcon(myPicture));
			currentYPos = yPos;
			currentXPos = 0;
			picLabel.setBounds(currentXPos, currentYPos, 150, 75); 
			f.add(picLabel);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public void run()
	{
		while(canRun)
		{
			CarUpdate();
			f.repaint(0,0,800,600);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(this.currentXPos >= maxDistace)
				_corrida.EndRace(carName);
		}
	}
	
	public void CarUpdate()
	{
		Random r = new Random();
		
		aceleration = r.nextInt(5);
		
		currentSpd = initialSpd + aceleration * 1;
		initialSpd = currentSpd;
		
		xMovement = currentXPos + currentSpd * 1;
		picLabel.setBounds(xMovement, currentYPos, 150, 75);
		currentXPos = xMovement;
		
		System.out.println("O " + carName + " andou " + currentSpd + "m e já percorreu " + currentXPos + "m.");
	}
}
