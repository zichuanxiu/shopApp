package org.deepthought.bean;
/*
 * 
 * 'ID',
        'LOGIN_NAME',
        'PASSWORD',
        'NAME',
        'SEX',
        'EMAIL',
        'PHONE',
        'ADDRESS',
        'ROLE',
        'CREATE_DATE',
        'DISABLED',
        'ACTIVE');
 */
public class User {
	private String id;
	private String login_name;
	private String password;
	private String name;
	private String sex;
	private String email;
	private String phone;
	private String address;
	private String role;
	private String create_date;
	private String disabled;
	private String active;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", login_name=" + login_name + ", password="
				+ password + ", name=" + name + ", sex=" + sex + ", email="
				+ email + ", phone=" + phone + ", address=" + address
				+ ", role=" + role + ", create_date=" + create_date
				+ ", disabled=" + disabled + ", active=" + active + "]";
	}
	
	
}
