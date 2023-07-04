package View.GUI.USER;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import View.GUI.MemberGUI;

public class UserUI extends JFrame implements ActionListener {
    JButton bookSearch_btn;
    JButton rentalCheck_btn;
    JButton myInfo_btn;
    JButton logout_btn;

    MemberGUI mainUI;

    public UserUI() {
        super("USER UI");
        setBounds(10, 10, 250, 130);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        bookSearch_btn = new JButton("도서조회");
        rentalCheck_btn = new JButton("대여확인");
        myInfo_btn = new JButton("나의정보");
        logout_btn = new JButton("로그아웃");

        bookSearch_btn.setBounds(10,10,100,30);
        rentalCheck_btn.setBounds(120,10,100,30);
        myInfo_btn.setBounds(10,50,100,30);
        logout_btn.setBounds(120,50,100,30);

        bookSearch_btn.addActionListener(this);
        rentalCheck_btn.addActionListener(this);
        myInfo_btn.addActionListener(this);
        logout_btn.addActionListener(this);
 
        panel.add(bookSearch_btn);
        panel.add(rentalCheck_btn);
        panel.add(myInfo_btn);
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
        if(e.getSource() == bookSearch_btn) {
            //도서조회 기능 구현
            //도서목록 조회에 관련된 클래스 추가 및 인스턴스 생성 후, setVisible(true)
        } else if (e.getSource() == rentalCheck_btn) {
            //대여확인 기능 구현
            //대여현황 조회에 관련된 클래스 추가 및 인스턴스 생성 후, setVisible(true)
        } else if (e.getSource() == myInfo_btn) {
            //나의정보 기능 구현
            //사용자 개인정보 조회 및 수정에 관련된 클래스 추가 및 인스턴스 생성 후, setVisible(true)
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