package org.sang.bean;

/**
 * @author magentaLi
 */
public class BusinessLog {
    private String name;
    private String method;
    private String operation;
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
