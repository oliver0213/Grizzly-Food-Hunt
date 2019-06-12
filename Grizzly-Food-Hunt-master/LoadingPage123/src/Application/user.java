/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 *
 * @author yunfa
 */


class User {
	private String account;
	private String pwd;
	public User(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public boolean equals(Object obj) { //覆盖equals方法,为了实现账户和密码相同的User是同一个对象,如果不覆盖,比较的时候会按照哈希值
		
		if (obj instanceof User) {
			if (this.getAccount().equals(((User) obj).getAccount())
					&& this.getPwd().equals(((User) obj).getPwd())) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
}
