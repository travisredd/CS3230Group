/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Categories.Database;

import javafx.beans.property.StringProperty;

/**
 * clsCategoriesSQL class to hold the SQL statements
 * @author reddt
 */
public class clsCategoriesSQL {
    
    /**
     * SQL statement to get all categories from database
     */
    public static String sGetAllCategoriesSQL = "Select * From Category";
    
    /**
     * SQL statement to get all the products where category =
     */
    public static String sGetAllProdForCatIdSQL = "Select * From Product Where CATEGORY = '";
    
    /**
     * SQL statement to delete selected category
     */
    public static String sDeleteDescriptionSQL = "Delete From Category Where CATEGORY = '";
    
    /**
     * SQL statement to insert a category and description
     */
    public static String sInsertCategorySQL = "INSERT INTO CATEGORY (CATEGORY, DESCRIPTION) VALUES ('";
    
    /**
     * SQL statement to update description of a category
     */
    public static String sUpdateDescriptionSQL = "UPDATE CATEGORY SET DESCRIPTION = '";
    
}
