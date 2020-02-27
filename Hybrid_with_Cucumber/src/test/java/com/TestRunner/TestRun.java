package com.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

// If you want run the multiple "feature" files then add the {".//Features//AddCustomer.feature",.//Features//login.feature},
// add the within the flower braces{}
// if you want execute the total feature files- you given the only "feature" folder name thats it
// no need to specify the name of the feature file

@CucumberOptions
	(
		features= {".//Features//AddCustomer.feature"},
		glue= "com.StepDefinitions",
	
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:test-output"},
		tags= {"@sanity"}
)
// here "dryRun=false"-its cross check the every stepDefinition on the Feature file correspondingly correct or not
//	every step in the feature file its having the corresponding step inside the .java or not
//	before executing my feature file in the runtime before I cross checking everything is correctly aligned or not
// here "pretty" is an parameter -its shows the output of the console is very clearly
// here "monochrome=true,"-it will remove unnecessery characters (errors) in the console window 
// if you want execute the specific Test scenario -you should create "@tags"(here @sanity is not a unique name -as your like any name you may given here)
// if you want execute the specific 2 or more test scenarios-("@sanity,@regression") 

public class TestRun {

	
}
