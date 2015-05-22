package project;

import java.io.*;

public class ClientStub {
    
    public SeriObj operationSeri(float num1, float num2, char op, int id) {
        SeriObj e = new SeriObj();
        e.para1 = num1;
        e.para2 = num2;
        e.operand = op;
        e.id = id;
        try {
            FileOutputStream fileOut = new FileOutputStream("Ser.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return e;
    }

    public float operationDeseri() {
        SeriObj e = new SeriObj();
        try {
            FileInputStream fileIn = new FileInputStream("Ser.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (SeriObj) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return e.result;
    }
    
    public float add(float num1, float num2) {
        ClientStub cs=new ClientStub();
        ServerSkeleton ss=new ServerSkeleton();
        cs.operationSeri(num1, num2, '+', 1);
        ss.search();
        return cs.operationDeseri();
    }

    public float sub(float num1, float num2) {
        ClientStub cs=new ClientStub();
        ServerSkeleton ss=new ServerSkeleton();
        cs.operationSeri(num1, num2, '-', 1);
        ss.search();
        return cs.operationDeseri();
    }

    public float mul(float num1, float num2) {
        ClientStub cs=new ClientStub();
        ServerSkeleton ss=new ServerSkeleton();
        cs.operationSeri(num1, num2, '*', 1);
        ss.search();
        return cs.operationDeseri();
    }

    public float div(float num1, float num2) {
        ClientStub cs=new ClientStub();
        ServerSkeleton ss=new ServerSkeleton();
        cs.operationSeri(num1, num2, '/', 1);
        ss.search();
        return cs.operationDeseri();
    }
}
