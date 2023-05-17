/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugs;

import java.sql.Date;

/**
 *
 * @author Jimma University
 */
public class Datetosql {

    public Date convert(java.util.Date utilDate) {
        java.sql.Date tdate = new java.sql.Date(utilDate.getTime());
        return tdate;
    }
}
