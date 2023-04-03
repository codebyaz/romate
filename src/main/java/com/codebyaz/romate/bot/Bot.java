package com.codebyaz.romate.bot;

import com.codebyaz.romate.action.Action;
import com.codebyaz.romate.instruction.Instruction;
import com.codebyaz.romate.locator.Locator;
import com.codebyaz.romate.task.Task;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class Bot {

    @Autowired
    private WebDriver driver;

    private WebElement findElement(By locator) {
        return this.driver.findElement(locator);
    }

    public void get(String url) {
        this.driver.get(url);
    }

    public void type (WebElement element, String text) {
        element.sendKeys(text);
    }

    public void click (WebElement element) {
        element.click();
    }

    public String getText (WebElement element) {
        return element.getText();
    }

    public void execute(Task task) {
        task.getInstructions().stream().map(instruction -> {

            Action action = instruction.getAction();
            String input = instruction.getInput();
            Locator locator = instruction.getLocator();
            WebElement element = null;
            if (locator != null)
                element = this.findElement(locator.get(instruction.getLocatorParameter()));

            switch (action.getSlug()) {
                case TYPE -> this.type(element, input);
                case CLICK -> this.click(element);
                case NAVIGATE -> this.get(input);
            }

            return true;

        }).toList();
    }
}
