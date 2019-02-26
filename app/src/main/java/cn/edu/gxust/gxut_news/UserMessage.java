package cn.edu.gxust.gxut_news;

import org.litepal.crud.DataSupport;
import org.litepal.exceptions.DataSupportException;

public class UserMessage extends DataSupport {
    private String account;
    private int password;


    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getAccount() {

        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}



