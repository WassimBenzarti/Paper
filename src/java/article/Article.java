/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package article;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USERR
 */
public class Article implements Cloneable{
    
    private String text;

    public Article(String text) {
        this.text = text;
    }
   
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Article clone(){
        try {
            return (Article)super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
            return this;
        }
    }

}
