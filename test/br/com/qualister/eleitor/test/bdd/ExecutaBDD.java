package br.com.qualister.eleitor.test.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"criterios"}, format={"pretty", "html:target/bdd"})
public class ExecutaBDD {

}
