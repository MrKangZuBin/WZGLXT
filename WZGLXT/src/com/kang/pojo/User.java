package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer userid;

    private String loginname;

    private String password;

    private String status;

    private Date createdate;
    
    public User(){}
    
	public User(Integer userid, String loginname, String password, String status, Date createdate) {
		this.userid = userid;
		this.loginname = loginname;
		this.password = password;
		this.status = status;
		this.createdate = createdate;
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}