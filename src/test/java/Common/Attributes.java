package Common;

public class Attributes {

    public static class Locator{


        //login
            public static final String whileAllowElement = "com.android.permissioncontroller:id/permission_allow_foreground_only_button";
            public static final String allowElement = "com.android.permissioncontroller:id/permission_allow_button";
            public static final String loginButton = "(//*[@content-desc='Log In'])[2]";
            public static final String assertHome = "//*[@content-desc='Inventory Key Indicators']";
            public static final String assertLogin = "//android.view.View[@content-desc='Log In']";
            public static final String loginText="(//*[@content-desc='Log In'])[1]";

            //home
            public static final String totalXpath="(//*[@class='android.widget.ImageView'])[5]";
            public static final String plusIconXpath="(//*[@class='android.widget.ImageView'])[4]";
            public static final String addAnimalsToInventoryXpath="//*[@index='0' and @class='android.widget.ImageView']";

    }

    public static class TimeOut{
        public static final int sleep3=3000;

        public static final int sleep8=8000;
    }

}
