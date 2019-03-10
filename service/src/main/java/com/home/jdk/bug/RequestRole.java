package com.home.jdk.bug;

/**
 * Created by li.ma on 2019/2/21.
 */
public enum RequestRole {
    /**未登录，不明身份的用户
     */
    UNKNOWN,

    /**已登录的用户
     */
    LOGIN,

    /**联系人，必须已登录
     */
    CONTACT,

    /**圈子成员(CONTACT + OWNER)，必须已登录
     */
    CIRCLE,

    /**拥有者，必须已登录
     */
    OWNER,

    /**管理员，必须已登录
     */
    ADMIN;

    public static final RequestRole[] ALL = {RequestRole.UNKNOWN};//values();//所有
    public static final RequestRole[] HIGHS;//高级
    static {
        HIGHS = new RequestRole[] {OWNER, ADMIN};
    }

    public static final String[] NAMES = {
            UNKNOWN.name(), LOGIN.name(), CONTACT.name(), CIRCLE.name(), OWNER.name(), ADMIN.name()
    };
}

@MethodAccess(
)
class Verify {

}
