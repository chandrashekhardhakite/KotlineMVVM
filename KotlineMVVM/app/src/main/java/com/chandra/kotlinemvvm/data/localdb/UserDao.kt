package com.chandra.kotlinemvvm.data.localdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chandra.kotlinemvvm.data.localdb.entities.CURRENT_USER_ID
import com.chandra.kotlinemvvm.data.localdb.entities.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user:User):Long

//    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
//    fun getuser() : LiveData<User>

}