package util;

public class Const {

    public static final String CREATE_BUY = "INSERT INTO Magaz_Proekt.backet (id_user)VALUES(?)";
    public static final String CREATE_BUY1 = "SELECT id_order FROM Magaz_Proekt.backet WHERE id_user=(?)";
    public static final String CREATE_ORDER="INSERT INTO Magaz_Proekt.order (id_order, id_product)VALUES(?,?)";
    public static final String READ_ORDERS_BY_ID_USER = "SELECT us.name AS покупатель,bac.id_order AS номер_заказа,pr.*" +
            "FROM Magaz_Proekt.user us,Magaz_Proekt.backet bac ,Magaz_Proekt.order ord,Magaz_Proekt.product pr" +
            "WHERE us.id=(?) AND bac.id_user=us.id AND bac.id_order=ord.id_order and ord.id_product=pr.rootid";
    public static final String READ_ORDERS_BY_ID_ORDER="SELECT us.name AS покупатель,bac.id_order AS номер_заказа,pr.*" +
            "FROM Magaz_Proekt.user us,Magaz_Proekt.backet bac ,Magaz_Proekt.order ord,Magaz_Proekt.product pr" +
            "WHERE bac.id_order=(?) AND us.id=bac.id_user AND bac.id_order=ord.id_order and ord.id_product=pr.rootid";
    public static final String DELETE_ORDERS = "DELETE FROM Magaz_Proekt.Order WHERE id_order=(?)";
    public static final String DELETE_ORDERS1="DELETE FROM Magaz_Proekt.backet WHERE id_order=(?)";
    public static final String CREATE_PRODUCT = "INSERT INTO Magaz_Proekt.product (ROOTID,NAME,DIMID,PRICE,GROUPID,WEIGHT,postname,Remark)VALUES(?,?,?,?,?,?,?,?)";
    public static final String READ_PRODUCT = "SELECT * FROM Magaz_Proekt.product ";
    public static final String DELETE_PRODUCT = "DELETE FROM Magaz_Proekt.product WHERE rootid = ?";
    public static final String DELETE_USER = "DELETE FROM Magaz_Proekt.user WHERE id = ?";
    public static final String CREATE_USER = "INSERT INTO Magaz_Proekt.user(name, email, Status) VALUES (?,?,?);";
    public static final String READ_USER = "SELECT us.id,us.name,us.email,st.status" +
            " FROM Magaz_Proekt.user us" +
            " JOIN Magaz_Proekt.status st" +
            " ON us.status = st.id";

    public static final String USER_Search ="SELECT id,name,email,status FROM Magaz_Proekt.user WHERE name=(?) AND email=(?) AND status =(?)";
    public static final String SEARCH_PRODUCT="SELECT * FROM Magaz_Proekt.product WHERE rootid=(?)";

    public static final String SEARCH_ID_ORDERS_IN_USERID="SELECT id_order FROM Magaz_Proekt.backet WHERE id_user=(?)";
    public static final String DEL_IN_ORDER_IDORDER="DELETE FROM Magaz_Proekt.Order WHERE id_order=(?)";
    public static final String DEL_IN_BACKET_IDUSER="DELETE FROM Magaz_Proekt.backet WHERE id_user=(?)";





}
