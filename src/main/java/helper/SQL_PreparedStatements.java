package helper;

import helper.JDBC;

import helper.FruitsQuery;



public class SQL_PreparedStatements {


    /** insert, updatae, delete
     int rowsAffected = FruitsQuery.insert("kiwi", 2);
     // FruitsQuery.insert
     // FruitsQuery.update
     // FruitsQuery.delete
     // the FruitsQuery.insert takes (fruitName, colorId)
     // when it gets called, it will return the insert and it will return the number of rows that was affected by the insert
     // we can confirm if our insert was successful
     // the FruitsQuery.update takes (fruitId, fruitName)
     // FruitsQuery.update will call the update method
     // the FruitsQuery.delete takes (fruitId)

     if(rowsAffected > 0){
     System.out.println("Insert Successful");
     // when performing INSERT: "Insert Successful"
     // when performing UPDATE: "Update Successful"
     // when performing DELETE: "DELETE Successful"
     }
     else{
     System.out.println("Insert FAILED");
     // when performing INSERT: "Insert FAILED"
     // when performing UPDATE: "Update FAILED"
     // when performing DELETE: "DELETE FAILED"
     }
     */

//        FruitsQuery.select(3);
    // if you want to call the 'select() overload' then call FruitsQuery.select(andEnterIntColorIdNumYouWantToSee);

    //FruitsQuery.select();
    // select

}
