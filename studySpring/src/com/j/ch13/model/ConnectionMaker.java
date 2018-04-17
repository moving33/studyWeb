package com.j.ch13.model;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    public Connection makeConnection()throws ClassNotFoundException,SQLException;
}
