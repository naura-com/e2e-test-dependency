package com.naura.test;

import com.github.leeonky.jfactory.Spec;
import com.naura.test.ui.MockLower;

import java.net.MalformedURLException;

public class JFactoryDemo {

    public static void main(String[] args) throws MalformedURLException {
//        JFactory jFactory = new JFactory();
//        Person person = jFactory.create(Person.class);
//        System.out.println("person = " + person);
//
//        person = jFactory.type(Person.class).property("name", "Tom").create();
//        System.out.println("person = " + person);
//
//        person = jFactory.createAs(Girl.class);
//        System.out.println("person = " + person);
//
//        person = jFactory.spec(Girl.class).property("name", "Lucy").property("age", 5).create();
//        System.out.println("person = " + person);
//
//        jFactory.register(Girl.class);
//
//        person = jFactory.createAs("Girl");
//        System.out.println("person = " + person);

//        DesiredCapabilities desktopCapabilities = new DesiredCapabilities();
//        desktopCapabilities.setCapability("platformName", "Windows");
//        desktopCapabilities.setCapability("deviceName", "WindowsPC");
//        desktopCapabilities.setCapability("app", "Root");
//
//        WindowsDriver<RemoteWebElement> DesktopSession = new WindowsDriver<RemoteWebElement>(new URL("http://127.0.0.1:4723/wd/hub"), desktopCapabilities);
//        WebElement MAWebElement = DesktopSession.findElementByName("FormRecipe");
//        String MAWinHandleStr = MAWebElement.getAttribute("NativeWindowHandle");
//        int MAWinHandelHex = Integer.parseInt(MAWinHandleStr);
//        String MAWinHandleHex = Integer.toHexString(MAWinHandelHex);
//
//        DesiredCapabilities MACapabilities = new DesiredCapabilities();
//        MACapabilities.setCapability("platformName", "Windows");
//        MACapabilities.setCapability("deviceName", "WindowsPC");
//        MACapabilities.setCapability("appTopLevelWindow", MAWinHandleHex);
//
//        WindowsDriver MASession = new WindowsDriver(new URL("http://127.0.0.1:4723/wd/hub"), MACapabilities);
//
//        MASession.findElementById("mRcpNew_btn").click();

        MockLower mockLower1 = new MockLower();
        mockLower1.reset();
        mockLower1.start();


    }


    public static class Girl extends Spec<Person> {

        @Override
        public void main() {
            property("name").value("Hello");
            property("gender").value("female");
            property("age").value(18);
        }
    }


    public static class Person {
        public String name, gender;
        public int age;

        @Override
        public String toString() {
            return "Person{" + "name='" + name + '\'' + ", gender='" + gender + '\'' + ", age=" + age + '}';
        }


    }
}
