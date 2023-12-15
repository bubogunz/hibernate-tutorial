package javabin.client;

import javabin.entity.Message;
import org.hibernate.Session;

import util.HibernateUtil;

public class HelloWorldClient {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Message message = new Message( "Yet another message" );

        session.persist(message);

        session.getTransaction().commit();
        session.close();

    }
}

