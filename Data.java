package com.company;


class Data {
    public Data next;
    private final long info;
    private final long type;
    public Data(long info, long type){
        this.info = info;
        this.type = type;
    }
    public long getInfo() {
        return info;
    }
    public long getType() {
        return type;
    }
}