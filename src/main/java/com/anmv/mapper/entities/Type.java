package com.anmv.mapper.entities;


public enum Type {
    DEV("Dev"), TESTER("Test"), SCRUM_MASTER("ScrumMaster"), PROJECT_MANAGER("PM");

    private String status;

    private Type(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static Type sqlToEnum(String sqlStatus){
        for (Type type : Type.values()){
            if(type.getStatus().equals(sqlStatus)){
                return type;
            }
        }
        return null;
    }
}
