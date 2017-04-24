package com.qixiaoyi.fascialibrary.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Email 240336124@qq.com
 * Created by Darren on 2017/3/5.
 * Version 1.0
 * Description:
 */
public interface IDaoSoupport<T> {

    void init(SQLiteDatabase sqLiteDatabase, Class<T> clazz);
    // 插入数据
    public long insert(T t);

    // 批量插入  检测性能
    public void insert(List<T> datas);

    // 查询所有
    public List<T> query();

    // 按照语句查询

}
