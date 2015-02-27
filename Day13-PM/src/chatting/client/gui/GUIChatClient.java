package chatting.client.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIChatClient
	implements	ActionListener,	// 각종 GUI 컴포넌트(버튼 등등)들을 클릭 등의 작동을 시켰을 때,
								// 그에 대한 처리를 할 수 있도록
				Runnable	// 서버로부터 메시지 수신하고 수신 창에 표시
{
	
	// 채팅 서버 주소
	private String serverIpAddr = "127.0.0.1";	// "localhost"
	
	// 채팅 서버 포트 번호
	private int port = 3000;
	
	// 소켓
	private Socket sock;
	
	// 입출력 스트림
	private BufferedReader in;
	private PrintWriter out;
	
	// GUI 윈도우
	private JFrame window;
	
	// 로그인 전 상단에 들어갈 JPanel
	private JPanel loginPanel;
	private JLabel nickLabel;	// JLabel은 텍스트 또는 이미지를 표시하는 컴포넌트
	private JTextField nickTextField;	// JTextField는 텍스트를 입력 받거나 표시하는 컴포넌트
	private JButton loginButton;	// JButton은 클릭할 수 있는 버튼
	
	// 수신 메시지 출력
	private JTextArea recvTextArea;
	
	// 메시지 입력 패널
	private JPanel msgInputPanel;
	private JTextField msgTextField;
	private JButton exitButton;
	
	public GUIChatClient() {
		// loginPanel 생성
		loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());	// 레이아웃 설정
		// loginPanel 내부 컴포넌트 생성
		nickLabel = new JLabel("대화명:");
		nickTextField = new JTextField(15);
		loginButton = new JButton("로그인");
		loginButton.addActionListener(this);	// 로그인 버튼에 발생한 이벤트를 this 객체로 알려줌
		// loginPanel 내부 컴포넌트들을 loginPanel 내부에 배치
		loginPanel.add(nickLabel, BorderLayout.WEST);
		loginPanel.add(nickTextField, BorderLayout.CENTER);
		loginPanel.add(loginButton, BorderLayout.EAST);
		
		// 수신 메시지 출력
		recvTextArea = new JTextArea("", 10, 30);
		recvTextArea.setEditable(false);
		// 스크롤 바가 표시되도록 JScrollPane 객체로 JTextArea 객체 감싸줌
		JScrollPane jsp = new JScrollPane(recvTextArea,
									JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
									JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		// 메시지 입력 패널
		msgInputPanel = new JPanel();
		msgInputPanel.setLayout(new BorderLayout());
		// 내부에 들어갈 컴포넌트 생성
		msgTextField = new JTextField(30);
		msgTextField.addActionListener(this);
//		msgTextField.setEnabled(false);	// 메시지 입력 막기
		exitButton = new JButton("종료");
		exitButton.addActionListener(this);	// 이 버튼에 이벤트(클릭 등등)가 발생하면 this객체에게 알려줌
		// msgInputPanel에 내부 컴포넌트 배치
		msgInputPanel.add(msgTextField, BorderLayout.CENTER);
		msgInputPanel.add(exitButton, BorderLayout.EAST);
		
		// 클라이언트 윈도우
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("::채팅 클라이언트::");
		window.setSize(480, 320);
		window.setLayout(new BorderLayout());	// window는 BorderLayout이 관리하는 방법에 의해
												// 내부 컴포넌트를 배치 및 관리
		// 내부 컴포넌트 배치
		window.add(loginPanel, BorderLayout.NORTH);
		window.add(jsp, BorderLayout.CENTER);
		window.add(msgInputPanel, BorderLayout.SOUTH);
		
		window.setVisible(true);
	}
	
	@Override	// from ActionListener
	public void actionPerformed(ActionEvent e) {
		// 어떤 버튼 또는 어떤 컴포넌트에 이벤트가 발생했나?
		Object eventSource = e.getSource();
		
		if (eventSource == exitButton) {	// 종료버튼이 눌러졌을 때
			System.exit(0);	// 프로그램 종료
		}
		else if (eventSource == loginButton) {	// 로그인 버튼이 눌러졌을 때
			try {
				// 서버에 접속
				connect();
				
				// 대화명 변경 못하도록
				nickTextField.setEditable(false);
				
				// 로그인 버튼 클릭 못하도록
				loginButton.setEnabled(false);
				
				// 메시지 입력 텍스트 필드 활성화
//				msgTextField.setEnabled(true);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				if (e1.getMessage().equals("대화명 중복")) {
					recvTextArea.append("사용할 수 없는 대화명입니다. 다른 대화명을 사용하세요.\n");
					recvTextArea.setCaretPosition(recvTextArea.getDocument().getLength());
				}
			}
			
		}
		else if (eventSource == msgTextField) {	// 대화 입력 필드에서 엔터가 입력됐을 때
			// 서버에 접속되어 있는지 확인
			if (sock != null) {
				// 서버에 메시지 보내기
				out.println(msgTextField.getText());
				// 대화 입력 필드 비우기
				msgTextField.setText("");
			}
		}
	}
	
	@Override	// from Runnable
	public void run() {
		boolean recvThreadRunning = true;
		// 메시지 수신 반복
		while (recvThreadRunning) {
			try {
				String msg = in.readLine();	// 메시지 수신
				recvTextArea.append(msg + "\n");
				
				// 커서를 맨 뒤로 보냄 => 자동 스크롤 위해서
				recvTextArea.setCaretPosition(recvTextArea.getDocument().getLength());
			} catch (IOException e) {
				recvThreadRunning = false;
				e.printStackTrace();
			}
		}
	}
	
	private void connect() throws IOException, Exception {
		// 채팅 서버에 접속
		sock = new Socket(serverIpAddr, port);
		System.out.println("서버에 접속 성공");
		
		// 입출력 스트림 생성
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new PrintWriter(sock.getOutputStream(), true);
		
		// 대화명 전송
		out.println(nickTextField.getText());
		String result = in.readLine();
		System.out.println(result);
		if (result.equals("<<<OK>>>")) {
		} else {
			throw new Exception("대화명 중복");
		}
		
		// 메시지 수신을 위한 스레드 생성 및 시작
		Thread t = new Thread(this);
		t.start();
	}
	
	public static void main(String[] args) {
		
		GUIChatClient client = new GUIChatClient();
		
	}
	
}



























