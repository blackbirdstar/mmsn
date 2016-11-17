package burak.com.mmsn;


import java.util.List;

public class Response {


    /**
     * entries : [{"id":"2","city":"38","title":"Kayseri optimum","body":"adsfadsfads oasdf jaosd fjoasj foasjd foajsdf oasd ","link":"resources/optimum.jpg"},{"id":"3","city":"38","title":"Kayseri almer ","body":"asdfkjaeoıqwer aksdfj aşsdlkjf aşskjdf şasdkjf aşsdkf jşasdf ","link":"resources/almer.jpg"}]
     * city : 38
     * message :
     */

    private int city;
    private String message;


    private List<EntriesBean> entries;

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<EntriesBean> getEntries() {
        return entries;
    }

    public void setEntries(List<EntriesBean> entries) {
        this.entries = entries;
    }

    public static class EntriesBean {
        private String id;
        private String city;
        private String title;
        private String body;
        private String link;

        public String getİd() {
            return id;
        }

        public void setİd(String id) {
            this.id = id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
