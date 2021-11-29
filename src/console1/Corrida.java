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
			if(i != 0)
			carros[i] = new car( i * 120 ,f, i+1, this, 650);
			else
			{
				carros[i] = new car(15, f, i+1, this, 650);
			}
		}
	}
	
	public void StartRace(JFrame f)
	{
		for(int i = 0; i < carros.length; i++)
			carros[i].start();
		
		for(int i = 0; i < carros.length; i++)
		{
			try {
				carros[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void EndRace(String carName)
	{
		for(int i = 0; i < carros.length; i++)
			carros[i].canRun = false;

		System.out.println("Fim da corrida - "+ carName +" é o ganhador");
	}
}
