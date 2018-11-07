package history_manager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

class Originator<T extends Cloneable> {

    private T state;

    public void set(T str) {
        this.state = str;
    }

    public T getState() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = Object.class.getDeclaredMethod("clone");
        method.setAccessible(true);
        return (T) method.invoke(this.state);
    }

    public Memento<T> save() {
        return new Memento<>(this.state);
    }

    public void rollback(Memento<T> state) {
        this.state = state.object;
    }

    public static class Memento<T> {
        private final T object;
        public Memento(T text) {
            this.object = text;
        }
    }

}
