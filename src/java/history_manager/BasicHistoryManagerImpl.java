/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package history_manager;

import java.util.ArrayList;
import java.util.List;
import listNavigator.ListNavigator;
import listNavigator.ListNavigatorImpl;

/**
 *
 * @author USERR
 * @param <T>
 */
public class BasicHistoryManagerImpl<T extends Cloneable> implements BasicHistoryManager<T> {

    private List<Originator.Memento> versions = new ArrayList<>();
    private Originator originator = new Originator();
    private ListNavigator navigator = new ListNavigatorImpl(versions);

    @Override
    public boolean canGoBackward() {
        return navigator.isFirst();
    }

    @Override
    public boolean canGoForward() {
        return navigator.isLast();
    }

    @Override
    public void goBack() {
        navigator.goBack();
        originator.rollback(versions.get(navigator.getPosition()));
    }

    @Override
    public void goForward() {
        navigator.goForward();
    }

    @Override
    public void set(T object) {
        originator.set(object);
    }

    @Override
    public void save() {
        versions.add(originator.save());
    }

}
