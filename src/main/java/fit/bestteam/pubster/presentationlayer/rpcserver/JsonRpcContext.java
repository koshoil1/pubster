/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.rpcserver;

/**
 * Holly ...stuff... Workaround JsonRpcServer,
 * needed to pass auth data prob HttpServled to JSON-PRC methods handlers
 * @author illia
 */
public class JsonRpcContext {

    private static ThreadLocal<Object[]> threadLocal = new ThreadLocal<>();

    /**
     * Adds Objects to shared
     * @param context- some data to pass
     */
    public static void set(Object... context) {
        threadLocal.set(context);
    }

    /**
     * Clears all stored values
     */
    public static void unset() {
        threadLocal.remove();
    }

    /**
     * Used to access stored values 
     * @param <T> 
     * @param index - index in storage
     * @param clazz - Object class
     * @return requested Object
     */
    public static <T> T get(int index, Class<T> clazz) {
        Object[] contexts = threadLocal.get();
        if (contexts != null && contexts.length > index && clazz.isInstance(contexts[index])) {
            return clazz.cast(contexts[index]);
        }
        return null;
    }
}
