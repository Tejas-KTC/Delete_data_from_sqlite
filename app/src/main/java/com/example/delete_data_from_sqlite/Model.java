package com.example.delete_data_from_sqlite;

public class Model {
    private int id;
    private String m_name,m_C_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_C_name() {
        return m_C_name;
    }

    public void setM_C_name(String m_C_name) {
        this.m_C_name = m_C_name;
    }

    public Model(int id, String m_name, String m_C_name) {
        this.id = id;
        this.m_name = m_name;
        this.m_C_name = m_C_name;
    }
}
