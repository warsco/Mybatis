package test;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberMain {
	
	public static void main(String[] args) {
		String res = "config.xml";
		
		
		try {
			
			InputStream is = Resources.getResourceAsStream(res);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
