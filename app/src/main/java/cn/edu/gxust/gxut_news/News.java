package cn.edu.gxust.gxut_news;

import java.io.Serializable;

class News implements Serializable {
    String title,content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
