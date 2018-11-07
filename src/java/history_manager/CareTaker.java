package history_manager;

import article.Article;
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
public class CareTaker {
    private List<Originator.Memento> versions = new ArrayList<>();
    private Originator originator = new Originator();
    
    public void write(String str){
        originator.set(new Article(str));
    }
    
    public String read(){
        return originator.getState().getText();
    }
    
    public void saveChanges(){
        versions.add(originator.save());
    }
    
    public void undoChanges(int i){
        originator.rollback(versions.get(i));
    }
    
    public static void main(String args[]){
        CareTaker careTaker = new CareTaker();
        careTaker.write("Hello");
        System.out.println(careTaker.read());
        careTaker.saveChanges();
        careTaker.write("Hello again");
        careTaker.saveChanges();
        System.out.println(careTaker.read());
        careTaker.undoChanges(0);
        System.out.println(careTaker.read());
    }
}
