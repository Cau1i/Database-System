package �γ̹���ϵͳ;

//����¼�û���������
public class LoginCheck{
	private String name ;
	private String password ;
	
	public LoginCheck(String name,String password){
		this.name = name ;
		this.password = password ;
	}
	
	public boolean validate(){
		//Ĭ�Ϲ���Ա�˻�������(root,java)
		if("root".equals(name)&&"java".equals(password)){
			return true ;
		}else{
			return false ;
		}
	}
}

