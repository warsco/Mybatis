package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import DTO.empDTO;

public class EmpMain {

	public static void main(String[] args) {
		String res = "config.xml";
		EmpMain main = new EmpMain();
		try {
			InputStream is = Resources.getResourceAsStream(res);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			
			main.selectMember(factory);
			
		}catch (IOException e) {
		}
	}
	
	
	public void selectMember(SqlSessionFactory factory) {
		SqlSession session = factory.openSession();
		
		try {
			
		List<empDTO> MemberList = session.selectList("member.select1");
		
		for(empDTO dto :MemberList) {
			System.out.println(dto);
		}
		}finally {
			session.close();
		}
	}

}
