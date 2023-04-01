package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Mikle",  "Scott", (byte) 40);
        userDaoHibernate.saveUser("Olga", "Nesterova", (byte)30);
        userDaoHibernate.saveUser("Dima", "Shtanov", (byte)35);
        userDaoHibernate.saveUser("Anna", "Andreeva", (byte)20);
        System.out.println(userDaoHibernate.getAllUsers());
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();
    }
}
