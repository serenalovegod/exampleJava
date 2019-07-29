package cn.cdutetc.example11;

public class TestBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Bank bank=new Bank();
       bank.transferAccounts("A", "B",5);
       bank.Display();
	}

}
