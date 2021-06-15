package tp3;

public class Dni {

	public Dni() 
	{
		
	}
	
	public static boolean validarDni(String dni) throws SoloNumerosException
	{
		//boolean letras = false;
		int num;
		
		try 
		{
			num=Integer.parseInt(dni);
			return true;
		}
		catch(Exception e)
		{
			throw new SoloNumerosException();
		}
		
		
		//return letras;
	}

	
	
}
