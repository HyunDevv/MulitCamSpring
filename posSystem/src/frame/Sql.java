package frame;

public class Sql {
	// User SQL
	public static String userInsert = 
	"INSERT INTO GAME_USER VALUES (?,?,?)";
	public static String userUpdate = 
	"UPDATE GAME_USER SET PWD=?, NAME=? WHERE ID=?";
	public static String userDelete = 
	"DELETE FROM GAME_USER WHERE ID=?";
	public static String userSelect = 
	"SELECT * FROM GAME_USER WHERE ID=?";
	public static String userSelectAll = 
	"SELECT * FROM GAME_USER ORDER BY ID ASC";
	
	// Item SQL
	public static String itemInsert = 
	"INSERT INTO GAME_ITEM VALUES (ITEM_SEQ.NEXTVAL,?,?,SYSDATE)";
	public static String itemUpdate = 
	"UPDATE GAME_ITEM SET NAME=?, PRICE=? WHERE ID=?";
	public static String itemDelete = 
	"DELETE FROM GAME_ITEM WHERE ID=?";
	public static String itemSelect = 
	"SELECT * FROM GAME_ITEM WHERE ID=?";
	public static String itemSelectAll = 
	"SELECT * FROM GAME_ITEM ORDER BY ID ASC";
	
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
	"UPDATE BURGERSTOCK SET STOCK=? WHERE ID=?";
	public static String bsDelete = 
	"DELETE FROM BURGERSTOCK WHERE ID=?";
	public static String bsSelect = 
	"SELECT * FROM BURGERSTOCK WHERE ID=?";
	public static String bsSelectAll = 
	"SELECT * FROM BURGERSTOCK ORDER BY ID ASC";
	
	public static String userItemSelect = 
	"SELECT u.ID, u.USER_ID, u.ITEM_ID, g.NAME AS ITEM_NAME, u.QT FROM USER_ITEM u, GAME_ITEM g WHERE u.item_id = g.id  AND USER_ID = ?";
}








