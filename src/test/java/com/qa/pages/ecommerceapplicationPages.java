package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.android.AndroidDriver;

public class ecommerceapplicationPages {
AndroidDriver driver;

/************************Menu Items***************/
//method to locate menu bar items
@FindAll(@FindBy(className="android.widget.CheckedTextView"))
List<WebElement> menuitems;
public List<WebElement> getMenuItems()
{
return menuitems;
}
/****************************REGISTER*********************************************/

//To Locate Register Button
@FindBy(id="com.studiobluelime.ecommerceapp:id/tv_register")
WebElement registerbtn;
public WebElement getRegisterButton()
{
	return registerbtn;
}
//To locate username text box
@FindBy(id="com.studiobluelime.ecommerceapp:id/et_register_username")
WebElement usernametxtbox;
public WebElement getUserNameTxtBox()
{
	return usernametxtbox;
}
//To Locate mobile number text box
@FindBy(id="com.studiobluelime.ecommerceapp:id/et_register_mno")
WebElement mobilenumber;
public WebElement getMobileNumber()
{
	return mobilenumber;
}
//To locate email text box
@FindBy(id="com.studiobluelime.ecommerceapp:id/et_register_email")
WebElement emailtxtbox;
public WebElement getEmailtxtbox()
{
	return emailtxtbox;
}

//To Locate Password text Box
@FindBy(id="com.studiobluelime.ecommerceapp:id/et_register_password")
WebElement register_password;
public WebElement getRegisterPasswordTxtBox()
{
	return register_password;
}

//Method to locate register button

@FindBy(id="com.studiobluelime.ecommerceapp:id/btn_register")
WebElement btn_register;
public WebElement getBtn_register()
{
	return btn_register;
}





/********************LOGIN******************************************/


// method to locate email text box
@FindBy(id="com.studiobluelime.ecommerceapp:id/et_login_username")
WebElement emailtxtBox;

public WebElement getEmailTxtBox()
{
return emailtxtBox;
}


// method to loacte password text box
@FindBy(id="com.studiobluelime.ecommerceapp:id/et_login_password")
WebElement password;
public WebElement getPasswordTxtBox()
{
return password;
}

// to locate 

//method to locate login button
@FindBy(id="com.studiobluelime.ecommerceapp:id/btn_login")
WebElement loginbtn;
public WebElement getLoginBtn()
{
return loginbtn;
}


/***********************MY ACCOUNT******************************************/

// To locate My Details Button
@FindBy(id="com.studiobluelime.ecommerceapp:id/btn_mydetails")
WebElement mydetails;
public WebElement getMydetalsBtn()
{
return mydetails;
}

//to locate user details
@FindBy(className="android.widget.EditText")
List<WebElement> userdetails;
public List<WebElement> getUserDetails()
{
return userdetails;

}


/***************************ADD TO CART **********************************************/
//method to locate mobile category
@FindBy(xpath="//*[@text='Mobiles']")
WebElement MobileCategory;
public WebElement getMobileCategory()
{
return MobileCategory;	
}
// to locate product
@FindBy(id="com.studiobluelime.ecommerceapp:id/npr_imgview")
WebElement product;
public WebElement getProduct()
{
	return product;
}
// to locate product color
@FindBy(xpath="hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView")
WebElement productcolor;

public WebElement SelectProductColor()
{
	return productcolor;
}

//To locate size selection field
@FindBy(xpath="//*[@text='128gb']")
WebElement size;
public WebElement SelectSize()
{
	return size;
}
// To locate quantity field
@FindBy(id="com.studiobluelime.ecommerceapp:id/pv_txt_quantity")
WebElement quantity;
public WebElement SelectQuantity()
{
	return quantity;
}

//To Locate Add to cart Button
@FindBy(id="com.studiobluelime.ecommerceapp:id/pv_fab_addtocart")
WebElement addtocartbtn;
public WebElement getAddToCartBtn()
{
	return addtocartbtn;
}

//To get product name in cart
@FindBy(id="com.studiobluelime.ecommerceapp:id/shopingcart_productname")
WebElement productname;
public WebElement getProductName()
{
	return productname;
}


public ecommerceapplicationPages(AndroidDriver rDriver) {
this.driver = rDriver;
   PageFactory.initElements(rDriver,this);
}
}
