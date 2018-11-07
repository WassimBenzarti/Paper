package article_string;

class Originator {

    private String state = "";

    public void set(String str) {
        this.state = str;
    }
    
    public String getText(){
        return this.state;
    }
    
    public Memento save(){
        return new Memento(this.state);
    }
    
    public void rollback(Memento state){
        this.state=state.text;
    }

    public static class Memento {

        private final String text;

        public Memento(String text) {
            this.text = text;
        }
        
        private String getText() {
            return text;
        }
        
    }

}
