package com.lsy.toy.user.dto;

public class UserVO {
	String enr_user_no;
	String enr_user_id;
	String enr_user_position;
	String enr_user_group;
	String create_grant;
	String read_grant;
	String update_grant;
	String delete_grant;
	String enr_user_pw;
    String enr_user_re_pwd;
	
	@Override
	public String toString() {
		return "UserVO [enr_user_no=" + enr_user_no + ", enr_user_id=" + enr_user_id + ", enr_user_position=" + 
				enr_user_position + ", enr_user_group=" + enr_user_group + ", create_grant=" + create_grant + ", read_grant=" + 
				read_grant + ", update_grant=" + update_grant + ", delete_grant=" + delete_grant + ", enr_user_pw=" + 
				enr_user_pw + ", enr_user_re_pwd=" + enr_user_re_pwd + "]";
	}

	public String getEnr_user_no() {
		return enr_user_no;
	}

	public void setEnr_user_no(String enr_user_no) {
		this.enr_user_no = enr_user_no;
	}

	public String getEnr_user_id() {
		return enr_user_id;
	}

	public void setEnr_user_id(String enr_user_id) {
		this.enr_user_id = enr_user_id;
	}

	public String getEnr_user_pw() {
		return enr_user_pw;
	}

	public void setEnr_user_pw(String enr_user_pw) {
		this.enr_user_pw = enr_user_pw;
	}

	public String getEnr_user_re_pwd() {
		return enr_user_re_pwd;
	}

	public void setEnr_user_re_pwd(String enr_user_re_pwd) {
		this.enr_user_re_pwd = enr_user_re_pwd;
	}

	public String getEnr_user_group() {
		return enr_user_group;
	}

	public void setEnr_user_group(String enr_user_group) {
		this.enr_user_group = enr_user_group;
	}

	public String getCreate_grant() {
		return create_grant;
	}

	public void setCreate_grant(String create_grant) {
		this.create_grant = create_grant;
	}

	public String getRead_grant() {
		return read_grant;
	}

	public void setRead_grant(String read_grant) {
		this.read_grant = read_grant;
	}

	public String getUpdate_grant() {
		return update_grant;
	}

	public void setUpdate_grant(String update_grant) {
		this.update_grant = update_grant;
	}

	public String getDelete_grant() {
		return delete_grant;
	}

	public void setDelete_grant(String delete_grant) {
		this.delete_grant = delete_grant;
	}

	public String getEnr_user_position() {
		return enr_user_position;
	}

	public void setEnr_user_position(String enr_user_position) {
		this.enr_user_position = enr_user_position;
	}
	
}