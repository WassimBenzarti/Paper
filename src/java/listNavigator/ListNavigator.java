/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listNavigator;

/**
 *
 * @author USERR
 */
public interface ListNavigator {

    int getPosition();

    void setPosition(int position);

    boolean isLast();

    boolean isFirst();

    void goForward() throws Exception;

    void goBackward() throws Exception;

}
