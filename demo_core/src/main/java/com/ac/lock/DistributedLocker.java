package com.ac.lock;

/**
 * <p>Discription: 分布式锁管理类</p>
 * Created on 2018/11/15 14:22
 *
 * @version 1.0
 * Created by fangzhipeng on 2017/4/5.
 * 获取锁管理类
 * @author: <a href="mailto: xiyang@camelotchina.com">息阳</a>
 */
public interface DistributedLocker {

    /**
     * 获取锁
     *
     * @param resourceName 锁的名称
     * @param worker       获取锁后的处理类
     * @param <T>
     * @return 处理完具体的业务逻辑要返回的数据
     */
    <T> T lock(String resourceName, AquiredLockWorker<T> worker) ;

    <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime);

    /**
     * <p>Discription: 使用时可以用lambda表达式   【()-> {return 被调用的方法}】</p>
     * Created on 2018/11/15 14:55
     *
     * @param <T>
     * @version 1.0
     * @author: <a href="mailto: xiyang@camelotchina.com">息阳</a>
     */
    interface AquiredLockWorker<T> {
        /**
         * <p>Discription: 获取锁后执行的动作</p>
         * Created on 2018/11/15 17:50
         *
         * @return T
         * @author: <a href="mailto: xiyang@camelotchina.com">息阳</a>
         * @version 1.0
         */
        T invokeAfterLockAquire();
    }
}

