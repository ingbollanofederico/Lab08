package it.polito.tdp.dizionariograph.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model m = new Model();
		
		m.creaGrafo(4);
		System.out.println(String.format("**Grafo creato**\n"));
		System.out.println("VERTICI "+m.getVertexSize()+" archi "+m.getEdgeSize());
	//	System.out.println(m.getGrafo().edgeSet());
		
		System.out.println("NODI VICINI ALLA PAROLA CIAO: "+m.displayNeighbours("ciao"));
		
		
		System.out.println(m.findMaxDegree());
		
		
		
		/*List<String> vicini = model.displayNeighbours("casa");
		System.out.println("Neighbours di casa: " + vicini + "\n");
		
		System.out.println("Cerco il vertice con grado massimo...");
		System.out.println(model.findMaxDegree());*/
	}

}
