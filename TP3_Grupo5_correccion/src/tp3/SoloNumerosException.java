package tp3;

import java.io.IOException;

public class SoloNumerosException extends IOException {

	public SoloNumerosException() 
	{
		
	}

	@Override
	public String getMessage() {
		
		return "Solo se permiten numeros.";
	}
	
	
	
}
