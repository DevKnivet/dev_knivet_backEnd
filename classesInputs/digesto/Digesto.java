package digesto;

import java.util.ArrayList;

public class Digesto {
	int id;
	int evt_type;
	String created_at;
	String target_url;
	String target_number;
	ArrayList<String> source_url = new ArrayList<String>();
	String source_user_custom;
	String api_name;
	Object data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEvt_type() {
		return evt_type;
	}
	public void setEvt_type(int evt_type) {
		this.evt_type = evt_type;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getTarget_url() {
		return target_url;
	}
	public void setTarget_url(String target_url) {
		this.target_url = target_url;
	}
	public String getTarget_number() {
		return target_number;
	}
	public void setTarget_number(String target_number) {
		this.target_number = target_number;
	}
	public ArrayList<String> getSource_url() {
		return source_url;
	}
	public void setSource_url(ArrayList<String> source_url) {
		this.source_url = source_url;
	}
	public String getSource_user_custom() {
		return source_user_custom;
	}
	public void setSource_user_custom(String source_user_custom) {
		this.source_user_custom = source_user_custom;
	}
	public String getApi_name() {
		return api_name;
	}
	public void setApi_name(String api_name) {
		this.api_name = api_name;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
