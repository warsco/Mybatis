package DTO;


public class deptDTO {
	
	private String dname;
	private int deptno;
	
	public deptDTO() {}
	public deptDTO(int deptno, String dname) {
		this.deptno= deptno;
		this.dname = dname;
	}
	
	public deptDTO(int deptno) {
		this.deptno= deptno;
		
	}
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	@Override
	public String toString() {
		return "deptDTO [dname=" + dname + ", deptno=" + deptno + "]";
	}

}
