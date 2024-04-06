package com.sarthak.employee.management.system.employee.cntlExceHandling;

public class ExceptionModel {
	private String msg;
	private String excCode;
	
	public ExceptionModel() {
		
	}
	
	public ExceptionModel(String msg, String excId) {
		this.msg=msg;
		this.excCode=excId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getExcCode() {
		return excCode;
	}

	public void setExcCode(String excCode) {
		this.excCode = excCode;
	}

	@Override
	public String toString() {
		return "ExceptionModel [msg=" + msg + ", excCode=" + excCode + "]";
	}
	
	
}
