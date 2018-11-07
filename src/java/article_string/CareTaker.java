package article_string;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USERR
 */
class CareTaker {
    private List<Originator.Memento> versions = new ArrayList<>();
    private Originator originator = new Originator();
    
    public void write(String str){
        originator.set(str);
    }
    
    public String read(){
        return originator.getText();
    }
    
    public void saveChanges(){
        versions.add(originator.save());
    }
    
    public void undoChanges(int i){
        originator.rollback(versions.get(i));
    }
    public void undoChanges(){
        if(versions.isEmpty()){
            return;
        }
        this.undoChanges(Math.max(0, versions.size()-2));
    }
    
    public static void main(String args[]){
        CareTaker careTaker = new CareTaker();
        
        // Changing the article
        careTaker.write("Hello");
        System.out.println(careTaker.read());
        
        // Saving changes
        careTaker.saveChanges();
        
        // Changing the article
        careTaker.write("Hello again");
        careTaker.saveChanges();
        System.out.println(careTaker.read());
        careTaker.undoChanges(0);
        System.out.println(careTaker.read());
    }
}
