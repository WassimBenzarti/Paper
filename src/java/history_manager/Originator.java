package history_manager;

import article.Article;
import java.util.logging.Level;
import java.util.logging.Logger;

class Originator {

    private Article state;

    public void set(Article str) {
        this.state = str;
    }
    
    public Article getState(){
        return (Article) this.state.clone();
    }
    
    public Memento save(){
        return new Memento(this.state);
    }
    
    public void rollback(Memento state){
        this.state=state.article;
    }

    public static class Memento{

        private final Article article;

        public Memento(Article text) {
            this.article = text;
        }
        
    }

}
