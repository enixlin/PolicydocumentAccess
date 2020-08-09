package com.enixlin.policydocument.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.enixlin.policydocument.service.DBService;

public class UpdateController {

	public UpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean checkRemoteUpdatePackage() {
		boolean existFlag = false;

		return existFlag;

	}

	public String getUpdatePackageInfo() {
		String info = "";
		return info;
	}

	public void test() {
		// TODO Auto-generated method stub
		System.out.println("dbs test run");
		// 建立连接
		String URL = "jdbc:mysql://localhost:3306/jmrc?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
		String USER = "linzhenhuan";
		String PASSWORD = "aAbc123456!";
		DBService dbs = new DBService(URL,USER,PASSWORD);

		String sql = "select * from settle_record where product_name in %?% ";
		ArrayList<Object> params=new ArrayList<>();
		ArrayList<String> params_arr=new ArrayList<>();
		params_arr.add("汇出汇款");
		params_arr.add("汇入汇款");
		params.add(params_arr);

		ArrayList<String> list = new ArrayList<>();
		try {		
		
			ArrayList<LinkedHashMap<String, String>> result=dbs.query(sql, params);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
