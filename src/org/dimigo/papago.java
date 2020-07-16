package org.dimigo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

class papago{

    //papago api 사용
    public papago() {
        MyFrame f = new MyFrame();
        String clientId = "HIsflq4AQG_Rw8WrTNV6";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "lJipJR_np4";//애플리케이션 클라이언트 시크릿값";
        String beforetext = MyFrame.beforetext; //입력한 단어 받아오기
        System.out.println("[+] 입력된 메세지 : " + beforetext);
        try {
            String text = URLEncoder.encode(beforetext, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            //요청
            String postParams = "source=ko&target=en&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();


            //papago에서 받아옹 응답
            System.out.println("[+] 받아온 요청 : " + response.toString()); //log_papago_response

            //JSON 파싱하기
            String tmp[] = response.toString().split("\"");
            MyFrame.aftertext = tmp[27];
            System.out.println("[+] 출력될 메세지 : " + tmp[27]); //log_extraction


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
