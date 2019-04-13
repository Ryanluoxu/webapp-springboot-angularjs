package io.ryanluoxu.customerManager.bean.input;

public class QueryInput {
	
	private String queryType;
	private String param;
	private String value;
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public QueryInput(String queryType, String param, String value) {
		super();
		this.queryType = queryType;
		this.param = param;
		this.value = value;
	}

}
