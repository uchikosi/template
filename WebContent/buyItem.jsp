<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="imageToolbar" content="no" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <title>buyItem画面</title>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            line-height: 1.6;
            letter-spacing: 1px;
            font-family: Verdana, Helvetica, sans-serif;
            font-size: 12px;
            color: #333;
            background: #fff;
        }

        table {
            text-align: center;
            margin: 0 auto;
            border: 1px solid #333;
        }

        #top {
            width: 780px;
            margin: 30px auto;
        }

        #header {
            width: 100%;
            height: 80px;
            background-color: black;
        }

        #main {
            width: 100%;
            height: 500px;
            text-align: center;
        }

        #footer {
            width: 100%;
            height: 80px;
            background-color: black;
            clear: both;
        }
    </style>
</head>
<body>
    <div id="header">
        <div id="pr"></div>
    </div>
    <div id="main">
        <div id="top">
            <p>Buy Item</p>
        </div>
        <div>
            <s:form action="BuyItemAction">
                <table>
                    <tr>
                        <td><span>商品名</span></td>
                    </tr>
                    <tr>
                        <td><s:property value="session.buyItem_name" /></td>
                    </tr>
                    <tr>
                        <td><span>価格</span></td>
                        <td><s:property value="session.buyItem_price" />円</td>
                    </tr>
                    <tr>
                        <td><span>在庫</span></td>
                        <td>
                            <select name="stock">
                                <s:iterator begin="1" end="5">
                                    <option value="<s:property value='top' />"><s:property value='top' /></option>
                                </s:iterator>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span>支払い方法</span></td>
                        <td>
                            <input type="radio" name="pay" value="1" checked="checked">現金払い
                            <input type="radio" name="pay" value="2">クレジットカード
                        </td>
                    </tr>
                    <tr>
                        <td><s:submit value="購入" /></td>
                    </tr>
                </table>
            </s:form>
            <div>
                <span>前画面に戻る場合は</span>
                <a href='<s:url action="HomeAction" />'>こちら</a>
            </div>
        </div>
    </div>
    <div id="footer">
        <div id="pr"></div>
    </div>
</body>
</html>
