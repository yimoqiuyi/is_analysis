package com.yp.common.utils;

import java.io.Serializable;

public class ResultUtil implements Serializable {
	private Integer code;
	private String msg="";
	private int count=0;
	private Object data;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ResultUtil() {
		super();
	}

	public ResultUtil(Integer code) {
		super();
		this.code = code;
	}

	public ResultUtil(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}



	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static ResultUtil ok(){
		return new ResultUtil(0);
	}
	
	public static ResultUtil ok(Object list){
		ResultUtil result = new ResultUtil();
		result.setCode(0);
		result.setData(list);;
		return result;
	}
	public static ResultUtil ok(String msg){
		ResultUtil result = new ResultUtil();
		result.setCode(0);
		result.setMsg(msg);
		return result;
	}
	
	public static ResultUtil error(){
		return new ResultUtil(500,"没有此权限，请联系超管！");
	}
	public static ResultUtil error(String str){
		return new ResultUtil(500,str);
	}
}
