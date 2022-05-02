package main.java.br.com.lp3a5.ifsp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demonstracao {

	public static void main(String args[]) {		
		exemploFuncaoSorted();
		exemploFuncaoLimit();
	}
	
	public static void exemploFuncaoSorted() {
		final List<Integer> listaDeInteiros = Arrays.asList(6,10,15,5,2,4,4,5);
		
		//a funcao sorted recebe os dados da stream e retorna uma stream ordenada
		//é possivel tambem passar parametros de ordenação para sorted
		List<Integer> listaOrdenada = listaDeInteiros.stream()
				.sorted()
				.collect(Collectors.toList());
		listaOrdenada.forEach(System.out::println);
	}
	
	public static void exemploFuncaoLimit() {
		Stream<Integer> streamNumerosInfinitos = Stream.iterate(0, n -> n + 2);

		//com a funcao limit é possivel colocar um limite para o numero de dados
		//que a stream pode servir para o coletor ou terminal
		List<Integer> novaLista = streamNumerosInfinitos.limit(5)
		                                .collect(Collectors.toList());

		System.out.println("\n" + novaLista);	
	}
	
}
