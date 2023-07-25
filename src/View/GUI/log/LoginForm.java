package View.GUI.log;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Domain.Common.Dao.MemberDao;
import Domain.Common.Dto.MemberDto;
import View.GUI.MemberGUI;


   

public class LoginForm extends JFrame implements ActionListener {
    private static MemberDto instance;
    private MemberGUI mainUI;
  
    
    public static MemberDto getInstance() {
        if(instance == null)
            instance = new MemberDto();
        return instance;
    }
    
    private JTextField idField;
    private JPasswordField pwField;
    private JButton loginButton;
    private JButton signUpButton;
    
    public LoginForm() {
        setTitle("로그인");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        idField = new JTextField();
        pwField = new JPasswordField();
        loginButton = new JButton("로그인");
        signUpButton = new JButton("회원가입");

        add(idField);
        add(pwField);
        add(loginButton);
        add(signUpButton);

        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(200, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            MemberDto dto = loginUser(idField.getText(), new String(pwField.getPassword()));
            if (dto != null) {
                JOptionPane.showMessageDialog(this, "환영합니다!");
                if (dto.getRole().equals("ROLE_MEMBER")) {
                    System.out.println("관리자 화면");
                } else {
                    System.out.println("일반 사용자 화면");
                }
                MemberGUI maingui = new MemberGUI();
                maingui.setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 맞지 않습니다");
            }
        } else if (e.getSource() == signUpButton) {
            SignUpForm signUpForm = new SignUpForm();
            signUpForm.setVisible(true);
            setVisible(false);
        }
    }

    private MemberDto loginUser(String username, String password) {
        MemberDto sampleUser = new MemberDto( "user", "1234", "user","W","Role_user");
        MemberDto sampleAdmin = new MemberDto( "admin", "1234", "admin","w","ROLE_MEMBER");

        if (sampleUser.getusername().equals(username) &&
            sampleUser.getPw().equals(password)) {
            return sampleUser;
        } else if (sampleAdmin.getusername().equals(username) &&
                   sampleAdmin.getPw().equals(password)) {
            return sampleAdmin;
        } else {
            return null;
        }
    }

	public LoginForm(MemberGUI mainUI) {
		 this.mainUI = mainUI;
		 
	}
}