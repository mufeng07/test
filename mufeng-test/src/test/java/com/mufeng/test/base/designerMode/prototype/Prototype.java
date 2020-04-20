package com.mufeng.test.base.designerMode.prototype;

import java.io.*;

public class Prototype implements Cloneable, Serializable {
    public int a;
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 浅复制
     */
    public Object clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }
    /**
     * 深复制
     */
    public Object deepClone() throws IOException, ClassNotFoundException {
        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
    public Prototype(){
        System.out.println("pro");
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "a=" + a +
                ", user=" + user +
                '}';
    }
}
