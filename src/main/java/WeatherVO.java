
public class WeatherVO {
    //강수확률
    private String pop;
    //습도
    private String reh;
    //하늘상태
    private String sky;
    //기온
    private String t3h;
    //강수형태
    private String pty;
    //강수량
    private String r06;

    public String getR06() {
        return r06;
    }

    public void setR06(String r06) {
        this.r06 = r06;
    }

    public WeatherVO(String pop, String reh, String sky, String t3h, String pty) {
        this.pop = pop;
        this.reh = reh;
        this.sky = sky;
        this.t3h = t3h;
        this.pty = pty;
    }

    public String getPty() {
        return pty;
    }

    public void setPty(String pty) {
        this.pty = pty;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getReh() {
        return reh;
    }

    public void setReh(String reh) {
        this.reh = reh;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }

    public String getT3h() {
        return t3h;
    }

    public void setT3h(String t3h) {
        this.t3h = t3h;
    }

    @Override
    public String toString() {
        String msg = "기상 정보 \n";
        msg += "강수확률 : "+pop +"%";
        msg += "\t하늘상태 : "+sky;
        msg += "\t습도 : "+reh +"%";
        msg += "\t온도 : "+t3h +"도";
        msg += "\t강수형태 : "+pty;
        return msg;
    }
}
