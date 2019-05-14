package org.sang.bean;

/**
 * @author magentaLi
 * 操作日志
 */
public class BusinessLog {
    //操作用户名
    private String name;
    //调用的方法
    private String method;
    //进行的操作
    private String operation;
    //用户ip地址
    private String ip;

    public BusinessLog(String name, String method, String operation, String ip) {
        this.name = name;
        this.method = method;
        this.operation = operation;
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public BusinessLog() {
    }

    @Override
    public String toString() {
        return "BusinessLog{" +
                "name='" + name + '\'' +
                ", method='" + method + '\'' +
                ", operation='" + operation + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
