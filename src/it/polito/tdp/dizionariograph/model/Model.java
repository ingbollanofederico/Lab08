package it.polito.tdp.dizionariograph.model;

import java.util.ArrayList;
import java.util.*;
import org.jgrapht.*;
import org.jgrapht.graph.*;

import it.polito.tdp.dizionariograph.db.WordDAO;

import java.util.List;

public class Model {
	
	//1. Creo grafo ed idMap
	private Graph<String,DefaultEdge> grafo;
	private Map<String, Integer> idMap;
	
	//2.creo il grafo
	public void creaGrafo(int lenght) {
		
		//creo grafo e mappa
		grafo = new SimpleGraph<>(DefaultEdge.class);
		idMap = new HashMap<>();
		
		//popolo idMap e modifico DAO
		WordDAO dao = new WordDAO();
		dao.getAllWordsFixedLength(lenght,idMap);
		
		//aggiungo i vertici
		Graphs.addAllVertices(grafo, idMap.keySet());
		
		//AGGIUNGO GLI ARCHI - direttamente da ciclo su mappa
		for(String p1: idMap.keySet()) {
			for(String p2: idMap.keySet()) {
				if(p2.compareTo(p1)>0 && isValid(p1,p2)) {
					grafo.addEdge(p1, p2);
				}
			}
		}
		
		
		
	}
	
	

	private boolean isValid(String p1, String p2) {
		int count=0;
		
		for(int i=0; i<p1.length(); i++) {
			if(p1.charAt(i)!=p2.charAt(i)) {
				count ++;
			}
		}
		
		if(count==1) {
			return true;
		}else {
			return false;
		}
	}
	
	//VERTICI E ARCHI COSTRUITI
	public Integer getVertexSize() {
		return grafo.vertexSet().size();
	}
	
	public Integer getEdgeSize() {
		return grafo.edgeSet().size();
	}
	
	public Graph<String, DefaultEdge> getGrafo() {
		return grafo;
	}



	public List<String> displayNeighbours(String parolaInserita) {
		
		//if(this.idMap.containsKey(parolaInserita)) {
		
		List<String> lista = new ArrayList<String>();
		
		for(DefaultEdge e : grafo.edgesOf(parolaInserita)) {
			if(grafo.getEdgeSource(e).equals(parolaInserita)) {
				lista.add(grafo.getEdgeTarget(e));
			}else {
				lista.add(grafo.getEdgeSource(e));
			}
			
			
		}
		
		//}
		
			return lista;
		//	return null;
		
		
		
	}

	public String findMaxDegree() {
		
		int degree =0;
		String vertice="";
		
		for(String s : grafo.vertexSet()) {
			if(grafo.degreeOf(s)>degree) {
				degree=grafo.degreeOf(s);
				vertice=s;
			}
		}
		
		return vertice+" "+degree;
	}
	
	
}
