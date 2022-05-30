package main.java.br.com.lp3a5.ifsp;

import java.util.*;

class EmptyStackException extends Exception {
public EmptyStackException(){
		super(new String("Could not acess the object within the stack due to the lacking of objects itself"));
  	}

  	public EmptyStackException(String message){
		super(message);
  	}
}

public class Main {
  	public static void main(String[] args) throws EmptyStackException {
		testFunction();
  	}

  	public static void testFunction() throws EmptyStackException {
    	List<String> listaDeString = new ArrayList<>();

		if(listaDeString.size() == 0) {
			throw new EmptyStackException();
		}
	}
}


