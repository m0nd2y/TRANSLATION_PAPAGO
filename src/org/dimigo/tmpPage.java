package org.dimigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class tmpPage extends JFrame {
    //배경색 설정
    Color b=new Color(255,204,255);

    //임시페이지
    tmpPage() {
        this.setSize(300, 70); //크키 설정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 옵션
        this.setTitle("번역기"); //프로그램 표기이름

        //레이어 설정
        JPanel panel1 = new JPanel();

        //화면 중앙에 표시되게하기
        Dimension frameSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

        //베경화면 설정
        panel1.setBackground(b);

        JButton button1 = new JButton("결과보기");
        button1.addActionListener(new tmpPage.Listener(this));
        panel1.add(button1);

        this.add(panel1);

        //마무리설정
        this.setVisible(true);
        this.setResizable(false);


        //URL에 넣기 위한 URL 인코딩
        try{
            MyFrame.encodeResult = URLEncoder.encode(MyFrame.beforetext, "UTF-8");
        }
        catch (UnsupportedEncodingException e){
            System.out.println("[-] 인코딩 오류!"); //log_urlencoding_error
        }

        //사이트를 들어가기 위한 URL 세팅
        outputpage.URL1 = MyFrame.siteURL + MyFrame.encodeResult;
    }

    //"결과보기" 클릭시!
    class Listener implements ActionListener {

        JFrame frame;

        public Listener(JFrame f) {
            frame = f;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            new outputpage(); //papago실행
            dispose(); //창닫기
        }
    }
}
