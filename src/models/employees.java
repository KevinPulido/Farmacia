
package models;

public class employees {
    private int id;
    private String full_name;
    private String username;
    private String address;
    private String telephone;
    private String password;
    private String rol;
    private String created;
    private String updated;
    
    public employees(){
    }

    public employees(int id, String full_name, String username, String address, String telephone, String password, String rol, String created, String updated) {
        this.id = id;
        this.full_name = full_name;
        this.username = username;
        this.address = address;
        this.telephone = telephone;
        this.password = password;
        this.rol = rol;
        this.created = created;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
    
    
    
    
}
