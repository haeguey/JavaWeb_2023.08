package com.example.demo.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex03_UpdateParameter {

	public static void main(String[] args) {
		int custId = 1;
		String phone = "010-9876-5432";
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hmuser", "hmpass");
			String sql = "update customer set phone=? where custid=?";	// phone="010-9876-5432" and custId=1
			
			// parameter setting
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			pstmt.setInt(2, custId);
			
			// Query with no return value (반환값이 없는 Query 실행)
			pstmt.executeUpdate();
			// conn.commit();		// 자동 commit이 설정되어 있으면 실행하면 안됨
			
			// return resource
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
