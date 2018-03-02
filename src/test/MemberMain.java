package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import DTO.deptDTO;

public class MemberMain {
	
	public static void main(String[] args) {
		String res = "config.xml";
		MemberMain main = new MemberMain();
		try {
			InputStream is = Resources.getResourceAsStream(res);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//main.addDept(factory);
			//main.deleteDept(factory);
			//main.selectMember(factory);
			//main.updateDept(factory);
			main.dept(factory);
			
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
			deptDTO dept = new deptDTO(50,"R&D");	
			int i = session.insert("member.addDept",dept);
			if(i>0) {
				session.commit();
				System.out.println(dept.getDeptno()+" 부서 정보가 저장됨");
				
			}
		}finally {
			session.close();
		}
		
	}
	
	public void deleteDept(SqlSessionFactory factory) {
		
		SqlSession session = factory.openSession();
		try {
			int i = session.delete("member.deleteDept",60);
			if(i>0) {
				session.commit();
				System.out.println("부서 정보가 삭제됨");
			}
		}finally {
			
		}
		
	}
	
	public void updateDept(SqlSessionFactory factory) {
		
		SqlSession session = factory.openSession();
		try {
			int dept = -1;
			HashMap map = new HashMap();
			map.put("dname", "기획팀");
			map.put("deptno", 50);
			dept = session.update("member.updateDept",map);
			session.commit();
			System.out.println(dept);
		}finally {
			session.close();
		}
		
	}
	
	//deptno가 10, 20, 30인 부서정보 출력
	public void dept(SqlSessionFactory factory) {
		
		SqlSession session = factory.openSession();
		try {
			
			List<Integer> test = new ArrayList<Integer>();
			test.add(10);
			test.add(20);
			test.add(30);
			List<deptDTO> deptList = session.selectList("member.deptnofor",test);
			
			
			for(deptDTO dto : deptList) {
				System.out.println(dto);
			}
			
		}finally {
			session.close();
		}
		
	}
	
}