package View.GUI.AUTH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import View.GUI.MemberGUI;
import View.GUI.MEMBER.MemberUI;
import View.GUI.USER.UserUI;

public class LoginUI extends JFrame implements ActionListener{

	JTextField id_txt;
	JTextField pw_txt;
	JButton login_btn;
	
	//
	MemberGUI maingui;
	MemberUI membergui;
	UserUI usergui;
	
	public LoginUI(){
		super("MAIN MENU");
		setBounds(10, 10, 300, 150);

		// 패널
		JPanel panel = new JPanel();
		panel.setLayout(null);

		
		//
		id_txt = new JTextField();
		pw_txt = new JTextField();
		login_btn = new JButton("로그인");
		
		//
		id_txt.setBounds(10,10,150,30);
		pw_txt.setBounds(10,50,150,30);
		login_btn.setBounds(170,10,100,70);
		
		//EVENT
		login_btn.addActionListener(this);
		
		// 컴포넌트를 패널에 추가
		panel.add(id_txt);
		panel.add(pw_txt);
		panel.add(login_btn);
		 
		
		add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		
		membergui = new MemberUI();
		usergui = new UserUI();
		
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	
            	
            	maingui.setVisible(true);
            }
        });
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login_btn) {
			System.out.println("LOGIN_BTN");
			//로그인 체크
			
			
			//회원사서인지 판단해서 창띄우기
			if(id_txt.getText().equals("1"))
			{
				this.setVisible(false);
				membergui.setVisible(true);
			}
			else if(id_txt.getText().equals("2"))
			{
				this.setVisible(false);
				usergui.setVisible(true);
			}
			 
			
		}
		
	}
	
	//
	public void setMainUI(MemberGUI maingui) {
		this.maingui = maingui;
		membergui.setMainUI(maingui);
		usergui.setMainUI(maingui);
	}
	
	
}
