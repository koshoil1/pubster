/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.rpcserver;

/**
 *
 * @author illia
 */
public class JsonRpcContext {

    private static ThreadLocal<Object[]> threadLocal = new ThreadLocal<>();

    public static void set(Object... context) {
        threadLocal.set(context);
    }

    public static void unset() {
        threadLocal.remove();
    }

    public static <T> T get(int index, Class<T> clazz) {
        Object[] contexts = threadLocal.get();
        if (contexts != null && contexts.length > index && clazz.isInstance(contexts[index])) {
            return clazz.cast(contexts[index]);
        }
        return null;
    }
}
