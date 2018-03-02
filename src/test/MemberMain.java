package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.xml.sax.HandlerBase;

import DTO.MemberDTO;
import DTO.deptDTO;

public class MemberMain {
	
	public static void main(String[] args) {
		String res = "config.xml";
		MemberMain main = new MemberMain();
		try {
			InputStream is = Resources.getResourceAsStream(res);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			main.addDept(factory);
			main.selectMember(factory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void selectMember(SqlSessionFactory factory) {
		SqlSession session = factory.openSession();
		
		try {
		/*List<MemberDTO> MemberList = session.selectList("member.getMembers");
		
		for(MemberDTO dto :MemberList) {
			System.out.println(dto);
		}		*/
			
		HashMap<String, Integer> map = 
				new HashMap<String, Integer>();
		
		map.put("no", 60);
		deptDTO dept = session.selectOne("member.getDept",map);
		
		System.out.println(dept);

		
			
				
		}finally {
			session.close();
		}
	}
	
	public void addDept(SqlSessionFactory factory) {
		
		SqlSession session = factory.openSession();
		try {
			deptDTO dept = new deptDTO(60,"R&D");	
			int i = session.insert("member.addDept",dept);
			if(i>0) {
				session.commit();
				System.out.println(dept.getDeptno()+" 부서 정보가 저장됨");
				
			}
		}finally {
			
		}
		
	}
	
}
