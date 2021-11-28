package console1;

import javax.swing.JFrame;

public class Corrida 
{
	public car[] carros;
	
	public Corrida()
	{
		System.out.println("========================");
		System.out.println("Começou uma nova corrida");
		System.out.println("========================");
	}
	
	public void SetupCorrida(JFrame f)
	{
		carros = new car[5];
		for(int i = 0; i < carros.length; i++)
		{
			carros[i] = new car( i * 120 ,f, i+1);
		}
	}
	
	public void UpdateCorrida()
	{
		for(int i = 0; i < carros.length; i++)
		{
			carros[i].CarUpdate();
		}
	}
}
