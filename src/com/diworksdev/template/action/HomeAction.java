package com.diworksdev.template.action;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {

    // executeメソッドはStruts 2アクションで実行されるメインの処理を記述するメソッドです。
    public String execute() {
        // SUCCESSはStruts 2で事前に定義された結果の一つで、処理が成功したことを示します。
        return SUCCESS;
    }
}
