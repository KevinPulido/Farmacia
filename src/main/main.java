
package main;

//import views.LoginView;
import views.SystemView;
public class main {
    public static void main(String[] args){
        
        //LoginView login= new LoginView();
        SystemView sistema= new SystemView();
        sistema.setVisible(true);
        System.out.println("Se esta ejcutando correctamente");
    }
}
