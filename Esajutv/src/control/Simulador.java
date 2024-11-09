package control;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.VaraAno;

public class Simulador {
	
	ArrayList<VaraAno> listaMedias =new ArrayList<VaraAno>();
	
	public void simular(HashMap<String, VaraAno> dataBase,  String varaRemovida, String JurisdicaoDestino ) {
		
	}
	
	public ArrayList<VaraAno>  calculaMedias(int anoInicial, int anoFinal, ArrayList<VaraAno> lista) {
		/*
		 * recebe uma lista com VARA + ANO +JURISDICAO + CASOS_NOVOS
		 * retorna VARA +  JURISDICAO + MEDIA DE CASOS_NOVOS 
		 * filtrado por periodo de  ANOS
		 */
		
		String vara="", jurisdicao="";
		int soma=0,cont=0;
		
		for (VaraAno linha : lista) {
			if(!vara.equals(linha.getVara()) && vara != ""){
				listaMedias.add(new VaraAno(vara, jurisdicao, soma));
				System.out.println(vara + ", " + soma/cont );
				cont=0;
				soma=0;
			 };
			
			if(linha.getAno()>=anoInicial && linha.getAno()<=anoFinal) {
				//soma += linha.getCasosNovos();
				cont++;
			}
			vara = linha.getVara();
			jurisdicao = linha.getJurisdicao();
		}
		
		listaMedias.add(new VaraAno(vara, jurisdicao, soma/cont));
		
		return listaMedias;

	}
}
