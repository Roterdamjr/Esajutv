package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import modelo.VaraAno;

public class LeitorCSV {
	
    ArrayList<VaraAno> lista = new ArrayList<>();
    
	public ArrayList<VaraAno>  readCSV(String filePath)  {
 
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";"); // Ajuste o separador se necessário
                
                if (campos.length >= 2) { // Certifique-se de que há pelo menos duas colunas
                    
                    VaraAno varaAno = new VaraAno(campos[0],
					                    		Integer.parseInt(campos[1]),
					                    		campos[2].trim(),
					                    		Integer.parseInt(campos[3]));

                    lista.add(varaAno);
                }
            }
        } catch (IOException e) {  e.printStackTrace(); }
        
        return lista;
	}
	

	

}
