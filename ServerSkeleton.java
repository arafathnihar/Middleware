package project;

import java.io.*;

public class ServerSkeleton {

    SeriObj e = new SeriObj();
        
    public void operationSeri(float result, int id) {
        e.result = result;
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
    }

    public SeriObj operationDeseri() {        
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
        return e;
    }

    public void search() {
        ServerSkeleton ss = new ServerSkeleton();
        RegistrySearch rs = new RegistrySearch();
        try {
            SeriObj e = new SeriObj();
            e = ss.operationDeseri();
            char op = e.operand;
            switch (op) {
                case '+':
                    AddServer as = new AddServer();
                    e.result = as.add(e.para1, e.para2);
                    //e.id = rs.getServerId("AddServer");
                    ss.operationSeri(e.result, e.id);
                    break;
                case '-':
                    SubServer subs = new SubServer();
                    e.result = subs.sub(e.para1, e.para2);
                    //e.id = rs.getServerId("SubServer");
                    ss.operationSeri(e.result, e.id);
                    break;
                case '*':
                    MulServer ms = new MulServer();
                    e.result = ms.mul(e.para1, e.para2);
                    //e.id = rs.getServerId("MulServer");
                    ss.operationSeri(e.result, e.id);
                    break;
                case '/':
                    DivServer ds = new DivServer();
                    e.result = ds.div(e.para1, e.para2);
                    //e.id = rs.getServerId("DivServer");
                    ss.operationSeri(e.result, e.id);
                    break;
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}
