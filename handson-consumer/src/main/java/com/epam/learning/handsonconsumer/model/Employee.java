package com.epam.learning.handsonconsumer.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


/**
 * Created by savithasendhil on 3/8/19.
 */
public class Employee {
    @Id
    public ObjectId _id;

    public String name;
    public String title;
    public String department;
    public String lastModified;

    public String getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(String createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public String createTimeStamp;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }


    public Employee(ObjectId _id, String name, String title, String department, String lastModified, String createTimeStamp) {
        this._id = _id;
        this.name = name;
        this.title = title;
        this.department = department;
        this.lastModified = lastModified;
        this.createTimeStamp = createTimeStamp;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
