package com.sp.springJDBC.SpringJdbcBatch;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sp.bean.Account;
import com.sp.resource.JavaConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    
    {
    	
    	Account act1=new Account();
    	act1.setAccount(545);
    	act1.setFirstname("arhub");
    	act1.setLastname("notone");
    	act1.setBalance(23434);
    	
    	Account act2=new Account();
    	act2.setAccount(5454);
    	act2.setFirstname("artythub");
    	act2.setLastname("nottyone");
    	act2.setBalance(2334);
    	
    	Account act3=new Account();
    	act3.setAccount(5);
    	act3.setFirstname("autyrhub");
    	act3.setLastname("one");
    	act3.setBalance(34);
    	
    	final List<Account > account_list= new ArrayList<Account>();
    	
    	account_list.add(act3);
    	account_list.add(act2);
    	account_list.add(act1);
    	
    	ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
      
      JdbcTemplate  jbt=context.getBean(JdbcTemplate.class);
 
      String sql_query="insert into account values(?,?,?,?)";
      
      
      int[] count=jbt.batchUpdate(sql_query, new BatchPreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement ps, int i) throws SQLException {
			// TODO Auto-generated method stub
			
			Account ac=account_list.get(i);
			
			ps.setInt(1, ac.getAccount());
			
			ps.setString(2, ac.getFirstname());
			ps.setString(3, ac.getLastname());
			ps.setInt(4, ac.getBalance());
			
		}
		
		@Override
		public int getBatchSize() {
			// TODO Auto-generated method stub
			return account_list.size();
		}
	});
      
      
      for(int i: count)
      {
    	  System.out.println(i +": success");
      }
      
    }
}
