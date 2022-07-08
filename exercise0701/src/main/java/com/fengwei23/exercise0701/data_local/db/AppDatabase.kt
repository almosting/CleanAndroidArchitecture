package com.fengwei23.exercise0701.data_local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fengwei23.exercise0701.data_local.db.post.PostDao
import com.fengwei23.exercise0701.data_local.db.post.PostEntity
import com.fengwei23.exercise0701.data_local.db.user.UserDao
import com.fengwei23.exercise0701.data_local.db.user.UserEntity

@Database(entities = [UserEntity::class, PostEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun postDao(): PostDao
}