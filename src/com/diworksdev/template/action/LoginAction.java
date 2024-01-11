package com.diworksdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.template.dao.BuyItemDAO;
import com.diworksdev.template.dao.LoginDAO;
import com.diworksdev.template.dto.BuyItemDTO;
import com.diworksdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
    private String loginUserId;
    private String loginPassword;
    private String result;
    private Map<String, Object> session;

    public String execute() {
        LoginDAO loginDAO = new LoginDAO();
        BuyItemDAO buyItemDAO = new BuyItemDAO();
        LoginDTO loginDTO = new LoginDTO();
        BuyItemDTO buyItemDTO = new BuyItemDTO();

        result = ERROR;
        loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

        // ログイン成功の場合
        if (loginDTO.getLoginFlg()) {
            result = SUCCESS;
            buyItemDTO = buyItemDAO.getBuyItemInfo();

            // セッションに必要な情報を格納
            session.put("login_user_id", loginDTO.getLoginId());
            session.put("id", buyItemDTO.getId());
            session.put("buyItem_name", buyItemDTO.getItemName());
            session.put("buyItem_price", buyItemDTO.getItemPrice());
        }

        return result;
    }

    // ゲッターおよびセッターメソッドは省略

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}

