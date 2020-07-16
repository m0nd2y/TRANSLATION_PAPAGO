package org.dimigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import static org.dimigo.MyFrame.*;

public class outputpage extends JFrame {

    JTextField text2;
    public static String URL1;

    //배경색 설정
    Color b=new Color(255,204,255);

    outputpage() {
        this.setSize(300, 150); //프로그램 크기
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 옵션
        this.setTitle("번역기"); //프로그램 표기이름

        //레이어 설정
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        //화면 중앙에 표시되게하기
        Dimension frameSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

        //베경화면 설정
        panel1.setBackground(b);
        panel2.setBackground(b);
        panel3.setBackground(b);
        panel4.setBackground(b);

        //라벨2번째
        JLabel label2 = new JLabel("한국어 -> 영어");
        label2.setHorizontalAlignment(JLabel.CENTER);
        panel2.add(label2);

        //output패널
        text2 = new JTextField(17);
        text2.setText(aftertext);
        text2.setEditable(false);
        panel3.add(text2);

        //사이트버튼
        JButton button2 = new JButton("사이트");
        button2.addActionListener(new outputpage.Listener(this));
        panel3.add(button2);

        //창닫기버튼
        JButton button3 = new JButton("창닫기");
        button3.addActionListener(new outputpage.CloseButton(this));
        panel4.add(button3);

        //패널 정리
        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(panel4);
        this.add(panel1);


        //마무리설정
        this.setVisible(true);
        this.setResizable(false);



    }

    //"사이트" 버튼 클릭시 이벤트
    class Listener implements ActionListener {

        JFrame frame;

        public Listener(JFrame f) {
            frame = f;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                System.out.println("[+] 연결될 URL 주소 : " + URL1);
                URL1 = URL1.replace("+", "%20"); //공백시 사이에 + 가 들어가는 오류 수정
                Desktop.getDesktop().browse(new URI(URL1));
                System.out.println("[+] 사이트 연결 성공!!!");
                System.out.println("");
            }
            catch (IOException q) {
                q.printStackTrace();
            } catch (URISyntaxException q) {
                q.printStackTrace(); }
            //https://papago.naver.com/?sk=ko&tk=en&st=%EC%95%88%EB%85%95
            //dispose();
        }
    }

    //"창닫기" 버튼 클릭시 이벤트
    class CloseButton implements ActionListener {

        JFrame frame;

        public CloseButton (JFrame f) {
            frame = f;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("[+] 창닫기 클릭!");
            System.out.println("");
            dispose();
        }
    }
}
