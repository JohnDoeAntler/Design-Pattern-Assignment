package app.singleton;

import java.util.Stack;

import app.memento.Memento;

/**
 * RedoListSingleton
 */
public class RedoListSingleton {

	// singleton field
    private volatile static Stack<Memento> singleton;
	
	// block instantiation
    private RedoListSingleton (){}
	
    public static Stack<Memento> getInstance() {
		// double-checked locking singleton pattern
        if (singleton == null) {
            synchronized (Stack.class) {
                if (singleton == null) {
                    singleton = new Stack<Memento>();
                }
            }
        }
        return singleton;
    }
}