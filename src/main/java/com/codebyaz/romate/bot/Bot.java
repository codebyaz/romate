package com.codebyaz.romate.bot;

import com.codebyaz.romate.instruction.Instruction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.List;

public class Bot {

    @Autowired
    private WebDriver driver;

    private List<Instruction> instructions;

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    private WebElement getElement(By locator) {
        return this.driver.findElement(locator);
    }

    public void get(String url) {
        this.driver.get(url);
    }

    public void type (By locator, String text) {
        WebElement element = this.getElement(locator);

        element.sendKeys(text);
    }

    public void click (By locator) {
        WebElement element = this.getElement(locator);

        element.click();
    }

    public void executeInstructions() {

        for (Instruction instruction : this.instructions) {
            String input = null;
            By locator = null;

            if(instruction.getAction().hasInput()) {
                input = instruction.getInput();
            }

            if(instruction.getAction().hasLocator()) {
                String locatorParameter = instruction.getLocatorParameter();
                locator = instruction.getLocator().transformToLocator(locatorParameter);
            }

            switch(instruction.getAction().getSlug()) {
                case "type":
                    this.type(locator, input);
                    break;
                case "click":
                    this.click(locator);
                    break;
                case "get":
                    this.get(input);
                    break;
            }
        }
    }
}
