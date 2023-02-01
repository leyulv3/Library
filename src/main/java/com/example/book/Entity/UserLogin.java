package com.example.book.Entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


import java.io.Serializable;
@Data
@TableName("admin")
public class UserLogin implements Serializable {
	@TableId("user_id")
	private String userId;	//用户ID
	private String userPassword;	//用户密码
	//设置默认值
	private String userType;	//用户类型
	private String userStatus;
	@TableField(exist = false)
	private String newPassword;

	public UserLogin() {
	}

	public UserLogin(String userId, String userPassword, String userType, String userStatus) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userStatus = userStatus;
	}

	public UserLogin(String userId, String userPassword, String userType, String userStatus, String newPassword) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userStatus = userStatus;
		this.newPassword = newPassword;
	}
}
