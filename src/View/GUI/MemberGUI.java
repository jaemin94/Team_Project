package View.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import View.GUI.AUTH.LoginUI;
import View.GUI.log.SignUpForm;


public class MemberGUI extends JFrame implements ActionListener {

	
	public static SignUpForm signUpForm;
	public static JTable table;
	public static JScrollPane tableScroll;
	public static JTextField txt;
	public static JButton btn1;
	public static JButton btn2;
	public static JButton btn3;
	
	//
	LoginUI loginUI;
	
	public MemberGUI() {

		super("MAIN MENU");
		setBounds(10, 10, 500, 400);

		// 패널
		JPanel panel = new JPanel();
		panel.setLayout(null);

		
		//테이블 열이름
		String[] columnNames = {"도서코드", "도서명", "출판사","ISBN"};
		// 테이블 데이터 x 
		//테이블 모델
		DefaultTableModel model = new DefaultTableModel(columnNames,0);
		
		
		// 컴포넌트
		table = new JTable(model);
		tableScroll = new JScrollPane(table);
		
		txt = new JTextField("bookcode");
		btn1 = new JButton("도서조회");
		btn2 = new JButton("회원가입");
		btn3 = new JButton("로그인");
		
		
		// 위치 조정
		txt.setBounds(10,10,200,30);
		btn1.setBounds(350,10,100,30);
		btn2.setBounds(350,50,100,30);
		btn3.setBounds(350,90,100,30);
		tableScroll.setBounds(10,140,440,200);
		
		//EVENT
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		// 컴포넌트를 패널에 추가
		panel.add(txt);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(tableScroll);
		
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//loginUI
		loginUI = new LoginUI();
		loginUI.setVisible(false);
		loginUI.setMainUI(this);
		
		  // 회원 가입 폼 초기화
        signUpForm = new SignUpForm();
        signUpForm.setSize(350, 300);
        signUpForm.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn1) {
			System.out.println("BTN1 CLICK ");
		}else if(e.getSource()==btn2) {
			System.out.println("BTN2 CLICK ");
			  signUpForm.setVisible(true); 
		}else if(e.getSource()==btn3) {
			System.out.println("BTN3 CLICK ");
			
			loginUI.setVisible(true);
			this.setVisible(false);
		}
		
	}
}
