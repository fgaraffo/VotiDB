package testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {

	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:mysql://localhost/voti?user=root&password=fede&serverTimezone=UTC";
		
		try 
		{
			// FACTORY, driver manager ha dentro una factory di connessione
			Connection conn = DriverManager.getConnection(jdbcURL); 
				
			Statement st = conn.createStatement(); // si usa PreparedStatement
			
			String sql = "SELECT Nome,Voto " + 
					"FROM libretto " + 
					"ORDER BY voto DESC;";
			
			ResultSet res = st.executeQuery(sql); // executeQuery --> SELECT
			
			// ResultSet implementa un cursore sul risultato della query (una tabella)	
			// metodi get per leggere un dato alla volta
			// ha 2 righe in più, una all'inizio ed una alla fine
			
			while(res.next())
			{
				String nome = res.getString("nome");
				int voto = res.getInt("voto");
				
				System.out.format("Voto %d dell'esame %s\n", voto,nome);
				
			}
			
			st.close();
			
			// qui potresti creare un altro statement...
			
			conn.close();
					
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}

}
