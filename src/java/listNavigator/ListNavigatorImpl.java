/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listNavigator;

import java.util.List;

/**
 *
 * @author USERR
 */
public class ListNavigatorImpl implements ListNavigator {

    private List list;
    private int cursor;

    public ListNavigatorImpl(List list) {
        this.list = list;
        this.cursor = 0;
    }

    public ListNavigatorImpl(List list, int cursor) {
        this.list = list;
        this.cursor = cursor;
    }

    public ListNavigatorImpl(List list, boolean startFromTheEnd) {
        this.list = list;
        if (startFromTheEnd) {
            this.cursor = list.size() - 1;
        } else {
            this.cursor = 0;
        }
    }

    @Override
    public int getPosition() {
        return cursor;
    }

    @Override
    public void setPosition(int cursor) {
        this.cursor = cursor;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public boolean isLast() {
        return this.cursor == this.list.size()-1;
    }

    @Override
    public boolean isFirst() {
        return this.cursor == 0;
    }

    @Override
    public void goFroward() {
        if(this.cursor +1 >this.list.size()-1 ){
            
        }
        return this.cursor+1;
    }

    @Override
    public void goBackward() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
