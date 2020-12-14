package frame;

public class Sql {
	//User SQL
	public static String userInsert = 
			"INSERT INTO USERS VALUES (?,?,?)";
	public static String userUpdate = 
			"UPDATE USERS SET PWD=?, NAME=?, WHERE ID=?";
	public static String userDelete = 
			"DELETE FROM USERS WHERE ID=?";
	public static String userSelect = 
			"SELECT * FROM USERS WHERE ID=?";
	public static String userSelectAll = 
			"SELECT * FROM USERS ORDER BY ID ASC";

	//Item SQL
	public static String itemInsert = 
			"INSERT INTO GAME_ITEM VALUES (?,?)";
	public static String itemUpdate = "";
	public static String itemDelete = "";
	public static String itemSelect = "";
	public static String itemSelectAll = 
			"SELECT * FROM GAME_ITEM ORDER BY ID ASC";

	//
	public static String userItemSelect = 
			"SELECT U.ID, U.USER_ID, U.ITEM_ID, G.NAME AS ITEM_NAME, U.QT FROM USER_ITEM U, GAME_ITEM G WHERE U.USER_ID = ? AND U.ITEM_ID = G.ID";

	// FOOD SQL
	public static String productInsert = 
			"INSERT INTO FOOD VALUES (?,?,?,?)";
	public static String productUpdate = 
			"UPDATE FOOD SET NAME=?, PRICE=?, IMG=? WHERE ID=?";
	public static String productDelete = 
			"DELETE FROM FOOD WHERE ID=?";
	public static String productSelect = 
			"SELECT * FROM FOOD WHERE ID=?";
	public static String productSelectAll = 
			"SELECT * FROM FOOD ORDER BY ID ASC";

	// BURGERSTOCK SQL  (bs´Â BURGERSTOCKÀÓ)
	public static String bsInsert = 
			"INSERT INTO BURGERSTOCK VALUES (?,?)";
	public static String bsUpdate = 
			"UPDATE BURGERSTOCK SET STOCK=? WHERE NAME=?";
	public static String bsDelete = 
			"DELETE FROM BURGERSTOCK WHERE NAME=?";
	public static String bsSelect = 
			"SELECT * FROM BURGERSTOCK WHERE NAME=?";
	public static String bsSelectAll = 
			"SELECT * FROM BURGERSTOCK ORDER BY NAME ASC";

}
