package org.dimigo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame {

    //before문장, after문장 전역변수 설정
    public static String beforetext;
    public static String aftertext;
    public static String encodeResult;

    //사이트주소
    public static String siteURL = "https://papago.naver.com/?sk=ko&tk=en&st=";

    //배경색 설정
    Color b=new Color(255,204,255);

    JTextField text1;

    public MyFrame() {
        //기본 frame 설정
        String beforetext = "";
        this.setSize(300, 100); //frame 사이즈
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 닫기 설정
        this.setTitle("번역기"); //프로그램 표기이름

        //화면 중앙에 표시되게하기
        Dimension frameSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

        //레이어 설정
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();


        //베경화면 설정
        panel1.setBackground(b);
        panel2.setBackground(b);
        panel3.setBackground(b);

        //라벨1
        JLabel label1 = new JLabel("번역하고 싶은 문장을 적어주세요!!");
        panel2.add(label1);

        //input패널
        text1 = new JTextField(10);
        JButton button1 = new JButton("번역");
        panel3.add(text1);
        panel3.add(button1);
        button1.addActionListener(new Listener(this));

        //패널 정리
        panel1.add(panel2);
        panel1.add(panel3);
        this.add(panel1);


        //마무리설정
        this.setVisible(true);
        this.setResizable(false);


    }

    //"번역" 버튼 클릭시 이벤트
    class Listener implements ActionListener {

        JFrame frame;

        public Listener(JFrame f) {
            frame = f;
        }




        @Override
        public void actionPerformed(ActionEvent e) {
            String name = text1.getText();
            System.out.println("[+] 번역 버튼이 클릭되었습니다!!!!"); //log_번역
            beforetext = name;
            papago p = new papago(); //papago 클래스 호출
            dispose();
            new tmpPage();
            System.out.println("[+] 메세지 출력 완료"); //log_메세지
        }
    }
}
