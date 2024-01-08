/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import DataBase.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author zduyt
 */
public class admin {
    public Connect cn= new Connect();
    public ResultSet Showadmin() throws SQLException{
        cn.connectSQL();
        String sql="Select * from Admin";
        return cn.LoadData(sql);
    }
           
}
