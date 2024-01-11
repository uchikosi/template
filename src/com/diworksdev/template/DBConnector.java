package com.diworksdev.template.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//MySQL接続に必要な情報を設定します。

public class DBConnector {
	//JDBCドライバー（JDBCとデータベースとの通信を取り持つためのライブラリ）の名前を変数に代入している
	private static String driverName ="com.mysql.jdbc.Driver";
	private static String url ="jdbc:mysql://localhost:8889/ecsite?autoReconnect=true&useSSL=false";
	private static String user ="root";
	private static String password ="root";
	public Connection getConnection() {
		Connection con = null;
		//接続情報から自分のパソコンにインストールされているMySQLへ接続する準備が整います。
		try{
//			try～catchは Java の例外処理の為の構文、中にはエラーが発生しそうな処理を書きます。
			Class.forName(driverName);
//			指定されたJDBCドライバーをロードします。
			con = DriverManager.getConnection(url,user,password);
//			url で指定されたデータベースに、user と password を使用して接続します。
//			DriverManager.getConnection メソッドは、指定されたURL、ユーザー名、パスワードでデータベースに接続するための Connection オブジェクトを返す。
		} catch (ClassNotFoundException e) {
			e.printStackTrace() ;
//			例外が発生した場合の処理
		} catch (SQLException e) {
			e.printStackTrace() ;
//			tryの中でエラーが発生した場合に、catchが受け取り、printStackTraceでエラーに至る
//			履歴を表示してくれます。間違った際の赤い文字です。今回だと２つのエラーが表示されます。
//			ClassNotFoundException（クラスが見つからない場合の例外）と SQLException（データベ
//			ース処理に関する例外）です
		}
		return con ;
	}
}
