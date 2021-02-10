import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import org.json.JSONObject;

public class WeatherMain {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
        WeatherVO vo = null;
        String result = "";
        String xpos="60";
        String ypos="127";
      
        String date = getDate();
        String time = "0900";
        String clientId = "hpOVfNem4MVro1QdBZTMTq%2FMZs%2B8yylSvxNQlqPiEQec%2Bo99WRRbIvrVqLltto5W0TmluoxR7uQHpHFNZ146qg%3D%3D";// 애플리케이션
        BufferedReader br = null;
        try {
        	System.out.println("date : "+date);
        	System.out.println("time : "+time);
            String apiURL = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey="+clientId+"&base_date="+date+"&base_time="+time+"&nx="+xpos+"&ny="+ypos+"&numOfRows=10&pageSize=10&pageNo=1&startPage=1&dataType=json";
            URL url = new URL(apiURL);
            System.out.println("url: "+apiURL);
     

            //내용 읽어오는 부분
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            String line;
            while((line = br.readLine())!= null){
                result += line + "\n";
            }

            System.out.println("result : "+result);
            
            JSONObject json = new JSONObject(result); 
            
//            JsonElement rootObj = parser.parse(result.toString()).getAsJsonObject().get("response").getAsJsonObject().get("body").getAsJsonObject().get("items").getAsJsonObject().get("item");
//            JsonArray arr = rootObj.getAsJsonArray();
//            String pop="";
//            String reh="";
//            String sky="";
//            String t3h="";
//            String pty="";
//            String r06="";
//            for(int i=0;i<arr.size();i++) {
//                String str = arr.get(i).getAsJsonObject().get("category").toString().replace("\"","");
//                Log.i("result", "category: "+str);
//
//                switch(str){
//                    case "POP":
//                        pop = arr.get(i).getAsJsonObject().get("fcstValue").toString();
//                        Log.i("result", "pop: "+pop);
//                        break;
//                    case "REH":
//                        reh = arr.get(i).getAsJsonObject().get("fcstValue").toString();
//                        Log.i("result", "reh: "+reh);
//                        break;
//                    case "SKY":
//                        sky = arr.get(i).getAsJsonObject().get("fcstValue").toString();
//                        Log.i("result", "sky: "+sky);
//                        break;
//                    case "T3H":
//                        t3h = arr.get(i).getAsJsonObject().get("fcstValue").toString();
//                        Log.i("result", "t3h: "+t3h);
//                        break;
//                    case "PTY":
//                        pty = arr.get(i).getAsJsonObject().get("fcstValue").toString();
//                        Log.i("result", "pty: "+pty);
//                        break;
//                    case "R06":
//                        r06 = arr.get(i).getAsJsonObject().get("fcstValue").toString();
//                        Log.i("result", "r06: "+r06);
//                        break;
//                }
//            }
//            vo = new WeatherVO(pop,reh,sky,t3h,pty);
//            if(!pty.equals("0"))
//                vo.setR06(r06);
//            Log.i("result", "doInBackground: "+vo.toString());
        }catch (Exception e){
        	e.printStackTrace();
        }
	}
     private static String getDate(){
         Calendar cal = Calendar.getInstance();
         String str = "";
         str += cal.get(Calendar.YEAR);
         if(cal.get(Calendar.MONTH)+1 < 10)
             str += "0";
         str += cal.get(Calendar.MONTH)+1;
         str += cal.get(Calendar.DAY_OF_MONTH);
         return str;
     }

}
