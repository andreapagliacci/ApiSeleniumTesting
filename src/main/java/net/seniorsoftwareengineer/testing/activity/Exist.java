package net.seniorsoftwareengineer.testing.activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.seniorsoftwareengineer.testing.entitydom.SelectorCss;
import net.seniorsoftwareengineer.testing.exception.TestingException;

/**
 * Exist class extend Activity class for check if exist in dom one element
 * selected by css selector
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(parent = Activity.class, description = "Azione da usare se si vuole controllare l'esistenza in un certo elemento del DOM")
public class Exist extends Activity implements ActivityAction, Serializable {
    @ApiModelProperty(required = true, value = "Exist", example = "Exist")
    @JsonProperty("type")
    private String type;

    @JsonCreator
    public Exist() {
	this.parentId = new ArrayList<String>();
    }

    @JsonCreator(mode = Mode.DEFAULT)
    public Exist(@JsonProperty("type") String type, @JsonProperty("selector") SelectorCss selector) {
	this.type = type;
	this.selector = selector;
	this.parentId = new ArrayList<String>();
    }

    @Override
    public void execute(Optional<WebDriver> driver) throws TestingException {
	this.setDriver(driver);
	final WebElement webElement = testService.getElement(driver, getSelector().getCssSelector());
	if (webElement == null) {
	    close();
	    throw new TestingException(getSelector().getCssSelector(), Exist.class.getName());
	}
    }

}
