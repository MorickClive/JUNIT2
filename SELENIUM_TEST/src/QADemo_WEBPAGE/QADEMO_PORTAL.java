package QADemo_WEBPAGE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QADEMO_PORTAL {
	
	final private String URL = "http://demoqa.com/";
	
	@FindBy(xpath = "//*[@id='menu-item-374']/a")
	private WebElement Registration;
	
	// Interaction
	@FindBy(xpath = "//*[@id='menu-item-140']/a")
	private WebElement Draggable;
	@FindBy(xpath = "//*[@id='menu-item-141']/a")
	private WebElement Droppable;
	@FindBy(xpath = "//*[@id='menu-item-143']/a")
	private WebElement Resizable;
	@FindBy(xpath = "//*[@id='menu-item-142']/a")
	private WebElement Selectable;
	@FindBy(xpath = "//*[@id='menu-item-151']/a")
	private WebElement Sortable;
	
	// Widget
	@FindBy(xpath = "//*[@id='menu-item-144']/a")
	private WebElement Accordion;
	@FindBy(xpath = "//*[@id='menu-item-145']/a")
	private WebElement Autocomplete;
	@FindBy(xpath = "//*[@id='menu-item-146']/a")
	private WebElement DatePicker;
	@FindBy(xpath = "//*[@id='menu-item-147']/a")
	private WebElement Menu;
	@FindBy(xpath = "//*[@id='menu-item-97']/a")
	private WebElement Slider;
	@FindBy(xpath = "//*[@id='menu-item-98']/a")
	private WebElement Tabs;
	@FindBy(xpath = "//*[@id='menu-item-99']/a")
	private WebElement Tooltip;
	
	// Frames and Windows
	@FindBy(xpath = "//*[@id='menu-item-148']/a")
	private WebElement Frame_Windows;
	
	// Registration
	public void Nav_Register(){	Registration.click();}
	
	// Interaction
	public void Nav_Interaction_Draggable(){	Draggable.click();}
	public void Nav_Interaction_Droppable(){	Droppable.click();}
	public void Nav_Interaction_Resizable(){	Resizable.click();}
	public void Nav_Interaction_Selectable(){	Selectable.click();}
	public void Nav_Interaction_Sortable(){		Sortable.click();}
	
	// Widget
	public void Nav_Widget_Accordion(){		Accordion.click();}
	public void Nav_Widget_Autocomplete(){	Autocomplete.click();}
	public void Nav_Widget_DatePicker(){	DatePicker.click();}
	public void Nav_Widget_Menu(){			Menu.click();}
	public void Nav_Widget_Slider(){		Slider.click();}
	public void Nav_Widget_Tabs(){			Tabs.click();}
	public void Nav_Widget_Tooltip(){		Tooltip.click();}
	
	// Frame and Windows
	public void Nav_FramesANDWindows(){		Frame_Windows.click();}
	
	// Behaviours
	public String getURL(){ return URL;}
}
