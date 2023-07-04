package View.GUI.log;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SignUpForm extends JFrame implements ActionListener {
    private JTextField idField;
    private JPasswordField pwField;
    private JTextField nameField;
    private JButton registerButton;
    private JButton cancelButton;
    
    public SignUpForm() {
        setTitle("회원가입");
        setLayout(new GridLayout(4, 2, 10, 10));

        idField = new JTextField();
        pwField = new JPasswordField();
        nameField = new JTextField();
        registerButton = new JButton("가입하기");
        cancelButton = new JButton("취소");

        add(new JLabel("아이디:"));
        add(idField);
        add(new JLabel("비밀번호:"));
        add(pwField);
        add(new JLabel("이름:"));
        add(nameField);
        add(registerButton);
        add(cancelButton);

        registerButton.addActionListener(this);
        cancelButton.addActionListener(this);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            // 회원가입 로직
            // 사용자가 입력한 값:
            String username = idField.getText();
            String password = String.valueOf(pwField.getPassword());
            String name = nameField.getText();

            // 입력한 값에 대한 검증 및 처리
            // 예를 들어, 사용자 이름 중복 검사, 비밀번호 속도 검사 등
            // 입력한 값이 유효한 경우 데이터베이스에 회원 정보 저장
        } else if (e.getSource() == cancelButton) {
            // ���소 버튼을 클릭하면 회원가입 창을 닫습니다.
            this.dispose();
            LoginForm loginForm = new LoginForm(); // 로그인 폼 인스턴스 생성
            loginForm.setVisible(true); // 로그인 폼 보이기
        }
    }
}