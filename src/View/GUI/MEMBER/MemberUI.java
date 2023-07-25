package View.GUI.MEMBER;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import View.GUI.MemberGUI;

public class MemberUI extends JFrame implements ActionListener {
    JButton productSearch_btn;
    JButton rentalManagement_btn;
    JButton userManagement_btn;
    JButton logout_btn;

    MemberGUI mainUI;

    public MemberUI() {
        super("MEMBER UI");
        setBounds(10, 10, 250, 130);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        productSearch_btn = new JButton("제품조회");
        rentalManagement_btn = new JButton("제품관리");
        userManagement_btn = new JButton("회원관리");
        logout_btn = new JButton("로그아웃");

        productSearch_btn.setBounds(10,10,100,30);
        rentalManagement_btn.setBounds(120,10,100,30);
        userManagement_btn.setBounds(10,50,100,30);
        logout_btn.setBounds(120,50,100,30);

        productSearch_btn.addActionListener(this);
        rentalManagement_btn.addActionListener(this);
        userManagement_btn.addActionListener(this);
        logout_btn.addActionListener(this);
 
        panel.add(productSearch_btn);
        panel.add(rentalManagement_btn);
        panel.add(userManagement_btn);
        panel.add(logout_btn);

        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 로그아웃 처리
                // 메인 창 활성화
                mainUI.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == productSearch_btn) {
        	//제품조회 기능 구현
        	//제품목록 조회에 관련된 클래스 추가 및 인스턴스 생성 후, setVisible(true)
        } else if (e.getSource() == rentalManagement_btn) {
        	//제품관리 및 대여 기능 구현
		//제품 대여 및 관리에 관련된 클래스 추가 및 인스턴스 생성 후, setVisible(true)
        } else if (e.getSource() == userManagement_btn) {
        	//회원관리 기능 구현
		//회원 관리에 관련된 클래스 추가 및 인스턴스 생성 후, setVisible(true)
        } else if (e.getSource() == logout_btn) {
        	//로그아웃 기능 구현
        	this.dispose();
        	mainUI.setVisible(true);
        }
    }

    public void setMainUI(MemberGUI mainUI) {
        this.mainUI = mainUI;
    }
}