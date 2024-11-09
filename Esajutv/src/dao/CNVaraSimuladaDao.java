package dao;

import java.sql.PreparedStatement;

import modelo.VaraAno;

public class CNVaraSimuladaDao extends DaoBase{
	
	public void inserir()  {

		String sql = "INSERT INTO TB_CN_VARA_SIMULADA select *  from tb_cn_vara ";

		try {        	        
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
			super.close();
		} catch (Exception e) {trataErro("Erro de banco de dados:",e);	}
	}
	
	public void limpar()  {
		String sql = "DELETE FROM TB_CN_VARA_SIMULADA";
		
		try {        	        
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			super.close();
		} catch (Exception e) {	trataErro("Erro de banco de dados:",e);}
	}
	
	public void alterar(String varaTransferida)  {
		String sql ="update tb_cn_vara_simulada set jurisdicao='DC' where trim(vara)=?";
		
		try {        	        
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, varaTransferida);
			pstmt.executeUpdate();
		} catch (Exception e) {	trataErro("Erro de banco de dados:",e);}
		
		sql = "update tb_cn_vara_simulada set vara = 'NOVA' where trim(vara)=?";
		
		try {        	        
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, varaTransferida);
			pstmt.executeUpdate();
			super.close();
		} catch (Exception e) {	trataErro("Erro de banco de dados:",e);}
		
	}
	
}
