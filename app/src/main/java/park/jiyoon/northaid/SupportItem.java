package park.jiyoon.northaid;

public class SupportItem {
    String num;
    String name;
    String url;

    public SupportItem(String num, String name, String url) {
        this.num = num;
        this.name = name;
        this.url = url;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
