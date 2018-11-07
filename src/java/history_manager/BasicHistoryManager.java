/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package history_manager;

/**
 * This is the interface of a basic history manager.
 * It only moves one step forward or backward.
 * @author USERR
 * @param <T>
 */
public interface BasicHistoryManager<T extends Cloneable> {

    boolean canGoBackward();
    boolean canGoForward();
    
    void goBack()throws Exception ;
    void goForward()throws Exception ;
    
    void save();
    void set(T object);
}
