package javabin.client;

import javabin.entity.Message;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.logging.Logger;

public class HelloWorldClient {
    public static void main(String[] args) {
        /*First lesson*/
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Message message = new Message("Prova tutorial 2");
        session.persist(message);

        session.getTransaction().commit();
        /*session.close();*/

        /*Second lesson*/
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Message msg = session.get(Message.class, 2L);
            msg.setText("Hello Automatic Dirty Checking");
//            session.delete(msg);
            txn.commit();
        } catch (HibernateException e) {
            if(!java.util.Objects.isNull(txn)) {
                txn.rollback();
            }
            e.printStackTrace();
        }

        /*Third lesson*/
        session.close();
        message.setText("Trying to modify a detached object");
        /*Open another session*/
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        /*Hooks the previously detached object to the persistent object and merges diffs*/
        session.merge(message);
        session.getTransaction().commit();
        session.close();
    }
}

