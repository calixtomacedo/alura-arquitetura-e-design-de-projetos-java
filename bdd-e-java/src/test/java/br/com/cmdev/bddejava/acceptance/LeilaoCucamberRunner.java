package br.com.cmdev.bddejava.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features =  "classpath:features", tags = "@leilao")
public class LeilaoCucamberRunner {

}
