package 课程管理系统;

//检查登录用户名和密码
public class LoginCheck{
	private String name ;
	private String password ;
	
	public LoginCheck(String name,String password){
		this.name = name ;
		this.password = password ;
	}
	
	public boolean validate(){
		//默认管理员账户和密码(root,java)
		if("root".equals(name)&&"java".equals(password)){
			return true ;
		}else{
			return false ;
		}
	}
}

